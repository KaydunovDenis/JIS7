package com.github.KaydunovDenis.crud.service;

import com.github.KaydunovDenis.crud.model.Product;

import java.io.IOException;

import static com.github.KaydunovDenis.crud.service.Console.reader;

public class UserService implements UserCommandRepository {
    public CrudService crudService;
    public Console console;
    private boolean isAlive = true;

    final String MESSAGE_ERROR_COMMAND =
            "Error command. Write command according the menu.\n" +
            "Example commands:\n" +
            "-r 0\n" +
            "-ra\n" +
            "-c SuperPhone 100.0 PHONE";

    public UserService(CrudService crudService, Console console) {
        this.crudService = crudService;
        this.console = console;
    }

    public void start() {
        try {
            while (isAlive) {
                console.printMenu();
                execute(reader.readLine()
                        .trim());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            console.print("EXIT");
        }
    }

    private void execute(String temp) {
        validateEmptyComand(temp);
        final String SPLIT_SYMBOL = "\\s";
        String[] words = temp.split(SPLIT_SYMBOL);
        //Arrays.stream(words).forEach(System.out::println);
        switch (words[0]) {
            case "-c" -> create(words);
            case "-r" -> read(words[1]);
            case "-ra" -> readALL();
            case "-u" -> update();
            case "-d" -> delete(words);
            case "-menu" -> console.printMenu();
            case "-exit" -> isAlive = false;
            default -> console.print(MESSAGE_ERROR_COMMAND);
        }
    }

    private void validateEmptyComand(String temp) {
        if (temp.equals("") || temp.isEmpty()) {
            console.print("Некорректный команда. Команда не должна быть пустой");
        }
    }

    @Override
    public void create(String[] command) {
        try {
            Product product = new Product(command);
            crudService.create(product);
        } catch (IllegalArgumentException e) {
            console.print("Некорректный ввод продукта");
        }
    }

    @Override
    public void read(String id) {
        console.print(crudService.read(Long.parseLong(id)));//TODO validate id
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
            console.print(crudService.delete(Long.parseLong(command[positionIdProductInCommand])));
        } else console.print("Не корректный суффикс команды");
    }
}