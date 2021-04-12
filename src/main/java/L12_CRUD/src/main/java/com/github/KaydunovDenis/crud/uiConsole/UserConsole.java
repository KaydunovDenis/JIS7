package com.github.KaydunovDenis.crud.uiConsole;

import com.github.KaydunovDenis.crud.service.CrudService;
import com.github.KaydunovDenis.crud.service.UserController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserConsole {
    final public static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    final private UserController USER_CONTROLLER;
    private boolean isAlive = true;

    public UserConsole(CrudService crudService) {
        USER_CONTROLLER = new UserController(crudService, this);
    }

    public void start() {
        try {
            while (isAlive) {
                USER_CONTROLLER.printMenu();
                USER_CONTROLLER.execute(READER.readLine().trim());
            }
            READER.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            USER_CONTROLLER.print("EXIT");
        }
    }

    public void stop() {
        isAlive = false;
    }
}
