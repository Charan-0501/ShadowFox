package org.example;

import java.util.Scanner;

public class Main {

    static boolean isContinues=true;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        do {

            ContactAdmin manager = new ContactManager();
            System.out.println("\nWelcome To Contact Manager,What you like to do");
            System.out.println("------------------------------------------------------");
            System.out.println("1.Create new contact \n2.View my contacts \n3.Update Contact Info \n4.Delete a contact\n5.Exit");
            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1: manager.addContact();
                        break;
                case 2: manager.seeContacts();
                        break;
                case 3: manager.updateContact();
                        break;
                case 4: manager.deleteContact();
                        break;
                case 5: manager.exitContact();
                        break;
                default:
                        System.out.println("Please enter a valid operation");

            }

        }while(isContinues);

    }
}