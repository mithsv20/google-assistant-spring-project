package com.inn.bookmanagement.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookUtil {

    // list of messages for incoming request (list_books_by_author intent)
    public static final List<String> listOfBooksMessages = new ArrayList<>();

    //list of messages sent as response for book list
    public static final List<String> listOfBooksSelectionMessages = new ArrayList<>();

    // list of messages for incoming book request (get_book_details intent)
    public static final List<String> listOfBookDetailsMessages = new ArrayList<>();

    static{
        listOfBooksMessages.add("Here is the list of books: ");
        listOfBooksMessages.add("Sure, I got the books for you: ");
        listOfBooksMessages.add("I found the following books: ");

        listOfBooksSelectionMessages.add("Which one would you like to select?");
        listOfBooksSelectionMessages.add("Please choose the book you want to know.");
        listOfBooksSelectionMessages.add("I can provide the book details if you choose an book.");

        listOfBookDetailsMessages.add("Here is the book details: ");
        listOfBookDetailsMessages.add("Sure, I got the book details for you: ");
        listOfBookDetailsMessages.add("I found the following details for your book title: ");

    }

    // create methods for extracting a random messange used by Google Assistant.
    public static String getRendomListOfBookMessage(){

        Integer listOfBookValues = new Random().nextInt(listOfBooksMessages.size());
        return listOfBooksMessages.get(listOfBookValues);
    }

    public static String getRendomBookSelectionMessage(){

        Integer listOfBookssSelectionValue = new Random().nextInt(listOfBooksSelectionMessages.size());
        return listOfBooksSelectionMessages.get(listOfBookssSelectionValue);
    }

    public static String getRendomListOfBookDetailsMessage(){

        Integer listOfBookDetailsValues = new Random().nextInt(listOfBookDetailsMessages.size());
        return listOfBookDetailsMessages.get(listOfBookDetailsValues);
    }

}
