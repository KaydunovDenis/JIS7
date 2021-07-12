package com.github.kaydunovDenis;

public class App {
    public static void main(String[] args) {
        check(10);
        check(-10);
    }

    private static void check(int age){
        //check
        assert (age < 0) : "Negative age!!!";//хз не работает
        //realization
        System.out.println("Age = " + age);
    }
}

