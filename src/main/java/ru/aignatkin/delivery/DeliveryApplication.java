package ru.aignatkin.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;

@SpringBootApplication
public class DeliveryApplication {
    private static Logger log = Logger.getLogger(DeliveryApplication.class.getName());

    public static void main (String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
        log.info("Application started");

        // подключаемся к БД
//        DatabaseHandler databaseHandler = new DatabaseHandler();
//        try {
//            databaseHandler.getDbConnection();
//            databaseHandler.read();
//            databaseHandler.closeDbConnection();
//        } catch (ClassNotFoundException e) {
//            log.log(Level.SEVERE, "Exception: ", e);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }
}
