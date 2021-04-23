package com.github.kaydunovDenis.crud.uiConsole;

import com.github.kaydunovDenis.crud.service.ErrorCommandException;
import com.github.kaydunovDenis.crud.service.UserController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserConsole implements Runnable {
    final private UserController USER_CONTROLLER = new UserController(this);
    private boolean isAlive = true;

    @Override
    public void run() {
        String command;
        printHello();
        printMenu();
        try (BufferedReader READER = new BufferedReader(new InputStreamReader(System.in))) {
            while (isAlive) {
                command = READER.readLine();
                execute(command);
            }
        } catch (IOException e) {
            print(e.toString());
        }
    }

    private void execute(String command) {
        try {
            USER_CONTROLLER.execute(command);
        } catch (ErrorCommandException e) {
            print(e.toString());
        }
    }

    public void disable() {
        isAlive = false;
        print("EXIT");
    }

    public static void print(String text) {
        System.out.println("SYSTEM:: " + text + "\n");
    }

    private void printHello() {
        print("-= Welcome to CRUD-SYSTEM =-");
    }

    public void printMenu() {
        print("MENU\n" +
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

    public UserController getUSER_CONTROLLER() {
        return USER_CONTROLLER;
    }
}
