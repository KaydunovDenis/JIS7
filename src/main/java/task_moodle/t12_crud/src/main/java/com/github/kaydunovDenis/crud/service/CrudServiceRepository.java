package com.github.kaydunovDenis.crud.service;

import com.github.kaydunovDenis.crud.model.Product;

public interface CrudServiceRepository {
    String create(Product product);

    String read(Long id) throws ErrorCommandException;

    String readALL() throws ErrorCommandException;

    String update(Long idUpdate, Product updateProduct);

    String delete(Long id);
}
