package L12_CRUD.Service;

import L12_CRUD.Database.Model;

/**
 *  +добавление/
 *  +удаление/
 *  +получение продукта (CRUD operations).
 */
public class CRUD {
    private Model model;

    public CRUD() {
    }

    public CRUD(Model model) {
        this.model = model;
    }

    public void create(Product product) {
        model.getModel().add(product);
    }

    public void read(long id) {

    }

    public void readALL() {
        System.out.println(model.toString());
    }

    public void update() {

    }

    public void delete(Long id) {
    }

}
