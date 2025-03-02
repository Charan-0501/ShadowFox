package org.example.Service;

import org.example.Entity.Entity;

public class LibraryManagerWorker implements LibraryManager{
    public void addBook(){
        System.out.println("Enter Book Name");
        String name = sc.nextLine();
        System.out.println("Enter Book price");
        float moneyy=sc.nextFloat();
        sc.nextLine();
        System.out.println("Enter Author name");
        String authorName = sc.nextLine();
        list.add(new Entity(name,authorName,moneyy));
        System.out.println("\nBook added successfully");
    }
    public void removeBook(){
        if (list.isEmpty()) {
            System.out.println("Library is Empty");
        } else {
            System.out.println("Enter name of the book to remove");
            String newName = sc.nextLine();
            Entity yesFound=null;
            for (Entity i : list) {
                if (i.getBookName().equalsIgnoreCase(newName)) {
                    yesFound = i;
                    break;
                }
            }
            if (yesFound!=null) {
                list.remove(yesFound);
                System.out.println("Book removed successfully");
            } else {
                System.out.println("No Book matched with that name");
            }
        }
    }
    public void updateBook(){

    }
    public void searchBookByAuthor(){

    }
    public void searchBookByName(){

    }
    public void displayBooks(){

        if(list.isEmpty()) {
            System.out.println("No books to display at the moment");
            return;
        }
        for(Entity book : list) {
            System.out.println(book);
        }
    }
    public void exitLibrary(){

    }
}
