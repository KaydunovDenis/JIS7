package com.github.kaydunovDenis.library.model;

import lombok.Data;

@Data
public class Book {
    String name;
    String author;

    private Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private void setName(String name) {
        this.name = name;
    }
}
