package L12_CRUD.Service;

import L12_CRUD.Database.Model;

/**
 *  +добавление/
 *  +удаление/
 *  +получение продукта (CRUD operations).
 */
public class CRUD {
    private Model model;

    public CRUD(Model model) {
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
