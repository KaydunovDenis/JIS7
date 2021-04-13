package com.github.kaydunovDenis.crud.service;

import com.github.kaydunovDenis.crud.model.Product;
import com.github.kaydunovDenis.crud.repository.ProductRepository;

/**
 * +добавление/
 * +удаление/
 * +получение продукта (CRUD operations).
 */
public class CrudService implements CrudServiceRepository {
    final private ProductRepository PRODUCT_REPOSITORY = new ProductRepository();

    @Override
    public void create(Product product) {
        PRODUCT_REPOSITORY.add(product);
    }

    @Override
    public String read(Long id) {
        //TODO
        return "Function don't work";
    }

    @Override
    public String readALL() {
        //TODO
        return "Function don't work";
    }

    @Override
    public String update() {
        //TODO
        return "Function don't work";
    }

    @Override
    public String delete(Long id) {
        /*try {
            PRODUCT_REPOSITORY.getPRODUCTS().remove(Math.toIntExact(id));
            return "Удаление id = " + id + " успешно";
        } catch (IndexOutOfBoundsException e) {
            return "Продукт с указанным ID отсутствует";
        }*/
        //TODO
        return "Function don't work";
    }

    public ProductRepository getPRODUCT_REPOSITORY() {
        return PRODUCT_REPOSITORY;
    }
}
