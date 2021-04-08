package com.github.KaydunovDenis.crud.Service;

import com.github.KaydunovDenis.crud.Model.Model;
import com.github.KaydunovDenis.crud.Model.Product;

/**
 * +добавление/
 * +удаление/
 * +получение продукта (CRUD operations).
 */
public class CrudService {
    private Model model;

    public CrudService(Model model) {
        this.model = model;
    }

    public void create(Product product) {
        model.getListProduct().put(product.id, product);
    }

    public String read(Long id) {
        try {
            return model.getListProduct().get(id).toString();
        } catch (NullPointerException e) {
            return "Продукт с указанным ID отсутствует";
        }
    }

    public void readALL() {
        System.out.println(model.toString());
    }

    public void update() {

    }

    public String delete(Long id) {
        try {
            model.getListProduct().remove(id);
            return "Удаление id = " + id + " успешно";
        } catch (IndexOutOfBoundsException e) {
            return "Продукт с указанным ID отсутствует";
        }
    }

    public Model getModel() {
        return model;
    }
}
