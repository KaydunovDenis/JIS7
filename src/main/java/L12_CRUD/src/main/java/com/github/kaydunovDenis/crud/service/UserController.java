package com.github.kaydunovDenis.crud.service;

import com.github.kaydunovDenis.crud.model.Product;
import com.github.kaydunovDenis.crud.uiConsole.UserConsole;

public class UserController implements UserCommandRepository{
    final private CrudService CRUD_SERVICE = new CrudService();
    final private UserConsole USER_CONSOLE;
    final int POSITION_ID_IN_COMMAND = 0;

    public UserController(UserConsole userConsole) {
        USER_CONSOLE = userConsole;
    }

    public void execute(String command) throws ErrorCommandException {
        validateEmptyCommand(command);
        String[] words = command.trim().split("\\s");
        String[] shortComand = truncateStartOfCommand(words);
        switch (words[0]) {
            case "-c" -> create(shortComand);
            case "-r" -> read(shortComand);
            case "-ra" -> readALL();
            case "-u" -> update(shortComand);
            case "-d" -> delete(shortComand);
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
    public void create(String[] command) {
        CRUD_SERVICE.create(new Product(command));
    }

    @Override
    public void read(String[] command) throws ErrorCommandException {
        Long idRead = idValidate(command[POSITION_ID_IN_COMMAND]);
        USER_CONSOLE.print(CRUD_SERVICE.read(idRead));
    }

    @Override
    public void readALL() throws ErrorCommandException {
        USER_CONSOLE.print(CRUD_SERVICE.readALL());
    }

    @Override
    public void update(String[] command) throws ErrorCommandException {
        Long idUpdate = idValidate(command[0]);
        Product productUpdate = new Product(truncateStartOfCommand(command));
        CRUD_SERVICE.update(idUpdate, productUpdate);
    }

    @Override
    public void delete(String[] command) throws ErrorCommandException {
        if (command.length == 1) {
            USER_CONSOLE.print(CRUD_SERVICE.delete(Long.parseLong(command[POSITION_ID_IN_COMMAND])));
        } else throw new ErrorCommandException();
    }

    public void printHello() {
        USER_CONSOLE.print("-= Welcome to CRUD-SYSTEM =-");
    }

    private String[] truncateStartOfCommand(String[] fullCommand) {
        String[] dataProduct = new String[fullCommand.length - 1];
        if (fullCommand.length - 1 >= 0) {
            System.arraycopy(fullCommand, 1, dataProduct, 0, fullCommand.length - 1);
        }
        return dataProduct;
    }

    private Long idValidate(String textLong) throws ErrorCommandException {
        try {
            long id  = Long.parseLong(textLong);
            if (id <= 0) {
                throw new ErrorCommandException("ID must be >0");
            }
            return id;
        } catch (NumberFormatException exception) {
            throw new ErrorCommandException("Your command include invalid product id.");
        }
    }

    public void printMenu() {
        USER_CONSOLE.print("MENU\n" +
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
