package com.github.kaydunovDenis.library;

import com.github.kaydunovDenis.library.model.Book;
import com.github.kaydunovDenis.library.repository.Library;

public class AppLibrary {
    public static void main(String[] args) {
        Library library = new Library();
        library.findByAuthor("Пушкин");

        Book book1 = new Book( "Евгений Онегин", "Пушкин");
        Book book2 = new Book( "Властелин колец", "Толкиен");
        Book book3 = new Book( "Дубровский", "Пушкин");
        Book book4 = new Book( "Война и мир", "Толстой");
        Book book5 = new Book("War and Peace", "Leo Tolstoy");
        Book book6 = new Book("Anna Karenina", "Leo Tolstoy");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);

        library.findByName("War and Peace"); //Should return bookOne
        library.findByAuthor("Leo Tolstoy"); //Should return bookOne, bookTwo
        library.deleteBook(book6);


    }
}
