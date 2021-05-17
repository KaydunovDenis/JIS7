package com.github.kaydunovDenis.repository;

import com.github.kaydunovDenis.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductRepository {
    private static final Random RANDOM = new Random();
    private final List<Product> listProducts = new ArrayList<>();

    public void generateTestProduct(int count, int rangeMinForPrice, int rangeMaxForPrice) {
        Product product;
        String name;
        double price;
        double discount;
        int rangeMinForDiscount = 0;
        int rangeMaxForDiscount = 100;
        for (int i = 0; i < count; i++) {
            name = "Name" + i;
            price = rangeMinForPrice + (rangeMaxForPrice - rangeMinForPrice) * RANDOM.nextDouble();
            discount = rangeMinForDiscount + (rangeMaxForDiscount - rangeMinForDiscount) * RANDOM.nextDouble();
            product = new Product(name, price, discount);
            listProducts.add(product);
        }

        Product product1 = new Product("ZeroDiscount1", 10, 0);
        Product product2 = new Product("ZeroDiscount1", 20, 0);
        listProducts.add(product1);
        listProducts.add(product2);

        Product product3 = new Product("CheapProduct1", 0.01, 70);
        Product product4 = new Product("CheapProduct2", 0.01, 90);
        Product product5 = new Product("CheapProduct3", 0.01, 80);
        listProducts.add(product3);
        listProducts.add(product4);
        listProducts.add(product5);
    }

    public List<Product> getListProducts() {
        return listProducts;
    }
}

