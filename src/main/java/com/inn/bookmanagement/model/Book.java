package com.inn.bookmanagement.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "summary")
    private String summary;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    public Book() {
    }

    public Book(String title, String genre, Integer publicationYear) {
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(publicationYear, book.publicationYear) &&
                Objects.equals(summary, book.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, publicationYear, summary);
    }

    @Override
    public String toString() {
        return "book title '" + title + '\'' +
                ", book author " + author + '\'' +
                ", book genre '" + genre + '\'' +
                ", book publication Year " + publicationYear +
                ", summary '" + summary +
                '}';
    }
}
