package com.github.kaydunovDenis.crud.model;

import com.github.kaydunovDenis.crud.service.ErrorCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    private static Product testProduct1;
    private static Product testProduct2;
    private static Product testProduct3;


    @BeforeAll
    static void beforeAll() {
        try {
            testProduct1 = new Product(new String[]{"Samsung 7 PRO", "1000", "PHONE", "-0.1"});
            testProduct2 = new Product(new String[]{"Samsung 8 PRO", "2000", "PHONE", "1.1"});
            testProduct3 = new Product(new String[]{"Samsung 9 PRO", "3000.50", "PHONE", "0.5"});
        } catch (ErrorCommandException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testValidateAndCreateDiscount() {
        String expect1 = "0";
        String actual1 = testProduct1.discount.toString();
        assertEquals(expect1, actual1);

        String expect2 = "1";
        String actual2 = testProduct2.discount.toString();
        assertEquals(expect2, actual2);
    }

    @Test
    void testReplaceSeparator() {
        String expect = "134.4";
        String actual = Product.replaceSeparator("134,4");
        assertEquals(expect, actual);
    }

    @Test
    void createDescription() {
        String[] args = {"1", "2", "3", "4", "5"};
        String except = "5";
        testProduct1.createDescription(args);
        String actual = testProduct1.description;

        assertEquals(except, actual);

        args = new String[]{"1", "2", "3", "4", "5", "6"};
        except = "5 6";
        testProduct1.createDescription(args);
        actual = testProduct1.description;
        assertEquals(except, actual);

        args = new String[]{"1", "2", "3", "4", "5", "6 Some text", "7"};
        except = "5 6 Some text 7";
        testProduct1.createDescription(args);
        actual = testProduct1.description;
        assertEquals(except, actual);
    }

    @Test
    void testToString() {
        String actual1 = testProduct1.toString();
        String expect1 =
                "ID: " + testProduct1.ID + "\n" +
                        "Name: Телефон Samsung 7 PRO\n" +
                        "Regular price: 1000,00 евро\n" +
                        "Discount: 0,00%\n" +
                        "Actual price: 1000,00 евро\n" +
                        "Description:  - \n\n";
        Assertions.assertEquals(expect1, actual1);

        String actual2 = testProduct2.toString();
        String expect2 =
                "ID: " + testProduct2.ID + "\n" +
                        "Name: Телефон Samsung 8 PRO\n" +
                        "Regular price: 2000,00 евро\n" +
                        "Discount: 100,00%\n" +
                        "Actual price: 0,00 евро\n" +
                        "Description:  - \n\n";
        assertEquals(expect2, actual2);

        String actual3 = testProduct3.toString();
        String expect3 =
                "ID: " + testProduct3.ID + "\n" +
                        "Name: Телефон Samsung 9 PRO\n" +
                        "Regular price: 3000,50 евро\n" +
                        "Discount: 50,00%\n" +
                        "Actual price: 1500,25 евро\n" +
                        "Description:  - \n\n";
        assertEquals(expect3, actual3);
    }
}