package com.company;

import java.util.ArrayList;

/**
 * Library System class represents a class to manage a library.
 *
 * @author Fatemeh Valeh
 */

public class LibrarySystem {

    private ArrayList<Library> libraries;

    /**
     * creating an array of Library
     */
    public LibrarySystem(){
        libraries = new ArrayList<Library>();
    }

    /**
     * a method to add a library to libraries
     * @param libraryToAdd library to be added
     */
    public void addLibrary(Library libraryToAdd){
        libraries.add(libraryToAdd);
    }

    /**
     * a method to remove a library
     * @param libraryToRemove library to be removed
     */
    public void  removeLibrary(Library libraryToRemove){
        libraries.remove(libraryToRemove);
    }

    /**
     * a method to print information about library system
     */
    public void print(){
        for (Library tmp : libraries){
            System.out.println(tmp.getName() + " | " + tmp.getAddress());
        }
    }



}
