JUnit
UserService and UserRepository Unit testing
1. Description
   Требования:
   Создать сервис (UserService) и репозиторий (UserRepository) для сущности User и протестировать при помощи jUnit.

Основная сущность - User. Необходимые параметры:

Идентификатор (id)
имя (name)
возраст (age)
Зависимости (dependencies):

У класса UserService должна быть зависимость от UserRepository

Функциональные требования для класса UserService:

Метод (addUser) для проверки пользователя и вызова метода сохранения пользователя в базу данных у репозитория.
Требования класса UserRepository. Необходимые параметры:

Коллекция (users) для хранения пользователей. Используйте HashMap. В качестве ключа - id, в качестве значения - user.
Функциональные требования для класса UserRepository:

Метод (save) для сохранения пользователя в коллекцию.
Протестировать класс UserService при помощи Unit тестов. В качестве репозитория используйте MockUserRepository.
*Примечание: Так как при юнит тестировании не используется реальная база, необходимо создать mock. Создайте класс MockUserRepository. MockUserRepository наследуется от UserRepository.
Необходимые параметры для MockUserRepository:
триггер был ли вызван mock (isMockTriggered) - тип данных boolean.
Функциональные требования класса MockUserRepository:
Переопределенный метод save. В случае, если метод был вызван — менять состояние isMockTriggered на true.

В тестах проверить, что mock был вызван.

