package by.jrr.start.model;

import lombok.Data;

@Data
public class User {
    private String firstName;// - имя пользователя
    private String lastName;// - фамилия пользователя
    private int age;//  - возраст пользователя

    private User(){}

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
