package com.github.KaydunovDenis.crud;

import com.github.KaydunovDenis.crud.service.CrudService;
import com.github.KaydunovDenis.crud.uiConsole.UserConsole;

public class CrudAPP {
    public static void main(String[] args) {
        CrudService crudService = new CrudService();
        crudService.getPRODUCT_REPOSITORY().initialProductRepository();
        UserConsole userConsole = new UserConsole(crudService);
        userConsole.start();
    }
}
