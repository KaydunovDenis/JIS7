package com.github.kaydunovDenis.library.service;

import com.github.kaydunovDenis.library.model.Book;

import java.util.Set;

/**
 * [-]Добавить книгу в библиотеку
 * [-]Удалить книгу из библиотеки
 * [-]Найти одну книгу по названию
 * [-]Вернуть все книги по автору
 */
public interface LibraryService {
    void addBook(Book book);

    void deleteBook (Book book);

    Book findByName(String bookName);

    Set<Book> findByAuthor(String author);
}
