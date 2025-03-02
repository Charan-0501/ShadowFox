package org.example.Entity;

public class Entity {

    private int baseId=6689;
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private float bookPrice;
    private boolean isBookAvailable=false;

    public Entity(){
    }

    public Entity(String bookName,String bookAuthor,float bookPrice) {

        this.bookName=bookName;
        this.bookAuthor=bookAuthor;
        this.bookPrice=bookPrice;
        this.bookId = getBookId();
        this.isBookAvailable= true;
    }

    private int getBookId(){
        return ++baseId;
    }
    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    @Override
    public String toString() {
        return "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice ;
    }
}


