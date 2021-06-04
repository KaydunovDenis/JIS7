package com.github.kaydunovDenis.library.repository;

import com.github.kaydunovDenis.library.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryTest {
    Library library;
    Book book1 = new Book( "Евгений Онегин", "Пушкин");
    Book book2 = new Book( "Властелин колец", "Толкиен");
    Book book3 = new Book( "Дубровский", "Пушкин");

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void add() {
        int expect = 0;
        int result = library.getLibraryBook().size();
        Assertions.assertEquals(expect, result);

        library.addBook(book1);
        library.addBook(book2);
        expect = 2;
        result = library.getLibraryBook().size();
        Assertions.assertEquals(expect, result);
    }

    @Test
    void delete() {
        library.addBook(book1);
        library.addBook(book2);
        int expect = 2;
        int result = library.getLibraryBook().size();
        Assertions.assertEquals(expect, result);

        library.deleteBook(book1);
        expect = 1;
        result = library.getLibraryBook().size();
        Assertions.assertEquals(expect, result);
    }

    @Test
    void findByName() {
        library.addBook(book1);
        Book bookResult = library.findByName(book1.getName());
        Assertions.assertEquals(book1, bookResult);

        bookResult = library.findByName("Some name");
        Assertions.assertNull(bookResult);
    }

    @Test
    void findByAuthor() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        int expect = 1;
        int result = library.findByAuthor(book2.getAuthor()).size();
        Assertions.assertEquals(expect, result);

        expect = 2;
        result = library.findByAuthor(book1.getAuthor()).size();
        Assertions.assertEquals(expect, result);
    }
}