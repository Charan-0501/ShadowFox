package org.example.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class databaseConnection {
        private static final String URL = "jdbc:sqlite:library.db";

        public static Connection connect() {
            try {
                return DriverManager.getConnection(URL);
            } catch (SQLException e) {
                System.out.println("Database connection failed: " + e.getMessage());
                return null;
            }
        }

        public static void createTable() {
            String sql = "CREATE TABLE IF NOT EXISTS books ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "name TEXT NOT NULL, "
                    + "author TEXT NOT NULL, "
                    + "price REAL NOT NULL, "
                    + "isAvailable BOOLEAN NOT NULL DEFAULT 1)";
            try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("Books table created successfully.");
            } catch (SQLException e) {
                System.out.println("Error creating table: " + e.getMessage());
            }
        }

    }
