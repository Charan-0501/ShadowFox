package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    static ArrayList<Contacts> list =new ArrayList<>();

//   public ContactManager(){
////
////        list=new ArrayList<>();
////
//        list.add(new Contacts("charan",7386215653L,"sunny@gmail.com"));
//////        list.add(new Contacts("venkat",9393848777L,"venkat@gmail.com"));
////
//   }
    Scanner sc=new Scanner(System.in);

    public void addContact(){

            System.out.println("Enter name of the contact");
            String name = sc.nextLine();
            System.out.println("Enter phone number");
            long number = sc.nextLong();
            System.out.println("Enter email");
            sc.nextLine();
            String mail = sc.nextLine();
            list.add(new Contacts(name, number, mail));
            System.out.println("Contact Added Successfully");

    }

    public static void seeContacts() {

        if (list.isEmpty()) {
            System.out.println("You have no contacts ,please create one to view");
        } else {

            //System.out.println(list);

            for (Contacts i : list) {
                System.out.println(i);
            }
        }
    }

    public void deleteContact(String s) {

        if (list.isEmpty()) {
            System.out.println("You have no contacts ,please create one to view");
//            return;
        } else {
            boolean found = false;
            for (Contacts i : list) {
                if (i.getName().equalsIgnoreCase(s)) {
                    found = true;
                    list.remove(i);
                    //System.out.println("Contact Deleted successfully");
                }
            }
            if (found) {
                System.out.println("Contact Deleted successfully");
            } else {
                System.out.println("No contact mathched with that number");
            }
        }
    }

}

