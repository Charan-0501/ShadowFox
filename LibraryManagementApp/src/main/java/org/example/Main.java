package org.example;

import org.example.DataBase.Dao;
import org.example.DataBase.databaseConnection;
import org.example.Entity.Entity;
import org.example.Service.LibraryManagerWorker;

import java.util.List;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            LibraryManagerWorker libraryService = new LibraryManagerWorker();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n===== Library Management System =====");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Update Book Availability");
                System.out.println("4. Search Book by Name");
                System.out.println("5. Search Books by Author");
                System.out.println("6. Display All Books");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        libraryService.addBook();
                        break;
                    case 2:
                        //System.out.print("Enter book name to remove: ");
                        //String removeBook = sc.nextLine();
                        libraryService.removeBook();
                        break;
                    case 3:
                        libraryService.updateBook();
                        break;
                    case 4:
                        //System.out.print("Enter book name to search: ");
                        //String searchName = sc.nextLine();
                        libraryService.searchBookByName();
                        break;
                    case 5:
                       // System.out.print("Enter author name to search books: ");
                        //String searchAuthor = sc.nextLine();
                        libraryService.searchBookByAuthor();
                        break;
                    case 6:
                        libraryService.displayBooks();
                        break;
                    case 7:
                        System.out.println("Exiting Library Management System...");
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }

}
