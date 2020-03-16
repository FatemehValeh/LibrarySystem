package com.company;

public class Book {
    private String title;
    private String author;

    /**
     * information about a book
     * @param title title of the book
     * @param author author of the book
     */
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    /**
     * @return title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return return author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * check if two books are the same
     * @param book1 first book to be checked
     * @param book2 second book to be checked
     * @return true if two books are the same comparing their titles and authors, false if not
     */
    public boolean equals(Book book1, Book book2){
        if ( ( book1.getAuthor() == book2.getAuthor() ) && ( book1.getTitle() == book2.getTitle() ) ){
            return true;
        }
        else
            return false;
    }

    /**
     * a method to print information about a book
     */
    public void print(){
        System.out.println("Title: " + title + " | Author: " + author);
    }

}
