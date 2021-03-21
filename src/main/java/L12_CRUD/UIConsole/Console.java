package L12_CRUD.UIConsole;

import L12_CRUD.Database.Model;
import L12_CRUD.Service.CRUD;
import L12_CRUD.Service.Category;
import L12_CRUD.Service.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console implements UserInterface {
    public final CRUD crud = new CRUD(new Model());
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    boolean isAlive = true;

    public void start() {
        printMenu();
        try {
            while (isAlive) {
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
                create(temp);
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
                delete(words[1]);
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
    public void create(String text) {
        //TODO
        Product product = new Product("asd", 2, Category.NOTEBOOK);
        crud.create(product);
    }

    @Override
    public void read(String id) {
        print(crud.read(Long.parseLong(id)));
    }

    @Override
    public void readALL() {
        crud.readALL();
    }

    @Override
    public void update() {
        crud.update();
    }

    @Override
    public void delete(String id) {
        print(crud.delete(Long.parseLong(id)));
    }

    public void printMenu() {
        print("-= Welcome CRUD-SYSTEM! =-\n\n" +
                "Use command to control SYSTEM:\n" +
                "-c create\n" +
                "-r read\n" +
                "-ra read all\n" +
                "-u update\n" +
                "-d delete\n" +
                "-exit"
        );
    }
}
