package com.github.kaydunovDenis.crud.uiConsole;

import com.github.kaydunovDenis.crud.service.ErrorCommandException;
import com.github.kaydunovDenis.crud.service.UserController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserConsole {
    final private UserController USER_CONTROLLER = new UserController(this);
    private boolean isAlive = true;

    public void start() {
        String command;
        USER_CONTROLLER.printHello();
        USER_CONTROLLER.printMenu();
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

    public void stop() {
        isAlive = false;
        print("EXIT");
    }

    public void print(String text) {
        System.out.println("SYSTEM:: " + text + "\n");
    }
}
