package com.github.kaydunovDenis.Service;

import com.github.kaydunovDenis.model.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * [-]Добавить товар
 * [-]Удалить товар
 * [-]Найти товар по названию
 * [-]Найти все товары, которые входят в ценовой диапазон
 * (findProduct(BigDecimal minPriceRange, BigDecimal maxPriceRange)
 */
public interface ShopService {
    void addProduct(Product product);

    void removeProduct(Product product);

    Product findByName(String name);

    List<Product> findProductsByPriceRange(BigDecimal minPriceRange, BigDecimal maxPriceRange);
}
