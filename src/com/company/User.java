package com.company;

import java.util.Arrays;

/**
 * The User class represents a user in a library system.
 * It holds first name, last name and id number of a user.
 *
 * @author Fatemeh Valeh
 */

public class User {
    private String firstName;
    private String lastName;
    private String idNum;

    /**
     * information about a user
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param idNum id number of the user
     */
    public User(String firstName,String lastName,String idNum) {
        this.firstName = firstName;
        this.lastName = lastName;

        {
            if (idNum.length() == 10) {
                this.idNum = idNum;
            } else {
                System.out.println("Invalid idNum. Default 0000000000 idNum will be replaced");
                this.idNum = "0000000000";
            }
        }
    }

    /**
     * @return firsName of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * set firstName of the user
     * @param firstName set firstName field
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return last name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set lastname of the user
     * @param lastName set lastName field
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return idNum of a user
     */
    public String getIdNum(){
        return idNum;
    }

    /**
     * set idNumber of the user
     * @param idNum set idNum field
     */
    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    /**
     * a method to check if two users are same or not comparing their idNum
     * @param user first user to be checked
     * @return true if two users are the same, false if not
     */
    public boolean equals(User user){
        if (user.getIdNum()==idNum)
            return true;
        else
            return false;
    }


    /**
     * a method to print information of a user
     */
    public void print(){
        System.out.print("Full Name: " + firstName + " " + lastName + " | ID: " + idNum);
        //Arrays.stream(idNum).forEach(System.out::print);
    }
}
