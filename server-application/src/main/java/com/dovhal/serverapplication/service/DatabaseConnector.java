package com.dovhal.serverapplication.service;

import java.io.IOException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.Properties;



public class DatabaseConnector {

    private static final DatabaseConnector instance  = new DatabaseConnector();
    private final static String CONNECTION_TEMPLATE = "jdbc:postgresql://{0}:{1}/{2}";
    private final static String CONNECTION_PROPERTIES = "connection.properties";
    private final Connection dbConnection;

    public static DatabaseConnector getInstance() {
        return instance;
    }


    public ResultSet Query(String sql){
        try {
            final PreparedStatement statement = this.getDbConnection().prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(MessageFormat.format("Error while querying SQL", e.getMessage()));
        }
    }

    public DatabaseConnector() {
        this.dbConnection = initDbConnection(loadConnectionProps());
    }

    private Connection initDbConnection(Properties props) {
        final Connection connection;
        final String connectionString = MessageFormat.format(CONNECTION_TEMPLATE,
                props.getProperty("host"),
                props.getProperty("port"),
                props.getProperty("database"));
        System.out.println("Connected to " + connectionString);
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    connectionString,
                    props.getProperty("user"),
                    props.getProperty("password"));
        } catch (ClassNotFoundException | RuntimeException e) {
            throw new RuntimeException(MessageFormat.format("Driver not found: {0}", e.getMessage()));
        } catch (SQLException e) {
            throw new RuntimeException(MessageFormat.format("Error while querying SQL: {0}", e.getMessage()));
        }
        return connection;
    }
    private Properties loadConnectionProps() {
        final Properties properties = new Properties();
        try {
            properties.load(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(CONNECTION_PROPERTIES)));
        } catch (IOException e) {
            System.err.println(MessageFormat.format("Error while loading properties: {0}", e.getMessage()));
        }
        return properties;
    }

    private Connection getDbConnection() {
        return dbConnection;
    }
}

