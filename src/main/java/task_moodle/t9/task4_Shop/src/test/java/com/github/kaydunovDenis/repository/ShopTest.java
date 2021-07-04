package com.github.kaydunovDenis.repository;

import com.github.kaydunovDenis.model.Product;
import junit.framework.TestCase;

import java.math.BigDecimal;
import java.util.List;

public class ShopTest extends TestCase {
    private Shop shop;
    private final Product product0 = new Product("Coffee", new BigDecimal(8));
    private final Product product1 = new Product("Tea", new BigDecimal("4.5"));
    private final Product product2 = new Product("Sugar", new BigDecimal("1.6"));
    private final Product product3 = new Product("Milk", new BigDecimal("1.5"));

    public void setUp() throws Exception {
        super.setUp();
        shop = new Shop();
    }

    public void testAddProduct() {
        int expect = 0;
        int result = shop.getListProducts().size();
        assertEquals(expect, result);

        shop.addProduct(product0);
        expect = 1;
        result = shop.getListProducts().size();
        assertEquals(expect, result);
    }

    public void testRemoveProduct() {
        shop.getListProducts().add(product0);
        int expect = 1;
        int result = shop.getListProducts().size();
        assertEquals(expect, result);

        shop.removeProduct(product0);
        expect = 0;
        result = shop.getListProducts().size();
        assertEquals(expect, result);
    }

    public void testFindByName() {
        shop.addProduct(product0);
        shop.addProduct(product1);
        Product productResult = shop.findByName("Coffee");
        assertEquals(product0, productResult);
        assertNotSame(product1, productResult);
    }

    public void testFindProductsByPriceRange() {
        shop.addProduct(product0);
        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);

        List<Product> productsResult = shop.findProductsByPriceRange(new BigDecimal(2), new BigDecimal(5));
        assertSame(product1, productsResult.get(0));

        int expect = 1;
        int result = productsResult.size();
        assertEquals(expect, result);
    }
}