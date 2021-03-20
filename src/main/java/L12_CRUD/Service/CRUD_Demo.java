package L12_CRUD.Service;

import L12_CRUD.Database.Model;

import java.math.BigDecimal;

public class CRUD_Demo {
    public static void main(String[] args) {
        Model model = new Model();
        model.initialModelDemo();
        CRUD crud = new CRUD(model);

        Product newProduct1 = new Product("Acer 1", 2000.00, Category.NOTEBOOK);
        newProduct1.setDiscount(new BigDecimal("0.2"));
        newProduct1.setDescription("Better choice");
        crud.create(newProduct1);

        Product newProduct2 = new Product("Acer 2", 2000.00, Category.NOTEBOOK);
        newProduct2.setDiscount(new BigDecimal("0.3"));
        newProduct2.setDescription("Better choice 2");
        newProduct2.setCurrency(Currency.BYN);
        crud.create(newProduct2);

        crud.readALL();
    }
}
