package org.example.Service;

import org.example.Entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface LibraryManager {
    List<Entity> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void addBook();
    void removeBook();
    void updateBook();
    void searchBookByAuthor();
    void searchBookByName();
    void displayBooks();


}
