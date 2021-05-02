package com.github.kaydunovDenis.library.repository;

import com.github.kaydunovDenis.library.model.Book;
import com.github.kaydunovDenis.library.service.LibraryService;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Library implements LibraryService {
    private final HashSet<Book> libraryBook = new HashSet<>();
    private final Logger log = Logger.getLogger(Library.class.getName());

    public Library() {
       // log.setLevel(Level.FINE);
    }

    @Override
    public void addBook(Book book) {
        libraryBook.add(book);
    }

    @Override
    public void deleteBook(Book book) {
        if (libraryBook.remove(book)) {
            log.fine("DeleteBook: " + book.getName() + " remove successful.");
        } else {
            log.log(Level.FINE,"Book " + book.getName() + " not found.");
        }
    }

    @Override
    public Book findByName(String bookName) {
        for (Book book : libraryBook) {
            if (book.getName().equals(bookName)) {
                log.log(Level.FINE, "FindByName: " + bookName + " found: " + book.toString());
                return book;
            }
        }
        log.log(Level.FINE, "Book " + bookName + " not found.");
        return null;
    }

    @Override
    public HashSet<Book> findByAuthor(String author) {
        HashSet<Book> tempSet = new HashSet<>();
        for (Book book : libraryBook) {
            if (book.getAuthor().equals(author)) {
                tempSet.add(book);
            }
        }
        log.log(Level.FINE, "FindByAuthor: ");
        if (tempSet.size() > 0) {
            tempSet.forEach(x -> log.log(Level.FINE, x.toString()));
            return tempSet;
        } else {
            log.log(Level.FINE, "Book of " + author + " not found.");
            return null;
        }
    }
}
