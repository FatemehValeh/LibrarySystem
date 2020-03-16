package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Borrow> borrows;
    private String address;
    private String name;

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

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Borrow> getBorrows() {
        return borrows;
    }

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
                System.out.println("User " + userToAdd.getFirstName() + " " + userToAdd.getLastName() + " " + userToAdd.getIdNum() + " is already added to the library");
            else
                System.out.println("Users with same ID numbers can't be added to one library");
        }
        else {
                users.add(userToAdd);
                System.out.println("User " + userToAdd.getFirstName() + " " + userToAdd.getLastName() + " " + userToAdd.getIdNum() + " " + "added to the library");
            }

    }

    /**
     * a method to remove a user
     * @param userToRemove user to be removed
     */
    public void removeUser(User userToRemove){
        if (users.contains(userToRemove))
        users.remove(userToRemove);
        else
            System.out.println("User in invalid to be removed");
    }

    /**
     * a method to add a book
     * @param bookToAdd book to be added
     */
    public void addBook(Book bookToAdd){
        if (books.contains(bookToAdd) || borrows.contains(bookToAdd))
            System.out.println("Book is already added to the library");
        else
            books.add(bookToAdd);
    }

    /**
     * a method to remove a book from the library
     * @param bookToRemove book to be removed
     */
    public void removeBook(Book bookToRemove){
        if (books.contains(bookToRemove) && !borrows.contains(bookToRemove))
            books.remove(bookToRemove);
        else if (borrows.contains(bookToRemove))
            System.out.println("A borrowed book can't be removed from the library.");
        else
            System.out.println("Can't remove this book be cause it doesn't belong to this library");
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
        if (borrows.contains(borrow)){
            borrows.remove(borrow);
            books.add(borrow.getBook());
        }
        else if (books.contains(borrow))
            System.out.println("Book is not borrowed from the library");
        else
            System.out.println("This book doesn't belong to this library");
    }

    public void printPassedDeadlineBorrows(){
        for (Borrow tmp : borrows){
            if (tmp.getIssuedDate().compareTo(tmp.getDeadlineDate()) > 0){
                tmp.print();
            }
        }
    }

}
