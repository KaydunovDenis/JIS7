package L12_CRUD;

/**
 *  +добавление/
 *  +удаление/
 *  +получение продукта (CRUD operations).
 */
public class CRUD {
    private Model model = new Model();

    public void create(Product product) {
        model.getModel().add(product);
    }

    public void read(long id) {

    }

    public void readALL() {

    }

    public void update() {

    }

    public void delete(long id) {
        model.getModel().remove(id);
    }

}
