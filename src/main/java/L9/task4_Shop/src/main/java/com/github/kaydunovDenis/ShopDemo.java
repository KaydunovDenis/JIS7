package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Product;
import com.github.kaydunovDenis.repository.Shop;

import java.math.BigDecimal;

public class ShopDemo {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Product product0 = new Product("Coffee", new BigDecimal(8));
        Product product1 = new Product("Tea", new BigDecimal("4.5"));
        Product product2 = new Product("Sugar", new BigDecimal("1.6"));
        Product product3 = new Product("Milk", new BigDecimal("1.5"));

        shop.addProduct(product0);
        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);

        System.out.println(shop.findByName("Coffee"));

        shop = new Shop(product0, product1, product2, product3);
        System.out.println(shop.findProductsByPriceRange(new BigDecimal("1.55"), new BigDecimal(5)));

        System.out.println("Before deleting");
        shop.getListProducts().forEach(System.out::println);
        shop.removeProduct(product3);
        shop.removeProduct(product2);
        System.out.println("After deleting");
        shop.getListProducts().forEach(System.out::println);

    }
}

