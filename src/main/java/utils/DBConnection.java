package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    final static String DB_NAME = "learning_Logs";
    final static String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    final static String DB_USERNAME = "root";
    final static String DB_PASSWORD = "12345678";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
    }

}
