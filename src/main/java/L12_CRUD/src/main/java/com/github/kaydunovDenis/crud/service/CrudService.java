package com.github.kaydunovDenis.crud.service;

import com.github.kaydunovDenis.crud.model.Product;
import com.github.kaydunovDenis.crud.repository.ProductRepository;

/**
 * +добавление/
 * +удаление/
 * +получение продукта (CRUD operations).
 * Attention Product.ID != index in database;
 */
public class CrudService implements CrudServiceRepository {
    final private ProductRepository PRODUCT_REPOSITORY = new ProductRepository();
    final public static String MESSAGE_CREATE = " has add in database successfully.";
    final public static String MESSAGE_NOT_READ = " - this ID not found in database.";
    final public static  String MESSAGE_DELETE = " has delete from database successfully";

    @Override
    public String create(Product product) {
        PRODUCT_REPOSITORY.products.add(product);
        return product.name + MESSAGE_CREATE;
    }

    @Override
    public String read(Long id) {
        for (Product product : PRODUCT_REPOSITORY.products) {
            if (product.ID.equals(id)) {
                return product.toString();
            }
        }
        return id.toString() + MESSAGE_NOT_READ;
    }

    @Override
    public String readALL() {
        return PRODUCT_REPOSITORY.toString();
    }

    @Override
    public String update() {
        //TODO
        return "Function don't work";
    }

    /**
     * @param id - product ID
     * @return text rapport about success of operation
     */
    @Override
    public String delete(Long id) {
        for (Product product : PRODUCT_REPOSITORY.products) {
            if (product.ID.equals(id)) {
                PRODUCT_REPOSITORY.products.remove(product);
                return product.name + MESSAGE_DELETE;
            }
        }
        return id.toString() + MESSAGE_NOT_READ;
    }

    public ProductRepository getPRODUCT_REPOSITORY() {
        return PRODUCT_REPOSITORY;
    }
}
