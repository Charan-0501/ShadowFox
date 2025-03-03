package org.example.DataBase;
import org.example.Entity.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.Entity.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Dao {

        private static final String URL = "jdbc:sqlite:library.db"; // SQLite database file

        public Dao() {
            createTableIfNotExists();
        }

        // ✅ Create Books table if it doesn’t exist
        private void createTableIfNotExists() {
            String sql = "CREATE TABLE IF NOT EXISTS books (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "author TEXT NOT NULL, " +
                    "price REAL NOT NULL, " +
                    "isAvailable BOOLEAN NOT NULL DEFAULT 1)";
            try (Connection conn = DriverManager.getConnection(URL);
                 Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("Table 'books' created or already exists.");
            } catch (SQLException e) {
                System.err.println("Error creating table: " + e.getMessage());
            }
        }

        // ✅ Add a book to the database
        public void addBook(Entity book) {
            String sql = "INSERT INTO books (name, author, price, isAvailable) VALUES (?, ?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(URL);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, book.getBookName());
                pstmt.setString(2, book.getBookAuthor());
                pstmt.setFloat(3, book.getBookPrice());
                pstmt.setBoolean(4, book.isBookAvailable());
                pstmt.executeUpdate();
                System.out.println("Book added successfully.");
            } catch (SQLException e) {
                System.err.println("Error adding book: " + e.getMessage());
            }
        }

        // ✅ Remove a book by name
        public boolean removeBook(String bookName) {
            String sql = "DELETE FROM books WHERE name = ?";
            try (Connection conn = DriverManager.getConnection(URL);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, bookName);
                int rowsAffected = pstmt.executeUpdate();
                return rowsAffected > 0; // Returns true if deletion was successful
            } catch (SQLException e) {
                System.err.println("Error removing book: " + e.getMessage());
                return false;
            }
        }

        // ✅ Get book by name
        public Entity getBookByName(String bookName) {
            String sql = "SELECT * FROM books WHERE name = ?";
            try (Connection conn = DriverManager.getConnection(URL);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, bookName);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    return new Entity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("author"),
                            rs.getFloat("price"),
                            rs.getBoolean("isAvailable")
                    );
                }
            } catch (SQLException e) {
                System.err.println("Error fetching book by name: " + e.getMessage());
            }
            return null;
        }

        // ✅ Get all books from the database
        public List<Entity> getAllBooks() {
            List<Entity> books = new ArrayList<>();
            String sql = "SELECT * FROM books";
            try (Connection conn = DriverManager.getConnection(URL);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    books.add(new Entity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("author"),
                            rs.getFloat("price"),
                            rs.getBoolean("isAvailable")
                    ));
                }
            } catch (SQLException e) {
                System.err.println("Error fetching all books: " + e.getMessage());
            }
            return books;
        }

        // ✅ Get books by author
        public List<Entity> getBooksByAuthor(String author) {
            List<Entity> books = new ArrayList<>();
            String sql = "SELECT * FROM books WHERE author = ?";
            try (Connection conn = DriverManager.getConnection(URL);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, author);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    books.add(new Entity(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("author"),
                            rs.getFloat("price"),
                            rs.getBoolean("isAvailable")
                    ));
                }
            } catch (SQLException e) {
                System.err.println("Error fetching books by author: " + e.getMessage());
            }
            return books;
        }

        // ✅ Update book availability
        public void updateBookAvailability(Entity book) {
            String sql = "UPDATE books SET isAvailable = ? WHERE name = ?";
            try (Connection conn = DriverManager.getConnection(URL);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setBoolean(1, book.isBookAvailable());
                pstmt.setString(2, book.getBookName());
                pstmt.executeUpdate();
                System.out.println("Book availability updated successfully.");
            } catch (SQLException e) {
                System.err.println("Error updating book availability: " + e.getMessage());
            }
        }
}
