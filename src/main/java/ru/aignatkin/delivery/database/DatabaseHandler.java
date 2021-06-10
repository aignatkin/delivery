package ru.aignatkin.delivery.database;

import ru.aignatkin.delivery.model.DeliveryPoints;

import java.sql.*;

public class DatabaseHandler extends Configs {
    private static Connection connection;

    public void getDbConnection () throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;
        this.connection = DriverManager.getConnection(connectionString, dbUser, dbPass);

    }

    public void closeDbConnection () throws ClassNotFoundException, SQLException {
        this.connection.close();
    }

    public void read () throws ClassNotFoundException, SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM DeliveryPoints");

        while (resultSet.next()) {
            DeliveryPoints deliveryPoints = new DeliveryPoints();

            deliveryPoints.setName(resultSet.getString("id_name"));

            System.out.println(deliveryPoints.getName());
        }
    }
}