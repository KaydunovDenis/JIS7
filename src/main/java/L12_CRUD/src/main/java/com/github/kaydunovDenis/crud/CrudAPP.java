package com.github.kaydunovDenis.crud;

import com.github.kaydunovDenis.crud.uiConsole.UserConsole;

public class CrudAPP {
    public static void main(String[] args) {
        UserConsole userConsole = new UserConsole();
        userConsole.getUSER_CONTROLLER().getCRUD_SERVICE().getPRODUCT_REPOSITORY().initialProductRepository();

        //Product product = new Product(new String[]{"Acer", "2000.998", "NOTEBOOK", "0.23"});
        //userConsole.getUSER_CONTROLLER().getCRUD_SERVICE().getPRODUCT_REPOSITORY().put(product);
        //userConsole.run();
    }
}
