package com.github.kaydunovDenis.crud.repository;

import com.github.kaydunovDenis.crud.model.Product;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

public class ProductRepository {
    public Map<Long, Product> products = new TreeMap<>();

    public void initialProductRepository() {
        put(new Product(new String[]{"Apple 10.0", "10000.0", "PHONE",
                "1000.00", "Содержит подключение с чипом виртуальной реальности"}));
        put(new Product(new String[]{"Samsung 6 PRO", "850", "PHONE"}));
        put(new Product(new String[]{"Huawei TIT ALL-00", "3124.5634", "PHONE"}));
        put(new Product(new String[]{"Huawei tablet 5.1", "420", "TABLET"}));
        put(new Product(new String[]{"Huawei tablet 6 PRO", "620", "TABLET"}));
        put(new Product(new String[]{"Huawei tablet 5.7", "470", "TABLET"}));
        put(new Product(new String[]{"Lenovo Plus 2020", "1200", "NOTEBOOK"}));
        put(new Product(new String[]{"Lenovo Plus 2021", "1300", "NOTEBOOK", "0.2"}));
        put(new Product(new String[]{"Notebook Apple Pro 2021", "5300", "NOTEBOOK", "0.12478"}));
        put(new Product(new String[]{"Bug Computer 2016", "458.9", "COMPUTER","","Made in Belarus"}));
        put(new Product(new String[]{"Bug Computer 2017", "468.3", "COMPUTER", "0.45"}));
        put(new Product(new String[]{"Bug Computer 2018", "482.5", "COMPUTER"}));
        put(new Product(new String[]{"Agitator 2020 GameMaster 2.0", "91829.56", "COMPUTER"}));
    }

    public void put(Product product) {
        products.put(product.ID, product);
    }

    @Override
    public String toString() {
        AtomicReference<String> result = new AtomicReference<>("");
        products.entrySet()
                .forEach(x -> result.set(String.format("%s%s", result.get(), x.toString())));
        return result.get();
    }
}
