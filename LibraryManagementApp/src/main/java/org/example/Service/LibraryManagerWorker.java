package org.example.Service;
import org.example.Main;
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
        if (list.isEmpty()) {
            System.out.println("There are no Books in Library ");
            return;
        }
        else {
            System.out.println("Enter the Book name you like to update");
            String update1 = sc.nextLine();
            for (Entity i : list) {
                if (i.getBookName().equalsIgnoreCase(update1)) {
                    System.out.println("You can only update book availability");
                    System.out.println("\n Is book available ? true or false");
                    i.setBookAvailable(sc.nextBoolean());
                    System.out.println("Book availability updated Successfully");
                    return;
                }
            }
        }
        System.out.println("No book found with that name");

    }
    public void searchBookByAuthor(){

        if (list.isEmpty()) {
            System.out.println("There are no Books in Library");
        } else {
            System.out.println("Enter Author name ");
            String s = sc.nextLine();
            for (Entity i : list) {
                if(i.getBookAuthor().equalsIgnoreCase(s)){
                    System.out.println(i);
                    return;
                }
            }
            System.out.println("There are no "+s+"'s books in library" );
        }

    }
    public void searchBookByName(){
        if (list.isEmpty()) {
            System.out.println("There are no Books in Library");
        } else {
            System.out.println("Enter book name");
            String s = sc.nextLine();
            for (Entity i : list) {
                if(i.getBookName().equalsIgnoreCase(s)){
                    System.out.println(i);
                    return;
                }
            }
            System.out.println("No Book Found with that name");
        }

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

}
