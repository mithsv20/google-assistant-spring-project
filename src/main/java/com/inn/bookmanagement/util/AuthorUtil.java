package com.inn.bookmanagement.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AuthorUtil {

    public static final String NOT_FOUND_MESSAGE = "Did'nt found response for specified entry. Please try again..!";

    // list of messages for incoming request (list_author intent)
    public static final List<String> listOfAuthorMessages = new ArrayList<>();

    //list of messages sent as response
    public static final List<String> listOfAuthorSelectionMessages = new ArrayList<>();

    static{
        listOfAuthorMessages.add("Here is the list of authors: ");
        listOfAuthorMessages.add("Sure, here is the list: ");
        listOfAuthorMessages.add("I found the following authors: ");

        listOfAuthorSelectionMessages.add("Which one would you like to select?");
        listOfAuthorSelectionMessages.add("Please choose one of them to continue.");
        listOfAuthorSelectionMessages.add("I can provide list of books if you choose an author.");
    }

    // create methods for extracting a random messange used by Google Assistant.
    public static String getRendomListOfAuthorMessage(){

        Integer listOfAuthorValues = new Random().nextInt(listOfAuthorMessages.size());

        return listOfAuthorMessages.get(listOfAuthorValues);
    }

    public static String getRendomAuthorSelectionMessage(){

        Integer listOfAuthorsSelectionValue = new Random().nextInt(listOfAuthorSelectionMessages.size());

        return listOfAuthorSelectionMessages.get(listOfAuthorsSelectionValue);
    }
}
