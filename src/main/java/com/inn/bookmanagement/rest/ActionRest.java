package com.inn.bookmanagement.rest;

import com.google.gson.Gson;
import com.inn.bookmanagement.service.ActionService;
import com.inn.bookmanagement.service.AuthorService;
import com.inn.bookmanagement.service.BookService;
import com.inn.bookmanagement.util.IntentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/api/actions")
public class ActionRest {

    private Logger logger = LoggerFactory.getLogger(ActionRest.class);

    @Autowired
    private ActionService actionService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<?> executePostAction(@RequestParam("given-name") String givenName,
                                               @RequestParam("last-name") String lastName,
                                               @RequestParam("book-title") String bookTitle,
                                               @RequestParam("genre") String genre,
                                               @RequestBody String body){

        logger.info("==== executePostAction =======");
        String response = null;
        logger.info(new Gson().toJson(body));
        try {
            String intentName = IntentUtil.getIntentName(body);

            switch (intentName) {
                case IntentUtil.LIST_ACTIONS:
                    //invoke actionService->list_actions intent(Business Logic)
                    response = actionService.listActions();
                    return new ResponseEntity<String>(response, HttpStatus.OK);

                case IntentUtil.LIST_AUTHORS:
                    //invoke authorService->list_authors intent(Business Logic)
                    response = authorService.listAuthors();
                    return new ResponseEntity<String>(response, HttpStatus.OK);

                case IntentUtil.LIST_BOOKS_BY_AUTHOR:
                    //invoke authorService->list_books_by_author intent(Business Logic)
                    response = bookService.findAllByAuthor(givenName, lastName);
                    return new ResponseEntity<String>(response, HttpStatus.OK);

                case IntentUtil.GET_BOOK_DETAILS:
                    //invoke authorService->get_book_details intent(Business Logic)
                    response = bookService.getBookDetails(bookTitle);
                    return new ResponseEntity<String>(response, HttpStatus.OK);

                case IntentUtil.LIST_BOOKS_BY_GENRE:
                    //invoke authorService->list_books_by_genre intent(Business Logic)
                    response = bookService.listBooksByGenre(genre);
                    return new ResponseEntity<String>(response, HttpStatus.OK);

                case IntentUtil.GET_BOOK_DETAILS_BY_GENRE:
                    //invoke authorService->get_book_details_by_genre intent(Business Logic)
                    response = bookService.getBookDetailsByGenre(bookTitle);
                    return new ResponseEntity<String>(response, HttpStatus.OK);

                default:
                    return new ResponseEntity<String>("request could not be processed", HttpStatus.OK);
            }

        } catch (Exception e){
            logger.error("Error: {}", e.getStackTrace());
            return new ResponseEntity<String>("Could not extract intent name", HttpStatus.OK);
        }
    }


    @GetMapping
    public ResponseEntity<?> executeGetAction(){
        return new ResponseEntity<String>("Action Controller only accept POST requests from Google Assistant",
                HttpStatus.OK);
    }



}
