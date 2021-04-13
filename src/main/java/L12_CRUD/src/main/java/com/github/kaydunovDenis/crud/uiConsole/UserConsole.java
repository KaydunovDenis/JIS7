package com.github.kaydunovDenis.crud.uiConsole;

import com.github.kaydunovDenis.crud.service.CrudService;
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
        while (isAlive) {
            try (BufferedReader READER = new BufferedReader(new InputStreamReader(System.in))) {
                command = READER.readLine();
                USER_CONTROLLER.execute(command);
            } catch (ErrorCommandException e) {
                USER_CONTROLLER.print(e.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        isAlive = false;
        USER_CONTROLLER.print("EXIT");
    }
}
