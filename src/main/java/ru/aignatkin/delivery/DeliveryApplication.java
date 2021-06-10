package ru.aignatkin.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.aignatkin.delivery.database.DatabaseHandler;
import java.sql.SQLException;

@SpringBootApplication
public class DeliveryApplication {
    public static void main (String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);

        // подключаемся к БД
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            databaseHandler.getDbConnection();
            databaseHandler.read();
            databaseHandler.closeDbConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("Test");

    }
}
