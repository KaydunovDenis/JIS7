package com.github.kaydunovDenis.crud.service;

import com.github.kaydunovDenis.crud.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CrudServiceTest {
    private static CrudService crudService;
    final Product testProduct = new Product(new String[]{"Samsung 7 PRO", "1150", "PHONE"});

    @BeforeAll
    static void beforeAll() {
        crudService = new CrudService();
    }

    @Test
    void create() {
        boolean expected = crudService.getPRODUCT_REPOSITORY().products.contains(testProduct);
        Assertions.assertFalse(expected);

        crudService.create(testProduct);
        expected = crudService.getPRODUCT_REPOSITORY().products.contains(testProduct);
        Assertions.assertTrue(expected);
    }

    @Test
    void read() {
        int sizeActual = crudService.getPRODUCT_REPOSITORY().products.size();
        Assertions.assertEquals(0, sizeActual);

        crudService.create(testProduct);
        Product result = crudService.getPRODUCT_REPOSITORY().products.get(0);
        Assertions.assertEquals(testProduct, result);
    }

    @Test
    void update() {
        //TODO
    }

    @Test
    void delete() {
        crudService.create(testProduct);
        boolean expected = crudService.getPRODUCT_REPOSITORY().products.contains(testProduct);
        Assertions.assertTrue(expected);

        //TODO допилить тест на проверку после удаления
    }
}