package com.github.kaydunovDenis.crud.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    final Product testProduct1 = new Product(new String[]{"Samsung 7 PRO", "1150", "PHONE", "-0.1"});
    final Product testProduct2 = new Product(new String[]{"Samsung 7 PRO", "1150", "PHONE", "1.1"});



    @Test
    void validateAndCreateDiscount() {
        String expect1 = "0";
        String actual1 = testProduct1.discount.toString();
        assertEquals(expect1, actual1);

        String expect2 = "1";
        String actual2 = testProduct2.discount.toString();
        assertEquals(expect2, actual2);
    }

    @Test
    void testToString() {
        String actual = testProduct1.toString();
        String expect = "Product information:\n" +
                "ID: " + testProduct1.ID + "\n" +
                "Name: Телефон Samsung 7 PRO\n" +
                "Regular price: 1150 евро\n" +
                "Discount: 0%\n" +
                "Actual price: 1150.0 евро\n" +
                "Description:  - \n\n";
        assertEquals(expect, actual);
    }
}