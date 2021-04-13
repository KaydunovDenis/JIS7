package com.github.kaydunovDenis.crud.service;

import com.github.kaydunovDenis.crud.model.Product;
import com.github.kaydunovDenis.crud.uiConsole.UserConsole;

public class UserController implements UserCommandRepository{
    final private CrudService CRUD_SERVICE;
    final private UserConsole USER_CONSOLE;
    final int POSITION_ID_IN_COMMAND = 1;


    public UserController(CrudService crudService, UserConsole userConsole) {
        this.CRUD_SERVICE = crudService;
        this.USER_CONSOLE = userConsole;
    }

    public void execute(String temp) throws ErrorCommandException {
        validateEmptyCommand(temp);
        final String SPLIT_SYMBOL = "\\s";
        String[] words = temp.split(SPLIT_SYMBOL);
        if ("-c".equals(words[0])) {
            create(words);
        } else if ("-r".equals(words[0])) {
            read(words);
        } else if ("-ra".equals(words[0])) {
            readALL(words);
        } else if ("-u".equals(words[0])) {
            update(words);
        } else if ("-d".equals(words[0])) {
            delete(words);
        } else if ("-menu".equals(words[0])) {
            printMenu();
        } else if ("-exit".equals(words[0])) {
            USER_CONSOLE.stop();
        } else {
            throw new ErrorCommandException();
        }
    }

    private void validateEmptyCommand(String temp) throws ErrorCommandException {
        if (temp.equals("") || temp.isEmpty()) {
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

    //TODO
    public void printMenu() {
        print("-= Welcome CRUD-SYSTEM! =-\n" +//TODO этого текста здесь не должно быть вынести, и заменить на MENU
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
