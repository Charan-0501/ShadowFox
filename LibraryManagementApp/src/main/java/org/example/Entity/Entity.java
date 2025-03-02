package org.example.Entity;

public class Entity {

        private int bookId;
        private String bookName;
        private String bookAuthor;
        private float bookPrice;
        private boolean bookAvailable;

        public Entity() {
            // Default constructor
        }

        // Constructor for adding a new book
        public Entity(String bookName, String bookAuthor, float bookPrice) {
            this.bookName = bookName;
            this.bookAuthor = bookAuthor;
            this.bookPrice = bookPrice;
            this.bookAvailable = true;  // New books are available by default
        }

        // Constructor for fetching from database
        public Entity(int bookId, String bookName, String bookAuthor, float bookPrice, boolean bookAvailable) {
            this.bookId = bookId;
            this.bookName = bookName;
            this.bookAuthor = bookAuthor;
            this.bookPrice = bookPrice;
            this.bookAvailable = bookAvailable;
        }

        // Getters and Setters
        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getBookAuthor() {
            return bookAuthor;
        }

        public void setBookAuthor(String bookAuthor) {
            this.bookAuthor = bookAuthor;
        }

        public float getBookPrice() {
            return bookPrice;
        }

        public void setBookPrice(float bookPrice) {
            this.bookPrice = bookPrice;
        }

        public boolean isBookAvailable() {
            return bookAvailable;
        }

        public void setBookAvailable(boolean bookAvailable) {
            this.bookAvailable = bookAvailable;
        }

        // Override toString() for better object representation
        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: " + bookName + ", Author: " + bookAuthor +
                    ", Price: $" + bookPrice + ", Available: " + bookAvailable;
        }

}


