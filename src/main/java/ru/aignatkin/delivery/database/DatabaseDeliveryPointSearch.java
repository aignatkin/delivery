package ru.aignatkin.delivery.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.aignatkin.delivery.coordinate.Coordinate;
import ru.aignatkin.delivery.exception.DeliveryPointException;
import ru.aignatkin.delivery.service.DeliveryPointsServiceImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class DatabaseDeliveryPointSearch extends DatabaseHandler {
    private static Logger log = Logger.getLogger(DeliveryPointsServiceImpl.class.getName());

    private Float searchSquareSize;
    private Float searchSizingStep;
    private Integer searchIterationNum;
    private Integer searchCount;

    private final String parameterSearchStartSquareSize = "search.start.square.size";
    private final String parameterSearchSizingStep = "search.sizing.step";
    private final String parameterSearchIteration = "search.iteration";
    private final String parameterSearchCount = "search.count";

    Properties property;
    Coordinate coordinate;;

    public DatabaseDeliveryPointSearch(Properties property, Coordinate coordinate){
        this.property = property;
        this.coordinate = coordinate;

        FileInputStream applicationProperties;

        try {
            applicationProperties = new FileInputStream(applicationPropertiesPath);
            property.load(applicationProperties);

            this.searchSquareSize = Float.parseFloat(property.getProperty(parameterSearchStartSquareSize)); // начальный размер квадрат поиска
            this.searchSizingStep = Float.parseFloat(property.getProperty(parameterSearchSizingStep)); // шаг увеличения квадрата поиска
            this.searchIterationNum = Integer.parseInt(property.getProperty(parameterSearchIteration)); // количество итераций расширения зоны поиска
            this.searchCount = Integer.parseInt(property.getProperty(parameterSearchCount)); // количество искомых точек в квадрате


        } catch (IOException e) {
            log.log(Level.SEVERE, "Config file \"" + applicationPropertiesPath + "\" not found", e.getMessage());
        }
    }

    public List<String> getNearest(float coordinate_w, float coordinate_l) throws ClassNotFoundException, SQLException, DeliveryPointException {
        if (searchSquareSize.equals(0)) {
            new DeliveryPointException("Parameter \"" + parameterSearchStartSquareSize + "\" mast not to be 0 in a config file \"" + applicationPropertiesPath + "\"");
            return null;
        }

        if (searchSizingStep.equals(0)) {
            new DeliveryPointException("Parameter \"" + parameterSearchSizingStep + "\" mast not to be 0 in a config file \"" + applicationPropertiesPath + "\"");
            return null;
        }

        if (searchIterationNum.equals(0)) {
            new DeliveryPointException("Parameter \"" + parameterSearchIteration + "\" mast not to be 0 in a config file \"" + applicationPropertiesPath + "\"");
            return null;
        }

        // инициализация переменных
        List<String> findedRows = new ArrayList<>();
        List<DeliveryPointBuffer> deliveryPointBufferList = new ArrayList<>();
        String sqlQuery;
        String sqlWhere = "";
        Integer rowsCount = 0;
        Integer i = 0;
        ResultSet resultSet = null;

        // подключаемся к базе
        super.getDbConnection();
        Statement statement = connection.createStatement();

        // ищём квадрат с ребуемым количеством точек
        while (i < searchIterationNum) {
            sqlWhere = String.format("(coordinate_l BETWEEN " + (coordinate_l - searchSquareSize - i * searchSizingStep) + " AND " + (coordinate_l + searchSquareSize + i * searchSizingStep) + ") AND " +
                    "(coordinate_w BETWEEN " + (coordinate_w - searchSquareSize - i * searchSizingStep) + " AND " + (coordinate_w + searchSquareSize + i * searchSizingStep) + ")");
            sqlQuery = "SELECT COUNT(*) AS rowcount FROM delivery_points WHERE " + sqlWhere;

            connection.prepareStatement(sqlQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //System.out.println(sqlQuery);
            resultSet = statement.executeQuery(sqlQuery);

            resultSet.next();
            rowsCount = resultSet.getInt("rowcount");

            if(rowsCount >= searchCount) {break;}
            i++;
        }

        if(rowsCount > 0) {
            sqlQuery = "SELECT id_name, coordinate_l, coordinate_w FROM delivery_points WHERE " + sqlWhere;
            resultSet = statement.executeQuery(sqlQuery);

            // Формирум буффер, считаем расстояния
            while (resultSet.next()) {
                DeliveryPointBuffer deliveryPointBuffer = new DeliveryPointBuffer();
                deliveryPointBuffer.setName(resultSet.getString("id_name"));
                deliveryPointBuffer.setCoordinates_w(resultSet.getFloat("coordinate_w"));
                deliveryPointBuffer.setCoordinates_l(resultSet.getFloat("coordinate_l"));
                deliveryPointBuffer.setDistance(coordinate.getDistance(coordinate_w, coordinate_l, deliveryPointBuffer.getCoordinates_w(), deliveryPointBuffer.getCoordinates_l()));

                deliveryPointBufferList.add(deliveryPointBuffer);
            }

            // сортируем и формируем ответ
            i = 0;
            deliveryPointBufferList.sort(Comparator.comparing(DeliveryPointBuffer -> DeliveryPointBuffer.getDistance()));
            for(DeliveryPointBuffer deliveryPointBuffer : deliveryPointBufferList) {
                findedRows.add(deliveryPointBuffer.getName());
                i++;
                if (i >= searchCount) {break;}
            }

            super.closeDbConnection();

            return findedRows;
        } else {
            return null;
        }
    }
}
