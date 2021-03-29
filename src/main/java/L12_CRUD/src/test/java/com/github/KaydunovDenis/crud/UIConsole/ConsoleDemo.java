package com.github.KaydunovDenis.crud.UIConsole;

public class ConsoleDemo {
    public static void main(String[] args) {
        Console console = new Console();
        console.crudService.getModel().initialModelDemo();
        console.start();
    }
}
