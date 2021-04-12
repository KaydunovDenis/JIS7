package com.github.KaydunovDenis.crud.service;

import com.github.KaydunovDenis.crud.model.Product;
import com.github.KaydunovDenis.crud.model.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CrudServiceTest {
    private static CrudService crudService;
    final Product testProduct = new Product("Samsung 7 PRO", 1150, ProductCategory.PHONE);

    @BeforeAll
    static void beforeAll() {
        crudService = new CrudService();
    }

    @Test
    void create() {
        boolean expected = crudService.getPRODUCT_REPOSITORY().getPRODUCTS().containsValue(testProduct);
        Assertions.assertFalse(expected);

        crudService.create(testProduct);
        expected = crudService.getPRODUCT_REPOSITORY().getPRODUCTS().containsValue(testProduct);
        Assertions.assertTrue(expected);
    }

    @Test
    void read() {
        Product expected = testProduct;
        Product result = crudService.getPRODUCT_REPOSITORY().getPRODUCTS().get(testProduct.ID);
        Assertions.assertNotEquals(expected, result);

        crudService.create(testProduct);
        result = crudService.getPRODUCT_REPOSITORY().getPRODUCTS().get(testProduct.ID);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void update() {
        //TODO
    }

    @Test
    void delete() {
        crudService.create(testProduct);
        boolean expected = crudService.getPRODUCT_REPOSITORY().getPRODUCTS().containsValue(testProduct);
        Assertions.assertTrue(expected);

        crudService.delete(testProduct.ID);
        expected = crudService.getPRODUCT_REPOSITORY().getPRODUCTS().containsValue(testProduct);
        Assertions.assertFalse(expected);
    }
}