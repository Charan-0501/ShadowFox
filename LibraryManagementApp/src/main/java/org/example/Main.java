package org.example;

import org.example.DataBase.Dao;
import org.example.DataBase.databaseConnection;
import org.example.Entity.Entity;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        databaseConnection.createTable(); 
        Dao bookDAO = new Dao();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n Library Management System ");
            System.out.println("1 Add Book");
            System.out.println("2 View Books");
            System.out.println("3 Delete Book");
            System.out.println("4 Exit");
            System.out.print("Enter your choice: ");


            if (!sc.hasNextInt()) {
                System.out.println("--- Invalid input! Please enter a number---");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print(" Enter author: ");
                    String author = sc.nextLine();
                    System.out.print(" Enter price: ");


                    if (!sc.hasNextFloat()) {
                        System.out.println(" Invalid input! Please enter a valid price.");
                        sc.next();
                        continue;
                    }

                    float price = sc.nextFloat();

                    Entity newBook = new Entity(title, author, price);
                    bookDAO.addBook(newBook);
                    break;

                case 2:
                    List<Entity> books = bookDAO.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println(" No books available.");
                    } else {
                        System.out.println("\n Available Books:");
                        for (Entity book : books) {
                            System.out.println(book);
                        }
                    }
                    break;

                case 3:
                    System.out.print(" Enter book ID to delete: ");


                    if (!sc.hasNextInt()) {
                        System.out.println(" Invalid input! Please enter a valid book ID.");
                        sc.next();
                        continue;
                    }

                    int bookId = sc.nextInt();
                    bookDAO.deleteBook(bookId);
                    break;

                case 4:
                    System.out.println(" Exiting... Thank you for using the Library Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice! Please select a valid option.");
            }
        }
    }
}
