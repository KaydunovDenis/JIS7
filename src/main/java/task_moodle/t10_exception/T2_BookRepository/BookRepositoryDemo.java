package task_moodle.t10_exception.T2_BookRepository;

public class BookRepositoryDemo {
    final private Book book1 = new Book(
            "1", "Монах который продал свой ферарри", "Робин Шарма", 157);
    final private Book book2 = new Book(
            "2", "Путь лидера", "Робин Шарма", 117);
    final private Book book3 = new Book(
            "3", "Успех", "Филипп Богачев", 157);
    static BookRepository books = new BookRepository();


    public static void main(String[] args) {
        System.out.println(books.getMap().toString());

        BookRepositoryDemo repositoryDemo = new BookRepositoryDemo();
        repositoryDemo.generateBooks();

        System.out.println(books.getMap().toString());

    }

    private void generateBooks() {
        books.save(book1);
        books.save(book2);
        books.save(book3);
    }
}
