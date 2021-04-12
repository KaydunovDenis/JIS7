package com.github.KaydunovDenis.crud;

import com.github.KaydunovDenis.crud.service.Console;
import com.github.KaydunovDenis.crud.service.CrudService;
import com.github.KaydunovDenis.crud.service.UserService;

public class CrudAPP {
    public static void main(String[] args) {
        CrudService crudService = new CrudService();
        crudService.getPRODUCT_REPOSITORY().initialProductRepository();
        UserService userService = new UserService(new CrudService(), new Console());
        userService.start();

    }
}
