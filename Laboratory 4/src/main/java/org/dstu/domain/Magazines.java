package org.dstu.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Magazines {
    private int id;
    private String name;
    private int pages;
    private String publisher;
    private String language;
    private String country;
    private String type;
    private String editor;
    private int first_issue;
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
    @Column(name = "pages")
    public int getPages() {
        return pages;
    }

    public void setPages() {
        this.pages = pages;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {this.type = type;}

    @Basic
    @Column(name = "editor")
    public String getEditor() {
        return country;
    }

    public void setEditor(String editor) {this.editor = editor;}

    @Basic
    @Column(name = "first_issue")
    public int getFirst_issue() {
        return first_issue;
    }

    public void setFirst_issue(int first_issue) {this.first_issue = first_issue;}

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
        Magazines magazines = (Magazines) o;
        return id == magazines.id && pages == magazines.pages && Objects.equals(name, magazines.name) && Objects.equals(publisher, magazines.publisher) && Objects.equals(language, magazines.language) && Objects.equals(country, magazines.country) && Objects.equals(type, magazines.type) && Objects.equals(editor, magazines.editor) && Objects.equals(first_issue, magazines.first_issue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pages, publisher, language, country, type, editor, first_issue);
    }
}
