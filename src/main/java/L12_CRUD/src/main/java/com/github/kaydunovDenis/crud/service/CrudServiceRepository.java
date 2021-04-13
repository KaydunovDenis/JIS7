package com.github.kaydunovDenis.crud.service;

import com.github.kaydunovDenis.crud.model.Product;

public interface CrudServiceRepository {
    void create(Product product);

    String read(Long id);

    String readALL();

    String update();

    String delete(Long id);
}
