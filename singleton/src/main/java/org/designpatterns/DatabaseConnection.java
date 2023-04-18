package org.designpatterns;

import java.sql.*;

public class DatabaseConnection {
    private static DatabaseConnection databaseConnection;
    private final Connection connection;

    private DatabaseConnection(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url,username,password);
    }

    public static DatabaseConnection getConnection(String url, String username, String password) throws SQLException {
        if(databaseConnection == null){
            databaseConnection = new DatabaseConnection(url, username, password);
        }
        return databaseConnection;
    }

    public void closeConnection() throws SQLException {
        if(this.connection != null){
            this.connection.close();
        }
    }

}
