package com.github.kaydunovDenis.crud;

import com.github.kaydunovDenis.crud.uiConsole.UserConsole;

public class CrudAPP {
    public static void main(String[] args) {
        UserConsole userConsole = new UserConsole();
        userConsole.getUSER_CONTROLLER().getCRUD_SERVICE().getPRODUCT_REPOSITORY().initialProductRepository();
        userConsole.run();
        //TODO как тестировать приватные методы?
    }
}
