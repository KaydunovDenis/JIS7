package com.github.kaydunovDenis.crud;

import com.github.kaydunovDenis.crud.model.Product;
import com.github.kaydunovDenis.crud.repository.ProductRepository;
import com.github.kaydunovDenis.crud.service.CrudService;

public class CrudAPP {
    public static void main(String[] args) {
        CrudService crudService = new CrudService();
        ProductRepository productRepository = crudService.getPRODUCT_REPOSITORY();
        productRepository.initialProductRepository();
        System.out.println(productRepository.toString());

        System.out.println(crudService.delete(1L));
    }
}
