package com.github.kaydunovDenis.crud.service;

import com.github.kaydunovDenis.crud.model.Product;
import com.github.kaydunovDenis.crud.uiConsole.UserConsole;

public class UserController implements UserCommandRepository{
    final private CrudService CRUD_SERVICE = new CrudService();
    final private UserConsole USER_CONSOLE;
    final int POSITION_ID_IN_COMMAND = 1;

    public UserController(UserConsole userConsole) {
        USER_CONSOLE = userConsole;
    }

    public void execute(String command) throws ErrorCommandException {
        validateEmptyCommand(command);
        String[] words = command.trim().split("\\s");
        switch (words[0]) {
            case "-c" -> create(words);
            case "-r" -> read(words);
            case "-ra" -> readALL(words);
            case "-u" -> update(words);
            case "-d" -> delete(words);
            case "-menu" -> printMenu();
            case "-exit" -> USER_CONSOLE.stop();
            default -> throw new ErrorCommandException();
        }
    }

    private void validateEmptyCommand(String command) throws ErrorCommandException {
        if (command.equals("") || command.isEmpty()) {
            throw new ErrorCommandException();
        }
    }

    @Override
    public void create(String[] command) throws ErrorCommandException {
        try {
            Product product = new Product(command);
            CRUD_SERVICE.create(product);
        } catch (IllegalArgumentException e) {
            throw new ErrorCommandException();
        }
    }

    @Override
    public void read(String[] command) throws ErrorCommandException {
        if (command.length == 2) {
            print(CRUD_SERVICE.read(Long.parseLong(command[POSITION_ID_IN_COMMAND])));
        } else throw new ErrorCommandException();
    }

    @Override
    public void readALL(String[] command) throws ErrorCommandException {
        if (command.length == 1) {
            print(CRUD_SERVICE.readALL());
        } else throw new ErrorCommandException();
    }

    @Override
    public void update(String[] command) throws ErrorCommandException {
        if (command.length == 1) {
            CRUD_SERVICE.update();
        } else throw new ErrorCommandException();
    }

    @Override
    public void delete(String[] command) throws ErrorCommandException {
        if (command.length == 2) {
            print(CRUD_SERVICE.delete(Long.parseLong(command[POSITION_ID_IN_COMMAND])));
        } else throw new ErrorCommandException();
    }

    public void print(String text) {
        System.out.println("SYSTEM:: " + text + "\n");
    }

    public void printHello() {
        print("-= Welcome to CRUD-SYSTEM =-\n");
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
}
