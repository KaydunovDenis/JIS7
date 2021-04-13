package com.github.kaydunovDenis.crud.uiConsole;

import com.github.kaydunovDenis.crud.service.CrudService;
import com.github.kaydunovDenis.crud.service.ErrorCommandException;
import com.github.kaydunovDenis.crud.service.UserController;
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
        String tempCommand;
        USER_CONTROLLER.printMenu();
        while (isAlive) {
            try {
                tempCommand = READER.readLine().trim();
                USER_CONTROLLER.execute(tempCommand);
            } catch (ErrorCommandException e) {
                USER_CONTROLLER.print(e.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            READER.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        USER_CONTROLLER.print("EXIT");
    }

    public void stop() {
        isAlive = false;
    }
}
