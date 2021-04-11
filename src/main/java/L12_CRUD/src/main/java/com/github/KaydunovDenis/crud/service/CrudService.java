package com.github.KaydunovDenis.crud.service;

import com.github.KaydunovDenis.crud.model.Product;
import com.github.KaydunovDenis.crud.repository.ProductRepository;

/**
 * +добавление/
 * +удаление/
 * +получение продукта (CRUD operations).
 */
public class CrudService implements CrudServiceRepository {
    final private ProductRepository PRODUCT_REPOSITORY = new ProductRepository();

    @Override
    public void create(Product product) {
        PRODUCT_REPOSITORY.getListProduct().put(product.ID, product);
    }

    @Override
    public String read(Long id) {
        try {
            return PRODUCT_REPOSITORY.getListProduct().get(id).toString();
        } catch (NullPointerException e) {
            return "Продукт с указанным ID отсутствует";
        }
    }

    @Override
    public void readALL() {
        System.out.println(PRODUCT_REPOSITORY.toString());
    }

    @Override
    public void update() {
        //TODO
    }

    @Override
    public String delete(Long id) {
        try {
            PRODUCT_REPOSITORY.getListProduct().remove(id);
            return "Удаление id = " + id + " успешно";
        } catch (IndexOutOfBoundsException e) {
            return "Продукт с указанным ID отсутствует";
        }
    }

    public ProductRepository getPRODUCT_REPOSITORY() {
        return PRODUCT_REPOSITORY;
    }
}
