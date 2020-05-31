package com.inn.bookmanagement.dao;

import com.inn.bookmanagement.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {

    Author findByGivenNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String givenName, String lastName);

}
