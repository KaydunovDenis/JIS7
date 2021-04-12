package com.github.KaydunovDenis.crud.service;

import com.github.KaydunovDenis.crud.model.Product;
import com.github.KaydunovDenis.crud.uiConsole.UserConsole;

public class UserController implements UserCommandRepository{
    final private CrudService CRUD_SERVICE;
    final private UserConsole USER_CONSOLE;
    final String MESSAGE_ERROR_COMMAND =
            "Error command. Write command according the menu.\n" +
                    "Example commands:\n" +
                    "-r 0\n" +
                    "-ra\n" +
                    "-c SuperPhone 100.0 PHONE";

    public UserController(CrudService crudService, UserConsole userConsole) {
        this.CRUD_SERVICE = crudService;
        this.USER_CONSOLE = userConsole;
    }

    public void execute(String temp) {
        validateEmptyCommand(temp);
        final String SPLIT_SYMBOL = "\\s";
        String[] words = temp.split(SPLIT_SYMBOL);
        //Arrays.stream(words).forEach(System.out::println);
        switch (words[0]) {
            case "-c" -> create(words);
            case "-r" -> read(words[1]);
            case "-ra" -> readALL();
            case "-u" -> update();
            case "-d" -> delete(words);
            case "-menu" -> printMenu();
            case "-exit" -> USER_CONSOLE.stop();
            default -> print(MESSAGE_ERROR_COMMAND);
        }
    }

    private void validateEmptyCommand(String temp) {
        if (temp.equals("") || temp.isEmpty()) {
            print("Некорректный команда. Команда не должна быть пустой");
        }
    }

    @Override
    public void create(String[] command) {
        try {
            Product product = new Product(command);
            CRUD_SERVICE.create(product);
        } catch (IllegalArgumentException e) {
            print("Некорректный ввод продукта");
        }
    }

    @Override
    public void read(String id) {
        print(CRUD_SERVICE.read(Long.parseLong(id)));//TODO validate id
    }

    @Override
    public void readALL() {
        CRUD_SERVICE.readALL();
    }

    @Override
    public void update() {
        CRUD_SERVICE.update();
    }

    @Override
    public void delete(String[] command) {
        final int positionIdProductInCommand = 1;
        if (command.length >= 1) {
            print(CRUD_SERVICE.delete(Long.parseLong(command[positionIdProductInCommand])));
        } else print("Не корректный суффикс команды");
    }

    public void print(String text) {
        System.out.println("SYSTEM:: " + text + "\n");
    }

    //TODO
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
