[![trophy](https://github-profile-trophy.vercel.app/?username=KaydunovDenis&theme=darkhub)](https://github.com/ryo-ma/github-profile-trophy)

[![Top Langs](https://github-readme-stats.vercel.app/api/top-langs/?username=KaydunovDenis&layout=compact)](https://github.com/ryo-ma/github-readme-stats) 


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

Task 1-11 for ShoppingListApplication: Spring, Hibernate, jUnit
Необходимо отправить ссылку на github репозиторий с проектом.

