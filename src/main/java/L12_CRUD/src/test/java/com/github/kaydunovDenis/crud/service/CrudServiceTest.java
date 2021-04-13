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
        boolean expected = crudService.getPRODUCT_REPOSITORY().getPRODUCTS().contains(testProduct);
        Assertions.assertFalse(expected);

        crudService.create(testProduct);
        expected = crudService.getPRODUCT_REPOSITORY().getPRODUCTS().contains(testProduct);
        Assertions.assertTrue(expected);
    }

    @Test
    void read() throws ErrorCommandException {
        Product expected = testProduct;
        Product result;
        try {
            result = crudService.getPRODUCT_REPOSITORY().get(testProduct.ID);
            Assertions.assertNotEquals(expected, result);
        } catch (ErrorCommandException e) {
            e.printStackTrace();
            Assertions.assertFalse(false);
        }

        crudService.create(testProduct);
        result = crudService.getPRODUCT_REPOSITORY().get(testProduct.ID);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void update() {
        //TODO
    }

    @Test
    void delete() {
        crudService.create(testProduct);
        boolean expected = crudService.getPRODUCT_REPOSITORY().getPRODUCTS().contains(testProduct);
        Assertions.assertTrue(expected);

        crudService.delete(testProduct.ID);
        expected = crudService.getPRODUCT_REPOSITORY().getPRODUCTS().contains(testProduct);
        Assertions.assertFalse(expected);
    }
}