package com.github.KaydunovDenis.crud.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {
    final public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void print(String text) {
        System.out.println("SYSTEM:: " + text + "\n");
    }

    public void printMenu() {
        print("-= Welcome CRUD-SYSTEM! =-\n" +
                "Use command to control SYSTEM:\n" +
                "-c : create product\n" +
                "-r Х : read product where id=X\n" +
                "-ra : read all product from database\n" +
                "-u : update the product on id\n" +
                "-d : delete product from data base\n" +
                "-menu : show the menu of program\n" +
                "-exit : exit from the program"
        );
    }

}
