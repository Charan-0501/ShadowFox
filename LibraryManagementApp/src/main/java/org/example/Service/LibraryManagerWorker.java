package org.example.Service;
import org.example.DataBase.Dao;
import org.example.Main;
import org.example.Entity.Entity;

import java.util.Scanner;

import java.util.List;
public class LibraryManagerWorker {

        private final Dao libraryDAO;
        private final Scanner sc;

        public LibraryManagerWorker() {
            this.libraryDAO = new Dao();
            this.sc = new Scanner(System.in);
        }

        public void addBook() {
            System.out.println("Enter Book Name:");
            String name = sc.nextLine();
            System.out.println("Enter Book Price:");
            float price = sc.nextFloat();
            sc.nextLine();
            System.out.println("Enter Author Name:");
            String author = sc.nextLine();

            Entity book = new Entity(name, author, price);
            libraryDAO.addBook(book);
            //System.out.println("\nBook added successfully!");
        }

        public void removeBook() {
            System.out.println("Enter name of the book to remove:");
            String bookName = sc.nextLine();

            boolean removed = libraryDAO.removeBook(bookName);
            if (removed) {
                System.out.println("Book removed successfully.");
            } else {
                System.out.println("No book found with that name.");
            }
        }

        public void updateBook() {
            System.out.println("Enter the Book name you want to update:");
            String bookName = sc.nextLine();
            Entity book = libraryDAO.getBookByName(bookName);

            if (book != null) {
                System.out.println("You can only update book availability.");
                System.out.println("\nIs book available? (true/false): ");
                boolean isAvailable = sc.nextBoolean();
                sc.nextLine();  // Consume newline

                book.setBookAvailable(isAvailable);
                libraryDAO.updateBookAvailability(book);
                System.out.println("Book availability updated successfully.");
            } else {
                System.out.println("No book found with that name.");
            }
        }

        public void searchBookByAuthor() {
            System.out.println("Enter Author name:");
            String author = sc.nextLine();
            List<Entity> books = libraryDAO.getBooksByAuthor(author);

            if (books.isEmpty()) {
                System.out.println("No books found by " + author);
            } else {
                for (Entity book : books) {
                    System.out.println(book);
                }
            }
        }

        public void searchBookByName() {
            System.out.println("Enter Book Name:");
            String bookName = sc.nextLine();
            Entity book = libraryDAO.getBookByName(bookName);

            if (book != null) {
                System.out.println(book);
            } else {
                System.out.println("No book found with that name.");
            }
        }

        public void displayBooks() {
            List<Entity> books = libraryDAO.getAllBooks();

            if (books.isEmpty()) {
                System.out.println("No books available in the library.");
            } else {
                for (Entity book : books) {
                    System.out.println(book);
                }
            }
        }
}
