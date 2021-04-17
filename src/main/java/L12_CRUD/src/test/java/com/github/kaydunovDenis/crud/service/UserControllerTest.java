package com.github.kaydunovDenis.crud.service;

import com.github.kaydunovDenis.crud.model.Product;
import com.github.kaydunovDenis.crud.uiConsole.UserConsole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    private static UserController userController;
    final Product testProduct = new Product(new String[]{"Samsung 7 PRO", "1150", "PHONE"});

    @BeforeEach
    void beforeAll() {
        userController = new UserController(new UserConsole());
        userController.getCRUD_SERVICE().create(testProduct);
    }

    @Test
    void execute() {
    }

    @Test
    void create() {
    }

    @Test
    void read() {

    }

    @Test
    void readALL() {
    }

    @Test
    void update() {
        String oldName = testProduct.name;
        String[] testCommand = new String[]{"1", "Samsung 7 PRO+", "1200", "PHONE"};
        try {
            userController.update(testCommand);
        } catch (ErrorCommandException e) {
            assert false;
        }

        String newName = testProduct.name;
        assertEquals(oldName, newName);
        System.out.println(testProduct);

    }

    @Test
    void delete() {
        int expect = 1;
        int actual = userController.getCRUD_SERVICE().getPRODUCT_REPOSITORY().products.size();
        assertEquals(expect, actual);

        try {
            userController.delete("1");
        } catch (ErrorCommandException e) {
            assert false;
        }
        expect = 0;
        actual = userController.getCRUD_SERVICE().getPRODUCT_REPOSITORY().products.size();
        assertEquals(expect, actual);

    }

    @Test
    void validateEmptyCommand() {
        try {
            UserController.validateEmptyCommand("");
        } catch (ErrorCommandException e) {
            assert true;
        }
    }

    @Test
    void truncateStartOfCommand() {
        String[] testString = {"1", "2", "3", "4"};
        String[] expected = {"2", "3", "4"};
        String[] result = UserController.truncateStartOfCommand(testString);

        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
        assertEquals(expected[2], result[2]);
    }

    @Test
    void idValidate() {
        Long expected = 14L;

        Long result = null;
        try {
            result = UserController.idValidate("14");
        } catch (ErrorCommandException e) {
            assert false;
        }
        assertEquals(expected, result);

        try {
            UserController.idValidate("14a");
        } catch (ErrorCommandException e) {
            assert true;
        }
    }
}