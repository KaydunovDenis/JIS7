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
        String[] shortCommand = truncateStartOfCommand(words);
        switch (words[0]) {
            case "-c" -> create(shortCommand);
            case "-r" -> read(shortCommand);
            case "-ra" -> readALL();
            case "-u" -> update(shortCommand);
            case "-d" -> delete(shortCommand[0]);
            case "-menu" -> USER_CONSOLE.printMenu();
            case "-exit" -> USER_CONSOLE.disable();
            default -> throw new ErrorCommandException();
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

    /**
     * @param command []
     * <br> 0 idUpdate: 1 (number Id product, which will update)
     * <br> 1 Name: Apple
     * <br> 2 Regular price: 256.45
     * <br> 3 Product category: PHONE
     * <br> 4 Discount: 0.25
     * <br> 5 Description: some text
     *
     * <br> command = idUpdate + dataUpdateProduct
     * <br> dataUpdateProduct = name + Regular price + category + Discount + Description
     * <br> dataUpdateProduct - data Product, which will replace data old product
     */
    @Override
    public void update(String[] command) throws ErrorCommandException {
        Long idUpdate = idValidate(command[0]);
        Product productUpdate = new Product(truncateStartOfCommand(command));
        CRUD_SERVICE.update(idUpdate, productUpdate);
    }

    /**
     * @param idDeleteProduct - number Id product, which will delete
     */
    @Override
    public void delete(String idDeleteProduct) throws ErrorCommandException {
        idValidate(idDeleteProduct);
        USER_CONSOLE.print(CRUD_SERVICE.delete(Long.parseLong(idDeleteProduct)));
    }

    public static void validateEmptyCommand(String command) throws ErrorCommandException {
        if (command.equals("") || command.isEmpty()) {
            throw new ErrorCommandException();
        }
    }

    public static String[] truncateStartOfCommand(String[] fullCommand) {
        String[] textDataProduct = new String[fullCommand.length - 1];
        if (fullCommand.length - 1 >= 0) {
            System.arraycopy(fullCommand, 1, textDataProduct, 0, fullCommand.length - 1);
        }
        return textDataProduct;
    }

    public static Long idValidate(String textLong) throws ErrorCommandException {
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

    public CrudService getCRUD_SERVICE() {
        return CRUD_SERVICE;
    }
}
