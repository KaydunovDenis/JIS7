Библиотека:
Необходимо разработать систему учета книг. 
Нужно создать два класса: 
    + книга Book 
    + библиотека Library.

#Book
Должен состоять из:
    + автора книги 
    + названия книги.
[+] Оба свойства должны быть проинициализированы в момент создания книги
[+] изменение состояния объекта после его создания запрещено.
[+]Необходимо переопределить методы equals() и hashcode(), а также toString().

#Library
Должен выполнять роль хранилища книг в виде списка и выполнять следующие действия:
[+]Добавить книгу в библиотеку
[+]Удалить книгу из библиотеки
[+]Найти одну книгу по названию
[+]Вернуть все книги по автору
[+]При создании объекта, список книг должен быть пустым, а не null.

[+]Продемонстрировать работу методов с учетом логических требований. 

Написать тестовые сценарии для класса
[+]Library в классе LibraryTest. Все тестовые сценарии должны отрабатывать без ошибок.

Book bookOne = new Book("War and Peace", "Leo Tolstoy");
Book bookTwo = new Book("Anna Karenina", "Leo Tolstoy");
Library library = new Library();
library.addBook(bookOne);
library.addBook(bookTwo);
library.findByName("War and Peace"); //Should return bookOne
library.findByAuthor("Leo Tolstoy"); //Should return bookOne, bookTw
library.deleteBook(bookTwo);
