package com.github.kaydunovDenis.crud.service;

import com.github.kaydunovDenis.crud.model.Product;
import com.github.kaydunovDenis.crud.repository.ProductRepository;

/**
 * The service complete next functions with products in a database:
 * - create/write
 * - read - read one product
 * - readAll - read all product
 * - update - change the data of product
 * - delete - delete one product
 * Attention Product.ID != index in database;
 */
public class CrudService implements CrudServiceRepository {
    final private ProductRepository PRODUCT_REPOSITORY = new ProductRepository();
    final public static String MESSAGE_CREATE = " has add in database successfully.";
    final public static String MESSAGE_NOT_READ = " - this ID not found in database.";
    final public static  String MESSAGE_UPDATE = " - this product has update successfully.";
    final public static  String MESSAGE_DELETE = " has delete from database successfully.";

    @Override
    public String create(Product product) {
        PRODUCT_REPOSITORY.products.add(product);
        return product.name + MESSAGE_CREATE;
    }

    @Override
    public String read(Long idRead) {
        for (Product product : PRODUCT_REPOSITORY.products) {
            if (product.ID.equals(idRead)) {
                return product.toString();
            }
        }
        return idRead.toString() + MESSAGE_NOT_READ;
    }

    @Override
    public String readALL() {
        return PRODUCT_REPOSITORY.toString();
    }

    /**
     * @param idUpdate - number Id product, which will update
     * @param updateProduct - data Product, which will replace data old product
     * @return text rapport about the success of operation
     */
    @Override
    public String update(Long idUpdate, Product updateProduct) {
        for (Product item : PRODUCT_REPOSITORY.products) {
            if (item.ID.equals(idUpdate)) {
                PRODUCT_REPOSITORY.products.add(updateProduct);
                delete(idUpdate);
                return updateProduct.name + MESSAGE_UPDATE;
            }
        }
        return idUpdate + MESSAGE_NOT_READ;
    }

    /**
     * @param idDelete - product ID, which will delete
     * @return text rapport about the success of operation
     */
    @Override
    public String delete(Long idDelete) {
        for (Product product : PRODUCT_REPOSITORY.products) {
            if (product.ID.equals(idDelete)) {
                PRODUCT_REPOSITORY.products.remove(product);
                return product.name + MESSAGE_DELETE;
            }
        }
        return idDelete.toString() + MESSAGE_NOT_READ;
    }

    public ProductRepository getPRODUCT_REPOSITORY() {
        return PRODUCT_REPOSITORY;
    }
}
