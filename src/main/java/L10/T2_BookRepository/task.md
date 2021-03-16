#BookRepository

Функциональные требования:
Разработайте универсальный _*интерфейс Repository<T>*_, который будет представлять следующий набор методов:

- List<T> findAll();
- T findById(String id) throws ItemNotFoundException;
- save(T item);
- delete(String id) throws ItemNotFoundException;


Разработайте класс Book, который будет содержать в себе следующие поля:

    String id
    String name
    String author
    int pagesCount
Обязательные методы для переопределения: equals(), hashCode() и toString().

Getter методы для всех полей обязательны.

Инициализация полей через конструктор или setter методы на выбор.

Разработайте класс BookRepository, который реализует интерфейс Repository для типа Book на основе коллекции Map<String, T>, где T - класс Book.

В случае, если книга с переданным идентификатором не найдена, методы findById() и delete() должны выбросить исключение ItemNotFoundException с идентификатором объекта.

Нефункциональные требования:
Продемонстрировать работу методов с учетом логических требований.