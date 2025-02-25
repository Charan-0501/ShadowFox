package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean isContinues=true;
        do {
            ContactManager manager = new ContactManager();
            System.out.println("Welcome To Contact Manager,What you like to do");
            System.out.println("------------------------------------------------------");
            System.out.println("1.Create new contact \n2.Read all my contacts \n3.Update Contact Info \n4.Delete a contact\n5.Exit");
            int n = sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1: manager.addContact();
                        break;
                case 2: ContactManager.seeContacts();
                        break;
                case 4:
                    if(!ContactManager.list.isEmpty()) {
                        System.out.println("Enter name of the contact you want to delete");
                        manager.deleteContact(sc.nextLine());
                    }
                    else {
                        System.out.println("No Contacts to Delete");
                    }
                    break;
                case 5: isContinues=false;
                        System.out.println("\n---- Bye Now ! ----");
                        break;
                default:
                    System.out.println("Please enter a valid operation");

            }
        }while(isContinues);

    }
}