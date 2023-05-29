package org.dstu.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Books {
    private int id;
    private String name;
    private int pages;
    private String publisher;
    private String language;
    private String country;
    private String author;
    private String genre;
    private int published;
    private Shelf shelf;


    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Basic
    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "genre")
    public String getGenre() {
        return author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "published")
    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    @Basic
    @Column(name = "pages")
    public int getPages() {
        return pages;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelf_id")
    public Shelf getChair() {
        return shelf;
    }

    public void setChair(Shelf chair) {
        this.shelf = shelf;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return id == books.id && pages == books.pages && Objects.equals(name, books.name) && Objects.equals(publisher, books.publisher) && Objects.equals(language, books.language) && Objects.equals(country, books.country) && Objects.equals(author, books.author) && Objects.equals(genre, books.genre) && Objects.equals(published, books.published);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pages, publisher, language, country, author, genre, published);
    }
}
