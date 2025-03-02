package org.example.DataBase;
import org.example.Entity.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Dao {

        private static final String URL = "jdbc:sqlite:library.db";

        // Add a book to the database
        public void addBook(Entity book) {
            String sql = "INSERT INTO books (title, author, price, available) VALUES (?, ?, ?, ?)";

            try (Connection conn = DriverManager.getConnection(URL);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, book.getBookName());
                pstmt.setString(2, book.getBookAuthor());
                pstmt.setFloat(3, book.getBookPrice());
                pstmt.setBoolean(4, book.isBookAvailable());

                pstmt.executeUpdate();
                System.out.println("Book added successfully!");

            } catch (SQLException e) {
                System.out.println("Error adding book: " + e.getMessage());
            }
        }

        // Fetch all books from the database
        public List<Entity> getAllBooks() {
            List<Entity> books = new ArrayList<>();
            String sql = "SELECT * FROM books";

            try (Connection conn = DriverManager.getConnection(URL);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    books.add(new Entity(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getFloat("price"),
                            rs.getBoolean("available")
                    ));
                }
            } catch (SQLException e) {
                System.out.println("Error fetching books: " + e.getMessage());
            }

            return books;
        }

        // Delete a book by ID
        public void deleteBook(int bookId) {
            String sql = "DELETE FROM books WHERE id = ?";

            try (Connection conn = DriverManager.getConnection(URL);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, bookId);
                int rowsDeleted = pstmt.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Book deleted successfully!");
                } else {
                    System.out.println("No book found with the given ID.");
                }

            } catch (SQLException e) {
                System.out.println("Error deleting book: " + e.getMessage());
            }
        }

}
