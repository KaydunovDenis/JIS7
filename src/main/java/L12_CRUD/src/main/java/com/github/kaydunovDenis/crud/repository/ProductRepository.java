package com.github.kaydunovDenis.crud.repository;

import com.github.kaydunovDenis.crud.model.Product;
import com.github.kaydunovDenis.crud.service.ErrorCommandException;

import java.util.ArrayList;

public class ProductRepository {
    public ArrayList<Product> products = new ArrayList<>();

    public void initialProductRepository() {
        Product product = new Product(new String[]{"Apple 10.0", "10000.0", "PHONE",
                "1000.00", "Содержит подключение с чипом виртуальной реальности"});
        products.add(product);
       /* PRODUCTS.put(1L, new Product(new String[]{"Samsung 6 PRO", "850", "PHONE"}));
        PRODUCTS.put(2L, new Product(new String[]{"Huawei TIT ALL-00", "31234234234324.5634", "PHONE"}));
        PRODUCTS.put(3L, new Product(new String[]{"Huawei tablet 5.1", "420", "TABLET"}));
        PRODUCTS.put(4L, new Product(new String[]{"Huawei tablet 6 PRO", "620", "TABLET"}));
        PRODUCTS.put(5L, new Product(new String[]{"Huawei tablet 5.7", "470","TABLET"}));
        PRODUCTS.put(6L, new Product(new String[]{"Lenovo Plus 2020", "1200", "NOTEBOOK"}));
        PRODUCTS.put(7L, new Product(new String[]{"Lenovo Plus 2021", "1300", "NOTEBOOK"}));
        PRODUCTS.put(8L, new Product(new String[]{"Notebook Apple Pro 2021", "5300", "NOTEBOOK"}));
        PRODUCTS.put(9L, new Product(new String[]{"Bug Computer 2016", "458.9", "COMPUTER"}));
        PRODUCTS.put(10L, new Product(new String[]{"Bug Computer 2017", "468.3", "COMPUTER"}));
        PRODUCTS.put(11L, new Product(new String[]{"Bug Computer 2018", "482.5", "COMPUTER"}));
        PRODUCTS.put(12L, new Product(new String[]{"Agitator 2020 GameMaster 2.0", "91829.56", "COMPUTER"}));*/
    }

    public void add(Product product) {
        products.add(product);
    }
}
