package com.inn.bookmanagement.service;

import com.inn.bookmanagement.dao.AuthorDao;
import com.inn.bookmanagement.dao.BookDao;
import com.inn.bookmanagement.model.Author;
import com.inn.bookmanagement.model.Book;
import com.inn.bookmanagement.util.AuthorUtil;
import com.inn.bookmanagement.util.BookUtil;
import com.inn.bookmanagement.util.IntentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private BookDao bookDao;

    public String findAllByAuthor(String givenName, String lastName) {
        logger.info("Executing intent {}", IntentUtil.LIST_BOOKS_BY_AUTHOR);

        //find list of authors fron DB
        Author author = authorDao.findByGivenNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(givenName, lastName);

        //start creating the response
        StringBuilder response = new StringBuilder();

        if(author != null) {
            response.append(BookUtil.getRendomListOfBookMessage());
            response.append(System.getProperty(IntentUtil.LINE_SAPERATOR));

            List<Book> bookList = bookDao.findAllByAuthor(author);
            String result = bookList.stream().map(book -> book.getTitle()).collect(Collectors.joining(", "));

            response.append(result);
            response.append(".");
            response.append(System.getProperty(IntentUtil.LINE_SAPERATOR));

            //add random message that will ask the user which author to select
            response.append(BookUtil.getRendomBookSelectionMessage());
        } else {
            response.append(AuthorUtil.NOT_FOUND_MESSAGE);
        }

        return response.toString();
    }


    public String getBookDetails(String bookTitle) {
        logger.info("Executing intent {}", IntentUtil.GET_BOOK_DETAILS);

        StringBuilder response = new StringBuilder();

        //find book from DB
        Book book = bookDao.findByTitleContainingIgnoreCase(bookTitle);

        if(book != null) {
            response.append(BookUtil.getRendomListOfBookDetailsMessage());
            response.append(System.getProperty(IntentUtil.LINE_SAPERATOR));

            response.append(book.toString());
        } else {
            response.append(AuthorUtil.NOT_FOUND_MESSAGE);
        }

        return response.toString();
    }


    public String listBooksByGenre(String genre) {
        logger.info("Executing intent {}", IntentUtil.LIST_BOOKS_BY_GENRE);

        StringBuilder response = new StringBuilder();

        //fetch book list from DB
        List<Book> bookList = bookDao.findByGenreContainingIgnoreCase(genre);

        if(!CollectionUtils.isEmpty(bookList)) {
            String result = bookList.stream().map(book -> book.getTitle()).collect(Collectors.joining(", "));

            response.append(result);
            response.append(".");
            response.append(System.getProperty(IntentUtil.LINE_SAPERATOR));

            //add random message that will ask the user which author to select
            response.append(BookUtil.getRendomBookSelectionMessage());

        } else {
            response.append(AuthorUtil.NOT_FOUND_MESSAGE);
        }

        return response.toString();
    }

    public String getBookDetailsByGenre(String bookTitle) {
        logger.info("Executing intent {}", IntentUtil.GET_BOOK_DETAILS_BY_GENRE);

        StringBuilder response = new StringBuilder();

        // fetch book from DB
        Book book = bookDao.findByTitleContainingIgnoreCase(bookTitle);

        if(book != null) {
            response.append(BookUtil.getRendomListOfBookDetailsMessage());
            response.append(System.getProperty(IntentUtil.LINE_SAPERATOR));

            response.append(book.toString());
        } else {
            response.append(AuthorUtil.NOT_FOUND_MESSAGE);
        }

        return response.toString();
    }


}
