package org.example;
import org.example.Service.LibraryManager;
import org.example.Service.LibraryManagerWorker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static boolean isContinues = true;

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        LibraryManager manager=new LibraryManagerWorker();
        do {
            System.out.println("\nWelcome To Library,How Can I help You");
            System.out.println("------------------------------------------------------");
            System.out.println("1.Add New Book\n2.Display Booklist\n3.Update Book Details\n4.Remove Book\n6.search7.Exit");
            try {
                int n = sc.nextInt();
                sc.nextLine();
                switch (n) {
                    case 1:
                        manager.addBook();
                        break;
                    case 2:
                        manager.displayBooks();
                        break;
                    case 3:
                        manager.updateBook();
                        break;
                    case 4:
                        manager.removeBook();
                        break;
                    case 5:
                        manager.exitLibrary();
                        break;
                    default:
                        System.out.println("Please enter a valid operation");

                }
            }catch( InputMismatchException ex1){
                System.out.println("*** Invalid Input ***\nPlease Enter a number");
                sc.nextLine();
            }
        }while (isContinues) ;

    }

}