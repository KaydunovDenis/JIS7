package com.github.KaydunovDenis.crud.UIConsole;

import com.github.KaydunovDenis.crud.Service.CrudService;
import com.github.KaydunovDenis.crud.Repository.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console implements UserInterface {
    public final CrudService crudService = new CrudService();
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    boolean isAlive = true;

    public void start() {
        try {
            while (isAlive) {
                printMenu();
                execute(reader.readLine()
                        .trim());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            print("EXIT");
        }
    }

    private void execute(String temp) {
        if (temp.equals("") || temp.isEmpty()) {
            print("Некорректный ввод");
        }
        String[] words = temp.split("\\s");
        //Arrays.stream(words).forEach(System.out::println);
        switch (words[0]) {
            case "-c":
                create(words);
                break;
            case "-r":
                read(words[1]);
                break;
            case "-ra":
                readALL();
                break;
            case "-u":
                update();
                break;
            case "-d":
                delete(words);
                break;
            case "menu":
                printMenu();
                break;
            case "-exit":
                isAlive = false;
                break;
            default:
                print("Некорректная команда");
        }
    }

    public void print(String text) {
        System.out.println("SYSTEM:: " + text + "\n");
    }

    @Override
    public void create(String[] command) {
        try {
            Product product = new Product(command);
            crudService.create(product);
        } catch (IllegalArgumentException e) {
            print("Некорректный ввод продукта");
        }
    }

    @Override
    public void read(String id) {
        print(crudService.read(Long.parseLong(id)));
    }

    @Override
    public void readALL() {
        crudService.readALL();
    }

    @Override
    public void update() {
        crudService.update();
    }

    @Override
    public void delete(String[] command) {
        final int positionIdProductInCommand = 1;
        if (command.length >= 1) {
            print(crudService.delete(Long.parseLong(command[positionIdProductInCommand])));
        } else print("Не корректный суффикс команды");
    }

    public void printMenu() {
        print("-= Welcome CRUD-SYSTEM! =-\n" +
                "Use command to control SYSTEM:\n" +
                "-c create product\n" +
                "-r Х : read product where id=X\n" +
                "-ra : read all product from database\n" +
                "-u update the product on id\n" +
                "-d delete product from data base\n" +
                "menu show the menu of program\n" +
                "exit exit from the program"
        );
    }
}