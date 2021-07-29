### UserService and UserRepository Unit testing  
Требования:
+ Создать сервис (**UserService**)
+ и репозиторий (**UserRepository**) 
+  для сущности **User**  
- [+]  и протестировать при помощи jUnit.

# User
    + id
    + name
    + age

## UserRepository
- [+] коллекция (users) для хранения пользователей. Используйте HashMap. 
В качестве ключа - id, в качестве значения - user.
- [+] метод (save) для сохранения пользователя в коллекцию

## UserService
Функциональные требования для класса:
метод (addUser) для: 
 - [+] проверки пользователя
 - [+] вызова метода сохранения пользователя в базу данных репозитория. 
 - [+] у класса UserService должна быть зависимость от UserRepository

# Протестировать класс UserService при помощи Unit тестов.
- [+]  В качестве репозитория используйте MockUserRepository.
   * Примечание: Так как при юнит тестировании не используется реальная база,
   необходимо создать mock.
 
# MockUserRepository. 
 - [+] MockUserRepository наследуется от UserRepository
 - [+] триггер был ли вызван mock (isMockTriggered) - тип данных boolean.    
 - [+] Переопределенный метод save. 
   В случае, если метод был вызван — менять состояние isMockTriggered на true.

# Test
 - [+] В тестах проверить, что mock был вызван.  
