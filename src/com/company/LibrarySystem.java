package com.company;

import java.util.ArrayList;

public class LibrarySystem {

    private ArrayList<Library> libraries;

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

    public void print(){
        for (Library tmp : libraries){
            System.out.println(tmp.getName() + " | " + tmp.getAddress());
        }
    }



}
