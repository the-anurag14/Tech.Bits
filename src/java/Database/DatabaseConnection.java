package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        // Try modern MySQL CJ driver first, fallback to legacy
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            Class.forName("com.mysql.jdbc.Driver");
        }

        String dbHost = System.getenv("DB_HOST") != null ? System.getenv("DB_HOST") : "localhost";
        String dbPort = System.getenv("DB_PORT") != null ? System.getenv("DB_PORT") : "3306";
        String dbName = System.getenv("DB_NAME") != null ? System.getenv("DB_NAME") : "hospital";
        String dbUsername = System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root";
        String dbPassword = System.getenv("DB_PASS") != null ? System.getenv("DB_PASS") : "root";

        String dbURL = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName 
                     + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF-8";

        return DriverManager.getConnection(dbURL, dbUsername, dbPassword);
    }
}
