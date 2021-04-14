package com.github.kaydunovDenis.crud;

import com.github.kaydunovDenis.crud.service.UserController;
import com.github.kaydunovDenis.crud.uiConsole.UserConsole;

public class CrudAPP {
    public static void main(String[] args) {
        /*CrudService crudService = new CrudService();
        ProductRepository productRepository = crudService.getPRODUCT_REPOSITORY();
        productRepository.initialProductRepository();
        */
        UserConsole userConsole = new UserConsole();
        UserController userController = new UserController(userConsole);
        userConsole.start();

    }
}
