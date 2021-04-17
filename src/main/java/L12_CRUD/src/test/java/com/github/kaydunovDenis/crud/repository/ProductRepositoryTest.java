package com.github.kaydunovDenis.crud.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class ProductRepositoryTest {

    @Test
    void initialProductRepository() {
        ProductRepository productRepository = new ProductRepository();
        Assertions.assertTrue(productRepository.products.isEmpty());

        productRepository.initialProductRepository();
        Assertions.assertFalse(productRepository.products.isEmpty());
    }
}