package com.github.kaydunovDenis.crud.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductRepositoryTest {

    @Test
    void initialProductRepository() {
        ProductRepository productRepository = new ProductRepository();
        Assertions.assertTrue(productRepository.products.isEmpty());

        productRepository.initialProductRepository();
        Assertions.assertFalse(productRepository.products.isEmpty());
    }
}