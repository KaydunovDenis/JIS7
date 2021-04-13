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
        PRODUCT_REPOSITORY.put(product);
    }

    @Override
    public String read(Long id) {
        try {
            return PRODUCT_REPOSITORY.getPRODUCTS().get(Math.toIntExact(id)).toString();
        } catch (NullPointerException e) {
            return "Продукт с указанным ID отсутствует";
        }
    }

    @Override
    public String readALL() {
        return PRODUCT_REPOSITORY.toString();
    }

    @Override
    public void update() {

        //TODO
    }

    @Override
    public String delete(Long id) {
        try {
            PRODUCT_REPOSITORY.getPRODUCTS().remove(Math.toIntExact(id));
            return "Удаление id = " + id + " успешно";
        } catch (IndexOutOfBoundsException e) {
            return "Продукт с указанным ID отсутствует";
        }
    }

    public ProductRepository getPRODUCT_REPOSITORY() {
        return PRODUCT_REPOSITORY;
    }
}
