package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class TestLibrarySystem {
    public static void main(String[] args) throws ParseException {
        LibrarySystem librarySystem = new LibrarySystem();

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

        //System.out.println(book1.equals(book1,book2));

        ArrayList<String> tmp = new ArrayList<String>();

        User user1 = new User("firstName1", "lastName1", "1111111111");
        User user2 = new User("firstName2", "lastName2","1111111111");
        User user3 = new User("firstName3", "lastName3","3333333333");
        User user4 = new User("firstName4", "lastName4","4444444444");
        User user5 = new User("firstName5", "lastName5","5555555555");
        User user6 = new User("firstName6", "lastName6","6666666666");
        User user7 = new User("firstName7", "lastName7","7777777777");
        User user8 = new User("firstName8", "lastName8","8888888888");
        User user9 = new User("firstName9", "lastName9","9999999999");
        User user10 = new User("firstName10", "lastName10","0000000000");




        //System.out.println(user1.equals(user2));


        //user1.print();

        SimpleDateFormat ft = new SimpleDateFormat("y/M/d hh");
        Date dnow = ft.parse("2019/3/6 5");

        //Borrow borrow1 = new Borrow(user1,book1,ft.parse("2020/3/16 0"));
        //System.out.println(ft.format(borrow1.getIssuedDate()));

        //borrow1.print();
        Library library1 = new Library("Sabouri", "AUT");
        library1.addBook(book1);
        library1.addBook(book2);

        library1.addUser(user1);
        library1.addUser(user4);
        library1.addUser(user3);
        library1.addUser(user1);
        library1.addUser(user2);
        System.out.println(user1.equals(library1.getUsers()));

        Library library2 = new Library("NLAI", "Haghani");

        //System.out.println(library.getBooks().get(0).getTitle());

        //library1.borrowBook(book1,user2,ft.parse("2020/3/16 0"));
        //System.out.println(library1.getBorrows().get(0).getBorrower().getFirstName());
        //library1.printPassedDeadlineBorrows();



    }
}
