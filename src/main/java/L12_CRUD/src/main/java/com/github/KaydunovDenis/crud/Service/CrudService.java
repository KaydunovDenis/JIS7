package com.github.KaydunovDenis.crud.Service;

import com.github.KaydunovDenis.crud.Repository.ProductRepository;
import com.github.KaydunovDenis.crud.Repository.Product;

/**
 * +добавление/
 * +удаление/
 * +получение продукта (CRUD operations).
 */
public class CrudService {
    public static ProductRepository productRepository = new ProductRepository();

    public static void main(String[] args) {
        productRepository.initialProductRepository();
    }

    public void create(Product product) {
        productRepository.getListProduct().put(product.id, product);
    }

    public String read(Long id) {
        try {
            return productRepository.getListProduct().get(id).toString();
        } catch (NullPointerException e) {
            return "Продукт с указанным ID отсутствует";
        }
    }

    public void readALL() {
        System.out.println(productRepository.toString());
    }

    public void update() {

    }

    public String delete(Long id) {
        try {
            productRepository.getListProduct().remove(id);
            return "Удаление id = " + id + " успешно";
        } catch (IndexOutOfBoundsException e) {
            return "Продукт с указанным ID отсутствует";
        }
    }

    public ProductRepository getModel() {
        return productRepository;
    }
}
