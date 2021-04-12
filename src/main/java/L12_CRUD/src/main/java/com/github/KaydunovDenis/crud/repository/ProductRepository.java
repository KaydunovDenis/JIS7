package com.github.KaydunovDenis.crud.repository;

import com.github.KaydunovDenis.crud.model.Product;
import com.github.KaydunovDenis.crud.model.ProductCategory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private final Map<Long, Product> PRODUCTS = new HashMap<>();

    public void initialProductRepository() {
        PRODUCTS.put(0L, new Product("Apple 10.0", 1000, ProductCategory.PHONE,
                new BigDecimal("0.5"), "Содержит подключение с чипом виртуальной реальности"));
        PRODUCTS.put(1L, new Product("Samsung 6 PRO", 850, ProductCategory.PHONE));
        PRODUCTS.put(2L, new Product("Huawei TIT ALL-00", 31234234234324.5634, ProductCategory.PHONE));
        PRODUCTS.put(3L, new Product("Huawei tablet 5.1", 420, ProductCategory.TABLET));
        PRODUCTS.put(4L, new Product("Huawei tablet 6 PRO", 620, ProductCategory.TABLET));
        PRODUCTS.put(5L, new Product("Huawei tablet 5.7", 470, ProductCategory.TABLET));
        PRODUCTS.put(6L, new Product("Lenovo Plus 2020", 1200, ProductCategory.NOTEBOOK));
        PRODUCTS.put(7L, new Product("Lenovo Plus 2021", 1300, ProductCategory.NOTEBOOK));
        PRODUCTS.put(8L, new Product("Notebook Apple Pro 2021", 5300, ProductCategory.NOTEBOOK));
        PRODUCTS.put(9L, new Product("Bug Computer 2016", 458.9, ProductCategory.COMPUTER));
        PRODUCTS.put(10L, new Product("Bug Computer 2017", 468.3, ProductCategory.COMPUTER));
        PRODUCTS.put(11L, new Product("Bug Computer 2018", 482.5, ProductCategory.COMPUTER));
        PRODUCTS.put(12L, new Product("Agitator 2020 GameMaster 2.0", 91829.56, ProductCategory.COMPUTER));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Long, Product> product : PRODUCTS.entrySet()) {
            result.append(product.toString())
                    .append("\n");
        }
        return result.toString();
    }

    public Map<Long, Product> getPRODUCTS() {
        return PRODUCTS;
    }

}
