package ru.aignatkin.delivery.database;

import ru.aignatkin.delivery.coordinate.Coordinate;
import ru.aignatkin.delivery.exception.DeliveryPointException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class DatabaseHandler extends Config {
    public static Connection connection;

    public void getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;
        this.connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
    }

    public void closeDbConnection() throws ClassNotFoundException, SQLException {
        this.connection.close();
    }
}
