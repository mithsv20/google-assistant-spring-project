package com.inn.bookmanagement.service;

import com.inn.bookmanagement.dao.AuthorDao;
import com.inn.bookmanagement.model.Author;
import com.inn.bookmanagement.util.AuthorUtil;
import com.inn.bookmanagement.util.IntentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private Logger logger = LoggerFactory.getLogger(AuthorService.class);

    @Autowired
    private AuthorDao authorDao;

    public String listAuthors() {

        logger.info("Executing intent {}", IntentUtil.LIST_AUTHORS);

        //find list of authors fron DB
        List<Author> authorList = authorDao.findAll();

        //start creating the response
        StringBuilder response = new StringBuilder(AuthorUtil.getRendomListOfAuthorMessage());
        response.append(System.getProperty(IntentUtil.LINE_SAPERATOR));

        String result = authorList.stream().map(author -> author.toString()).collect(Collectors.joining(", "));

        response.append(result);
        response.append(".");
        response.append(System.getProperty(IntentUtil.LINE_SAPERATOR));

        //add random message that will ask the user which author to select
        response.append(AuthorUtil.getRendomAuthorSelectionMessage());

        return response.toString();
    }

}
