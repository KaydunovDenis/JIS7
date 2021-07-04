package com.github.kaydunovDenis.crud.service;

import com.github.kaydunovDenis.crud.model.Product;
import com.github.kaydunovDenis.crud.repository.ProductRepository;

import java.util.Map;

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
    final public static String MESSAGE_UPDATE = " - this product has update successfully.";
    final public static String MESSAGE_DELETE = " has delete from database successfully.";
    final public static String MESSAGE_DATABASE_EMPTY = "Database is empty.";

    @Override
    public String create(Product product) {
        PRODUCT_REPOSITORY.put(product);
        return product.name + MESSAGE_CREATE;
    }

    @Override
    public String read(Long idRead) throws ErrorCommandException {
        validateEmptyDatabase();
        for (Map.Entry<Long, Product> entry : PRODUCT_REPOSITORY.products.entrySet()) {
            if (entry.getKey().equals(idRead)) {
                return entry.getValue().toString();
            }
        }
        return idRead.toString() + MESSAGE_NOT_READ;
    }

    @Override
    public String readALL() throws ErrorCommandException {
        validateEmptyDatabase();
        return PRODUCT_REPOSITORY.toString();
    }

    private void validateEmptyDatabase() throws ErrorCommandException {
        if (PRODUCT_REPOSITORY.products.size() <= 0) {
            throw new ErrorCommandException(MESSAGE_DATABASE_EMPTY);
        }
    }

    /**
     * @param idUpdate      - number Id product, which will update
     * @param updateProduct - data Product, which will replace data old product
     * @return text rapport about the success of operation
     */
    @Override
    public String update(Long idUpdate, Product updateProduct) {
        for (Map.Entry<Long, Product> entry : PRODUCT_REPOSITORY.products.entrySet()) {
            if (entry.getKey().equals(idUpdate)) {
                entry.setValue(updateProduct);
                return updateProduct.name + MESSAGE_UPDATE;
            }
        }
        return idUpdate.toString() + MESSAGE_NOT_READ;
    }

    /**
     * @param idDelete - product ID, which will delete
     * @return text rapport about the success of operation
     */
    @Override
    public String delete(Long idDelete) {
        for (Map.Entry<Long, Product> entry : PRODUCT_REPOSITORY.products.entrySet()) {
            if (entry.getKey().equals(idDelete)) {
                PRODUCT_REPOSITORY.products.remove(idDelete);
                return entry.getValue().name + MESSAGE_DELETE;
            }
        }
        return idDelete.toString() + MESSAGE_NOT_READ;
    }

    public ProductRepository getPRODUCT_REPOSITORY() {
        return PRODUCT_REPOSITORY;
    }
}
