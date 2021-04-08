package com.github.KaydunovDenis.crud.Database;

import com.github.KaydunovDenis.crud.Service.Category;
import com.github.KaydunovDenis.crud.Service.Currency;
import com.github.KaydunovDenis.crud.Service.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Model {
    private final Map<Long, Product> PRODUCTS = new HashMap<>();
    private final Currency defoultCurrency = Currency.EUR;

    public void initialModelDemo() {
        PRODUCTS.put(0L, new Product("Apple 10.0", 1000, Category.PHONE,
                new BigDecimal("0.5"),"Содержит подключение с чипом виртуальной реальности"));
        PRODUCTS.put(1L, new Product("Samsung 6 PRO", 850, Category.PHONE));
        PRODUCTS.put(2L, new Product("Huawei TIT ALL-00", 31234234234324.5634, Category.PHONE));
        PRODUCTS.put(3L, new Product("Huawei tablet 5.1", 420, Category.TABLET));
        PRODUCTS.put(4L, new Product("Huawei tablet 6 PRO", 620, Category.TABLET));
        PRODUCTS.put(5L, new Product("Huawei tablet 5.7", 470, Category.TABLET));
        PRODUCTS.put(6L, new Product("Lenovo Plus 2020", 1200, Category.NOTEBOOK));
        PRODUCTS.put(7L, new Product("Lenovo Plus 2021", 1300, Category.NOTEBOOK));
        PRODUCTS.put(8L, new Product("Notebook Apple Pro 2021", 5300, Category.NOTEBOOK));
        PRODUCTS.put(9L, new Product("Bug Computer 2016", 458.9, Category.COMPUTER));
        PRODUCTS.put(10L, new Product("Bug Computer 2017", 468.3, Category.COMPUTER));
        PRODUCTS.put(11L, new Product("Bug Computer 2018", 482.5, Category.COMPUTER));
        PRODUCTS.put(12L, new Product("Agitator 2020 GameMaster 2.0", 91829.56, Category.COMPUTER));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Long, Product> product: PRODUCTS.entrySet()) {
            result.append(product.toString())
                    .append("\n");
        }
        return result.toString();
    }

    public Map<Long, Product> getListProduct() {
        return PRODUCTS;
    }

    public Currency getDefoultCurrency() {
        return defoultCurrency;
    }
}
