package com.github.kaydunovDenis.crud.repository;

import com.github.kaydunovDenis.crud.model.Product;
import java.util.ArrayList;

public class ProductRepository {
    public ArrayList<Product> products = new ArrayList<>();

    public void initialProductRepository() {
        products.add(new Product(new String[]{"Apple 10.0", "10000.0", "PHONE",
                "1000.00", "Содержит подключение с чипом виртуальной реальности"}));
        products.add(new Product(new String[]{"Samsung 6 PRO", "850", "PHONE"}));
        products.add(new Product(new String[]{"Huawei TIT ALL-00", "31234234234324.5634", "PHONE"}));
        products.add(new Product(new String[]{"Huawei tablet 5.1", "420", "TABLET"}));
        products.add(new Product(new String[]{"Huawei tablet 6 PRO", "620", "TABLET"}));
        products.add(new Product(new String[]{"Huawei tablet 5.7", "470","TABLET"}));
        products.add(new Product(new String[]{"Lenovo Plus 2020", "1200", "NOTEBOOK"}));
        products.add(new Product(new String[]{"Lenovo Plus 2021", "1300", "NOTEBOOK", "0.2"}));
        products.add(new Product(new String[]{"Notebook Apple Pro 2021", "5300", "NOTEBOOK"}));
        products.add(new Product(new String[]{"Bug Computer 2016", "458.9", "COMPUTER"}));
        products.add(new Product(new String[]{"Bug Computer 2017", "468.3", "COMPUTER","0.45"}));
        products.add(new Product(new String[]{"Bug Computer 2018", "482.5", "COMPUTER"}));
        products.add(new Product(new String[]{"Agitator 2020 GameMaster 2.0", "91829.56", "COMPUTER"}));
    }

    @Override
    public String toString() {
        String result = "";
        for (Product product : products) {
            result = String.format("%s%s", result, product.toString());
        }
        return result;
    }
}
