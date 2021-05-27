# JIS7
Learning Java on JavaGuru


new tasks

как я понял это в будущем для CRUD

New fields and validation improvements
Branch: feature/1
1. Необходимо добавить в класс Product поля:
категория
скидка
описание
2. Необходимо дополнить проверку продукта:
цена продукта должна быть больше 0
скидка не может быть больше 100 процентов
название не может быть меньше 3 символов и больше 32


Single Responsibility Principle
Task 2 for ShoppingListApplication
1. Description
Необходимо сделать рефакторинг приложения на основе презентации Single Responsibility Principle.



Added new validation rules for product
Task 3 for ShoppingListApplication
1. Description
Необходимо проверять продукт согласно правилам:
 
1. Название продукта не может быть меньше 3 символов и больше 32.
2. Скидка не должна быть больше 100 %.
3. Скидка не может быть меньше 0.
*Примечание: скидка может быть дробным числом (10.5%).
4. Цена продукта должна быть больше 0.
6. Название продукта должно быть уникальным.
7. Если цена продукта меньше 20$, то скидку сделать нельзя.

Single Responsibility Principle
New domain - ShoppingCart
Task 4 for ShoppingListApplication
1. Description
Необходимо добавить новую сущность в проект - Shopping cart.
У "корзины" должно быть название и список продуктов.
 
Название - обязательное поле
 
Функциональные требования:
Сохранение/получение/удаление корзины
Добавление продукта в корзину
Получение списка продуктов (в корзине)
Получение общей стоимости продуктов в корзине



Исключения
Простая База Данных
1. Description
Описание:
Разработать программу, которая работает в соответствии с требованиями ниже.
Функциональные требования:
Разработайте универсальный интерфейс Repository<T>, который будет представлять следующий набор методов:
List<T> findAll();
T findById(String id) throws ItemNotFoundException;
save(T item);
delete(String id) throws ItemNotFoundException;
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
Результат:
Загрузить файлы Repository.java, BookRepository.java, Book.java и BookRepositoryDemo.java
