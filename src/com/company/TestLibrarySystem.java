package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * TestLibrarySystem is a class that test all methods of the system.
 *
 * @author Fatemeh Valeh
 */
public class TestLibrarySystem {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat ft = new SimpleDateFormat("y/M/d hh");
        LibrarySystem librarySystem = new LibrarySystem();

        Library library1 = new Library("Sabouri", "AUT");
        Library library2 = new Library("NLAI", "Haghani");

        librarySystem.addLibrary(library1);
        librarySystem.addLibrary(library2);
        librarySystem.print();

        Book book0 = new Book("title0", "author0");
        Book book1 = new Book("title1", "author1");
        Book book2 = new Book("title2", "author2");
        Book book3 = new Book("title3", "author3");
        Book book4 = new Book("title4", "author4");
        Book book5 = new Book("title5", "author5");
        Book book6 = new Book("title6", "author6");
        Book book7 = new Book("title7", "author7");
        Book book8 = new Book("title8", "author8");
        Book book9 = new Book("title9", "author9");
        Book book10 = new Book("title10", "author10");

        User user1 = new User("firstName1", "lastName1", "1111111111");
        User user2 = new User("firstName2", "lastName2","2222222222");
        User user3 = new User("firstName3", "lastName3","3333333333");
        User user4 = new User("firstName4", "lastName4","4444444444");
        User user5 = new User("firstName5", "lastName5","5555555555");
        User user6 = new User("firstName6", "lastName6","6666666666");
        User user7 = new User("firstName7", "lastName7","7777777777");
        User user8 = new User("firstName8", "lastName8","8888888888");
        User user9 = new User("firstName9", "lastName9","9999999999");
        User user10 = new User("firstName10", "lastName10","0000000000");


        library1.addBook(book1);
        library1.addBook(book2);
        library1.addBook(book3);
        library1.addBook(book4);
        library1.addBook(book5);

        library1.addUser(user1);
        library1.addUser(user2);
        library1.addUser(user3);
        library1.addUser(user4);
        library1.addUser(user5);

        library2.addBook(book6);
        library2.addBook(book7);
        library2.addBook(book8);
        library2.addBook(book9);
        library2.addBook(book10);

        library2.addUser(user6);
        library2.addUser(user7);
        library2.addUser(user8);
        library2.addUser(user9);
        library2.addUser(user10);

        library1.borrowBook(book1,user1,ft.parse("2020/3/16 0")); // passed date can't be as a deadline date so it send's an error
        library1.borrowBook(book1,user1,ft.parse("2020/4/16 0"));
        library1.borrowBook(book2,user2,ft.parse("2020/4/16 5"));
        library1.borrowBook(book1,user1,ft.parse("2020/4/16 0")); // a borrowed book isn't available for borrowing

        library2.borrowBook(book6, user2,ft.parse("2020/6/20 0")); // a book can't be lent to a user doesn't belong to the library
        library2.borrowBook(book6, user6, ft.parse("2020/6/20 0"));
        library2.borrowBook(book3,user7,ft.parse("2020/6/20 0")); // an invalid book in a library can't be borrowed
        library2.borrowBook(book8,user8,ft.parse("2020/6/20 0"));
        library2.borrowBook(book9,user9,ft.parse("2020/6/20 0"));
        library2.borrowBook(book10,user10,ft.parse("2020/9/20 0"));

        library1.giveBackBook(library1.getBorrows().get(0));
        library2.giveBackBook(library1.getBorrows().get(0)); // can't give back a book to another library
        library1.giveBackBook(library1.getBorrows().get(0));
        System.out.println("***");
        library2.giveBackBook(library2.getBorrows().get(0));
        library2.giveBackBook(library2.getBorrows().get(0));

        library1.removeBook(book4);
        library2.removeBook(book8); // a borrowed book can't be removed
        library1.removeBook(book10); // can't remove a book that doesn't belong to library
        library1.removeBook(book0); // can't remove a book that doesn't belong to system be cause it doesn't belong to any library

        library1.removeUser(user1);
        library2.removeUser(user9);
        library1.removeUser(user10);
        System.out.println("////");
        Borrow borrow1 = new Borrow(user3,book3,ft.parse("2020/9/20 0"));
        library1.giveBackBook(borrow1); //can't give back a book that is not borrowed





    }
}
