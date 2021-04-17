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
    void read() throws ErrorCommandException {
        int sizeActual = crudService.getPRODUCT_REPOSITORY().products.size();
        Assertions.assertEquals(0, sizeActual);

        crudService.create(testProduct);
        Product actual = crudService.getPRODUCT_REPOSITORY().products.get(0);
        Assertions.assertEquals(testProduct, actual);

        String expectedText = testProduct.toString();
        String actualText = crudService.read(actual.ID);
        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    void update() {
        crudService.create(testProduct);
        Product dataUpdeteProduct = new Product(new String[]{"New Name", "100", "PHONE", "0.2"});
        Product actualProduct = crudService.getPRODUCT_REPOSITORY().products.get(0);
        Assertions.assertEquals(testProduct, actualProduct);

        crudService.update(testProduct.ID, dataUpdeteProduct);
        actualProduct = crudService.getPRODUCT_REPOSITORY().products.get(0);
        Assertions.assertNotEquals(testProduct, actualProduct);
        Assertions.assertEquals(dataUpdeteProduct, actualProduct);

        //TODO
    }

    @Test
    void delete() {
        String expectedText = testProduct.ID + CrudService.MESSAGE_NOT_READ;
        String actualText = crudService.delete(testProduct.ID);
        Assertions.assertEquals(expectedText, actualText);

        crudService.create(testProduct);
        boolean expect = crudService.getPRODUCT_REPOSITORY().products.contains(testProduct);
        Assertions.assertTrue(expect);

        crudService.delete(testProduct.ID);
        expect = crudService.getPRODUCT_REPOSITORY().products.contains(testProduct);
        Assertions.assertFalse(expect);
    }
}