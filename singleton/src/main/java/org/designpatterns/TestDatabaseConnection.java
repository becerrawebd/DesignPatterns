package org.designpatterns;

import java.sql.SQLException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestDatabaseConnection {
    private static final Logger logger = Logger.getLogger(TestDatabaseConnection.class.getName());
    private static final String URL = "jdbc:mysql://localhost:3306/database_singleton";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    public static void main(String[] args) {
        logger.setLevel(Level.ALL);
        DatabaseConnection conn = null;
        try {
            conn = DatabaseConnection.getConnection(URL,USER,PASSWORD);
            logger.log(Level.INFO,"Conectado existosamente a la base de datos");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Fallo la conexion a la base de datos");
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.closeConnection();
                }
                logger.log(Level.INFO,"Desconectado existosamente a la base de datos");
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Fallo la desconexion a la base de datos");
                throw new RuntimeException(e);
            }
        }
    }
}