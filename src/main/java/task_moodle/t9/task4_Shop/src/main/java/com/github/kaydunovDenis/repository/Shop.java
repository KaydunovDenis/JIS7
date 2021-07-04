package com.github.kaydunovDenis.repository;

import com.github.kaydunovDenis.Service.ShopService;
import com.github.kaydunovDenis.model.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Shop implements ShopService {
    private final List<Product> listProducts = new ArrayList<>();

    public Shop() {
    }

    public Shop(Product... products) {
        listProducts.addAll(Arrays.asList(products));
    }

    @Override
    public void addProduct(Product product) {
        listProducts.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        listProducts.remove(product);
    }

    @Override
    public Product findByName(String name) {
        return listProducts.stream()
                .filter(it -> it.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<Product> findProductsByPriceRange(BigDecimal minPriceRange, BigDecimal maxPriceRange) {
        return listProducts.stream()
                .filter(it -> isBetween(it.getPrice(), minPriceRange, maxPriceRange))
                .collect(Collectors.toList());
    }

    private static <T extends Comparable<T>> boolean isBetween(T value, T start, T end) {
        return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
    }
}
