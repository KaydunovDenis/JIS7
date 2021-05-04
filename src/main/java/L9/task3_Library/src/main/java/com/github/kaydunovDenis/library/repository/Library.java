package com.github.kaydunovDenis.library.repository;

import com.github.kaydunovDenis.library.model.Book;
import com.github.kaydunovDenis.library.service.LibraryService;
import org.apache.log4j.Logger;

import java.util.HashSet;

public class Library implements LibraryService {
    private final HashSet<Book> libraryBook = new HashSet<>();
    final static Logger LOGGER = Logger.getLogger(Library.class);

    @Override
    public void addBook(Book book) {
        libraryBook.add(book);
        LOGGER.info("AddBook: " + book.getName() + " add successful.");
    }

    @Override
    public void deleteBook(Book book) {
        if (libraryBook.remove(book)) {
            LOGGER.info("DeleteBook: " + book.getName() + " remove successful.");
        } else {
            LOGGER.info("Book " + book.getName() + " not found.");
        }
    }

    @Override
    public Book findByName(String bookName) {
        for (Book book : libraryBook) {
            if (book.getName().equals(bookName)) {
                LOGGER.info( "FindByName: " + bookName + " found: " + book.toString());
                return book;
            }
        }
        LOGGER.info("Book " + bookName + " not found.");
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
        LOGGER.info("FindByAuthor: " + author);
        if (tempSet.size() > 0) {
            tempSet.forEach(x -> LOGGER.info("--" + x.toString()));
            return tempSet;
        } else {
            LOGGER.info("Book of " + author + " not found.");
            return null;
        }
    }

    public HashSet<Book> getLibraryBook() {
        return libraryBook;
    }
}
