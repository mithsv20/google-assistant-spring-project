package com.inn.bookmanagement.dao;

import com.inn.bookmanagement.model.Author;
import com.inn.bookmanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

    List<Book> findAllByAuthor(Author author);

    Book findByTitleContainingIgnoreCase(String title);

    List<Book> findByGenreContainingIgnoreCase(String genre);
}
