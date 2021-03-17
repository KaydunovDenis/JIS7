package L12_CRUD;

public class CRUD_Demo {
    public static void main(String[] args) {
        Model model = new Model();
        model.initialModelDemo();
        CRUD crud = new CRUD(model);

        crud.readALL();
    }
}
