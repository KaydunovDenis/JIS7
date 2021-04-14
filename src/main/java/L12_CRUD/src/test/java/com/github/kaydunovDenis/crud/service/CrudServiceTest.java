package com.github.kaydunovDenis.crud.service;

import com.github.kaydunovDenis.crud.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrudServiceTest {
    private static CrudService crudService;
    final Product testProduct = new Product(new String[]{"Samsung 7 PRO", "1150", "PHONE"});

    @BeforeEach
    void beforeAll() {
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

        String textExpect = testProduct.toString();
        String textResult = crudService.read(result.ID);
        Assertions.assertEquals(textExpect, textResult);
    }

    @Test
    void update() {
        //TODO
    }

    @Test
    void delete() {
        String textExpect = testProduct.ID + CrudService.MESSAGE_NOT_READ;
        String textResult = crudService.delete(testProduct.ID);
        Assertions.assertEquals(textExpect, textResult);

        crudService.create(testProduct);
        boolean expect = crudService.getPRODUCT_REPOSITORY().products.contains(testProduct);
        Assertions.assertTrue(expect);

        crudService.delete(testProduct.ID);
        expect = crudService.getPRODUCT_REPOSITORY().products.contains(testProduct);
        Assertions.assertFalse(expect);
    }
}