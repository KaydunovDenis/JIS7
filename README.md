[![trophy](https://github-profile-trophy.vercel.app/KaydunovDenis=ryo-ma)](https://github.com/ryo-ma/github-profile-trophy)

[![Top Langs](https://github-readme-stats.vercel.app/api/top-langs/?username=KaydunovDenis&layout=compact)](https://github.com/KaydunovDenis/github-readme-stats) 


### Learning Java on JavaGuru

### New fields and validation improvements
Task 1 for ShoppingListApplication
Branch: feature/1
1. Необходимо добавить в класс Product поля:
категория
скидка
описание
2. Необходимо дополнить проверку продукта:

- [ ] цена продукта должна быть больше 0

- [ ] скидка не может быть больше 100 процентов

- [ ] название не может быть меньше 3 символов и больше 32


### Single Responsibility Principle
Task 2 for ShoppingListApplication
Необходимо сделать рефакторинг приложения на основе презентации Single Responsibility Principle.

### Added new validation rules for product
Task 3 for ShoppingListApplication
Необходимо проверять продукт согласно правилам:
1. Название продукта не может быть меньше 3 символов и больше 32.
2. Скидка не должна быть больше 100 %.
3. Скидка не может быть меньше 0.
*Примечание: скидка может быть дробным числом (10.5%).
4. Цена продукта должна быть больше 0.
6. Название продукта должно быть уникальным.
7. Если цена продукта меньше 20$, то скидку сделать нельзя.

### Single Responsibility Principle
New domain - ShoppingCart
Task 4 for ShoppingListApplication
Необходимо добавить новую сущность в проект - Shopping cart.
У "корзины" должно быть название и список продуктов.
Название - обязательное поле
Функциональные требования:
Сохранение/получение/удаление корзины
Добавление продукта в корзину
Получение списка продуктов (в корзине)
Получение общей стоимости продуктов в корзине

### Maven/Gradle, JUnit + Mockito
Migrate to Maven/Gradle, add tests
Task 5 for ShoppingListApplication
Добавить в проект build tool Maven/Gradle.
*Примечание: изменится структура проекта
Добавить библиотеки: JUnit 4.12 + Mockito 2.23.4
Покрыть тестами уровни service/validation

### Dependency Injection, JUnit + Mockito
Task 6 for ShoppingListApplication
Переписать приложение с использованием Dependency Injection.
Перенести настройку необходимых объектов в main метод.
Покрыть код тестами и достигнуть > 50% покрытия кода тестами

### Spring framework
Spring Basics
Task 7 for ShoppingListApplication
Добавить в проект Spring Framework 4.3.22.RELEASE
Внедрить использование Spring Dependency Injection / IoC
https://docs.spring.io/spring/docs/4.3.22.RELEASE/spring-framework-reference/htmlsingle/

### SQL, JDBC Api
База данных MySQL
Task 8 for ShoppingListApplication
Необходимо установить MySQL.
Подключить базу данных в приложении. (Создать необходимые бины с настройками (@Bean)).
Для каждой сущности создать таблицу в базе данных.

### ORM Hibernate
Migrate to Hibernate
Task 9 for ShoppingListApplication
Необходимо переделать (или добавить новый) класс репозиторий и доменную модель, таким способом, чтобы приложение использовало ORM Hibernate.

### ORM Relations
Hibernate Relationships
Task 10 for ShoppingListApplication
Необходимо добавить новую сущность - ShoppingCart (если такой нет).
Установить отношения между таблицами.
У корзины может быть множество продуктов.
У продукта может быть множество корзин.

### Spring Web
Task 11 for ShoppingListApplication
Необходимо добавить Rest Controller для Product.
В случае если сущностей больше, то и для них соответственно. (ShoppingCart).
Контроллер должен выполнять стандартные операции (CRUD).

### Final Project
ShoppingListApplication
Task 1-11 for ShoppingListApplication: Spring, Hibernate, jUnit
Необходимо отправить ссылку на github репозиторий с проектом.


### Исключения Простая База Данных
Разработайте универсальный интерфейс Repository<T>, который будет представлять следующий набор методов:
##Repository<T>
List<T> findAll();
T findById(String id) throws ItemNotFoundException;
save(T item);
delete(String id) throws ItemNotFoundException;
 
Разработайте класс Book, который будет содержать в себе следующие поля:
##Book
String id
String name
String author
int pagesCount
 
-Обязательные методы для переопределения: equals(), hashCode() и toString().
-Getter методы для всех полей обязательны.
-Инициализация полей через конструктор или setter методы на выбор.

##BookRepository
Разработайте класс BookRepository, который реализует интерфейс Repository для типа Book на основе коллекции Map<String, T>, где T - класс Book.

 - В случае, если книга с переданным идентификатором не найдена, методы findById() и delete() 
 должны выбросить исключение ItemNotFoundException с идентификатором объекта.
Нефункциональные требования:
Продемонстрировать работу методов с учетом логических требований.
Результат:
Загрузить файлы Repository.java, BookRepository.java, Book.java и BookRepositoryDemo.java
 

### Interview Preparation
Rest Web Service
1. Description
Необходимо создать web приложение по управлению собственным туристическим телеграм ботом.
    1) Телеграм бот выдает пользователю справочную информацию о введенном городе. Например, пользователь вводит: «Москва», чат-бот отвечает: «Не забудьте посетить Красную Площадь. Ну а в ЦУМ можно и не заходить)))».
    2) Данные о городах должны храниться в базе данных.
    3) Управлять данными о городах (добавлять новые города и информацию о них, изменять и удалять любую информацию) необходимо через REST WebService.
    Используемые технологии: SpringBoot, SpringMVC, SpringData, Hibernate, Java не ниже 1.8. Для сборки проекта использовать Maven.
   Исходный код приложения должен быть залит на GitHub, в файле readme указать, что необходимо для запуска (в том числе имя телеграм бота и его токен).
 
###  Interview Preparation
Приложение “Комнаты с лампочками”
1. Description
Заходя на веб страницу, пользователь имеет возможность:
- создать комнату, указав ее имя и страну из списка. Страна нужна, чтобы ограничить пользователям доступ в комнату.
- просмотреть список созданных комнат (включая комнаты, созданные другими пользователями)
- “зайти” в одну из комнат и включить/выключить лампочку, находящуюся в ней.
Если страна пользователя отличается от страны комнаты, то при попытке входа в комнату пользователю показывается ошибка.
Определение страны производится по IP адресу пользователя.
Изменение состояния лампочки, должно отображаться для всех пользователей в комнате (как можно быстрее, без перезагрузки страницы)
Логин\регистрация не нужны. 
Требования к реализации:
- Язык программирования серверной части - Java
- UI может быть тривиальным
- Unit/Integration тесты
- Должна быть реализовано сохранение состояния между перезапусками приложения
- Очень желательно иметь возможность запускать одной консольной командой без установки сторонних зависимостей. Если очень хочется  использовать docker/docker-compose.
