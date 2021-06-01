package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Product;
import com.github.kaydunovDenis.repository.ProductRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductRepositoryService {
    public static Product findMostExpensiveProductWithoutDiscount(ProductRepository productRepository) {
        System.out.println("\nНайти самый дорогой продукт у которого нет скидки:");
        return productRepository.getListProducts().stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getDiscount() == 0)
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow();
    }

    public static Product findCheapestProductWithMaxDiscount(ProductRepository productRepository) {
        System.out.println("\nНайти самый дешевый продукт с самой большой скидкой:");
        return productRepository.getListProducts().stream()
                .min(Comparator.comparing(Product::getPrice)
                        .thenComparing((o1, o2) -> Double.compare(o2.getDiscount(), o1.getDiscount())))
                .orElseThrow();
    }

    public static List<Product> findProductsWithDiscountAndPrice(ProductRepository productRepository) {
        System.out.println("\nНайти продукты со скидкой более 30% у которых цена не более 10.5 рублей:");
        return productRepository.getListProducts().stream()
                .filter(x -> x.getDiscount() > 30 && x.getPrice() < 10.5)
                .collect(Collectors.toList());
    }

    public static List<Product> sortListProductByAscendingPriceFirstByWithoutDiscount(ProductRepository productRepository) {
        System.out.println("/n Отсортируйте продукты по цене по возрастанию" +
                "сначала те у которых скидки нет, затем идут отсортированные по цене со скидкой:");
        return productRepository.getListProducts().stream()
                .sorted(Comparator
                        .comparing(Product::getDiscount)
                        .thenComparing(Product::getPrice))
                .collect(Collectors.toList());
    }
}
