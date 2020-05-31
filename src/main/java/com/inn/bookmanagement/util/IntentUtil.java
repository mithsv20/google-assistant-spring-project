package com.inn.bookmanagement.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class IntentUtil {

    public static final String LIST_AUTHORS = "list_authors";
    public static final String LINE_SAPERATOR = "line.separator";
    public static final String LIST_BOOKS_BY_AUTHOR = "list_books_by_author";
    public static final String GET_BOOK_DETAILS = "get_book_details_by_title";
    public static final String LIST_BOOKS_BY_GENRE = "list_books_by_genre";
    public static final String GET_BOOK_DETAILS_BY_GENRE = "get_book_details_by_genre";
    public static final String LIST_ACTIONS = "list_actions";


    public static String getIntentName(String body){

        //convert body to json object
        JsonObject bodyJsonObject = new Gson().fromJson(body, JsonObject.class);

        //get queryResult
        JsonObject queryResult = bodyJsonObject.getAsJsonObject("queryResult");

        //get Intent object
        JsonObject intentObject = queryResult.getAsJsonObject("intent");

        // return display name
        return intentObject.get("displayName").getAsString();

    }

}
