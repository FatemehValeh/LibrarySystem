package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Borrow class represents a borrow in a library system
 * It holds a user, a book, a dead line date and current date as issued date
 *
 * @author Fatemeh Valeh
 */

public class Borrow {
    private User borrower;
    private Book book;
    private Date issuedDate;
    private Date deadlineDate;

    SimpleDateFormat ft = new SimpleDateFormat("y/M/d hh");

    /**
     * information about a borrow
     * @param borrower name of how borrowed a book
     * @param book name of the book have been borrowed
     * @param deadlineDate date that borrow time finishes
     */
    public Borrow(User borrower,Book book,Date deadlineDate){
        this.borrower = borrower;
        this.book = book;
        issuedDate = new Date();
         {
            if (issuedDate.before(deadlineDate)) {
                this.deadlineDate = deadlineDate;
            } else
                System.out.println("Invalid deadlineDate. Default 2020/12/31  0 deadlineDate will be determined");
        }
    }

    /**
     * set a borrower
     * @param borrower set borrower field
     */
    public void setBorrower(User borrower){
        this.borrower = borrower;
    }

    /**
     * @return borrower
     */
    public User getBorrower(){
        return borrower;
    }

    /**
     * set a book
     * @param book set book field
     */
    public void setBook(Book book){
        this.book = book;
    }

    /**
     * @return book
     */
    public Book getBook(){
        return book;
    }

    /**
     * set an issued date
     * @param issuedDate set issuedDate field
     */
    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    /**
     * @return issuedDate
     */
    public Date getIssuedDate() {
        return issuedDate;
    }

    /**
     * set a deadline date
     * @param deadlineDate set deadlineDate field
     */
    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    /**
     * @return deadlineDate
     */
    public Date getDeadlineDate() {
        return deadlineDate;
    }

    /**
     * a method that prints a borrow information
     */
    public void print(){
        System.out.print("Borrower => ");
        borrower.print();
        System.out.println();
        System.out.print("Book => " );
        book.print();
        System.out.println("IssuedDate => " + ft.format(issuedDate));
        System.out.println("Deadline => " + ft.format(deadlineDate));
        System.out.print("Remaining => "  );
        long diff = deadlineDate.getTime() - issuedDate.getTime();
        int diffDays = (int) (diff / (24*60*60*1000));
        System.out.println(diffDays);
    }



}
