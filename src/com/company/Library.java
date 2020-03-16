package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The Library class represents a library in a library system.
 * It holds books and users in the library and list of borrows.
 *
 * @author Fatemeh Valeh
 */
public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Borrow> borrows;
    private String address;
    private String name;
    SimpleDateFormat ft = new SimpleDateFormat("y/M/d hh");

    /**
     * information about library
     * @param name name of the library
     * @param address address of the library
     */
    public Library(String name, String address){
        books = new ArrayList<Book>();
        users = new ArrayList<User>();
        borrows = new ArrayList<Borrow>();
        this.name = name;
        this.address = address;
    }

    /**
     * @return books field
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * @return borrows field
     */
    public ArrayList<Borrow> getBorrows() {
        return borrows;
    }

    /**
     * @return users field
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * @return address of the library
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return name of the library
     */
    public String getName() {
        return name;
    }

    /**
     * a method to add a user
     * @param userToAdd user to be added
     */
    public void addUser(User userToAdd){
        //check if we have same user id in library or not
        int flag = 0;
        for (User tmp : users){
            if (tmp.getIdNum() == userToAdd.getIdNum()){
                flag = 1;
                break;
            }
        }
        if (flag == 1){
            if (users.contains(userToAdd))
                System.out.println("User: " + userToAdd.getFirstName() + " " + userToAdd.getLastName() + " " + userToAdd.getIdNum() + " is already added to the library" + "'" + name + "'");
            else
                System.out.println("Users with same ID numbers can't be added to one library");
        }
        else {
                users.add(userToAdd);
                System.out.println("User " + userToAdd.getFirstName() + " " + userToAdd.getLastName() + " " + userToAdd.getIdNum() + " " + "added to the library "  + "'" + name + "'");
            }

    }

    /**
     * a method to remove a user
     * @param userToRemove user to be removed
     */
    public void removeUser(User userToRemove){
        // check if the user have a book
        int flag = 0;
        for (Borrow tmp:borrows) {
            if (tmp.getBorrower().getIdNum()==userToRemove.getIdNum()){
                flag = 1;
                break;
            }
        }
        if (users.contains(userToRemove) && (flag != 1)) {
            users.remove(userToRemove);
            System.out.println("User: " + userToRemove.getFirstName() + " " + userToRemove.getLastName() + " " + userToRemove.getIdNum() + " " + "removed from the library "  + "'" + name + "'");
        }
        else if (flag == 1)
            System.out.println("User which has a book can't be removed");
        else
            System.out.println("User is invalid in the library "  + "'" + name + "'");
    }

    /**
     * a method to add a book
     * @param bookToAdd book to be added
     */
    public void addBook(Book bookToAdd){
        if (books.contains(bookToAdd) || borrows.contains(bookToAdd))
            System.out.println( "The book: " + bookToAdd.getTitle() + " is already in the library " + "'" + name + "'");
        else {
            books.add(bookToAdd);
            System.out.println("The book: " + bookToAdd.getTitle() + " added to the library " + "'" + name + "'");
        }
    }

    /**
     * a method to remove a book from the library
     * @param bookToRemove book to be removed
     */
    public void removeBook(Book bookToRemove){
        // check if the book isn't borrowed
        int flag = 0; // book isn't in borrows list
        for (Borrow tmp: borrows){
            if (tmp.getBook().equals(bookToRemove)){
                flag = 1; // books is available in borrows list
                break;
            }
        }
        if (books.contains(bookToRemove) && (flag !=1) ) {
            books.remove(bookToRemove);
            System.out.println("Book: " + bookToRemove.getTitle() + " " + bookToRemove.getAuthor() + " removed from the library " + "'" + name + "'");
        }
        else if (flag ==1)
            System.out.println("A borrowed book can't be removed from the library.");
        else
            System.out.println("Can't remove " + bookToRemove.getTitle() + " " + bookToRemove.getAuthor() + " book be cause it doesn't belong to the library " + "'" + name + "'");
    }

    /**
     * a method that borrow a book to a user
     * @param bookToBorrow book to be borrowed
     * @param borrower user who borrow a book
     * @param deadline deadline of the borrow
     */
    public void borrowBook(Book bookToBorrow, User borrower, Date deadline){
        if (books.contains(bookToBorrow) && users.contains(borrower) && new Date().before(deadline)){
            Borrow borrow = new Borrow(borrower, bookToBorrow, deadline);
            borrows.add(borrow);
            books.remove(bookToBorrow);
            bookToBorrow.print();
            System.out.print(" is lent to ");
            borrower.print();
            System.out.println(" up to " + ft.format(deadline) + " from the library '" + name + "'");
        }
        else if ( !books.contains(bookToBorrow) )
            System.out.println("Book is not available");
        else if ( !users.contains(borrower) )
            System.out.println("User is invalid in this library");
        else if ( !new Date().before(deadline) )
            System.out.println("Deadline is invalid");
    }

    /**
     * give balk a borrow
     * @param borrow a borrow to give back
     */
    public void giveBackBook(Borrow borrow){
        // check if borrow is about a book from this library
        int flag = 0;
        for (Book tmp : books){
            if (tmp.equals(borrow.getBook())){
                flag = 1;
                break;
            }
        }
        if (borrows.contains(borrow)){
            borrows.remove(borrow);
            books.add(borrow.getBook());
            System.out.println("The book " + borrow.getBook().getTitle() +" "+borrow.getBook().getAuthor() + " is been given back");
        }
        else if (!borrows.contains(borrow) && flag == 1)
            System.out.println("Book " + borrow.getBook().getTitle() +" "+borrow.getBook().getAuthor() + " is not borrowed from the library");
        else if (flag != 1)
            System.out.println("Book " + borrow.getBook().getTitle() +" "+borrow.getBook().getAuthor() + " doesn't belong to this library");
    }

    /**
     * a method to print all borrows that their deadlines passed
     */
    public void printPassedDeadlineBorrows(){
        for (Borrow tmp : borrows){
            if (tmp.getIssuedDate().compareTo(tmp.getDeadlineDate()) > 0){
                tmp.print();
            }
        }
    }

}
