package com.github.KaydunovDenis.crud.service;

import com.github.KaydunovDenis.crud.model.Product;

public interface CrudServiceRepository {
    void create(Product product);
    String read(Long id);
    void readALL();
    void update();
    String delete(Long id);
}
