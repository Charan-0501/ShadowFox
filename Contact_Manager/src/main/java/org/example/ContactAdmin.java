package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public interface ContactAdmin {

    Scanner sc= new Scanner(System.in);

    ArrayList<Contacts> list = new ArrayList<>();

    void addContact();
    void seeContacts();
    void updateContact();
    void deleteContact();
    void exitContact();

}
