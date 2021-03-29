package com.github.KaydunovDenis.crud.Service;

import com.github.KaydunovDenis.crud.Database.Model;
import com.github.KaydunovDenis.crud.UIConsole.Console;

import java.math.BigDecimal;

public class CRUD_Demo {
    public static Model model = new Model();
    public static CRUD crud = new CRUD(model);
    public static Console console = new Console();

    public static void main(String[] args) {
        model.initialModelDemo();
        console.print(crud.read(2L));
    }

    private void addTestProduct() {
        Product newProduct1 = new Product("Acer 1", 2000.00, Category.NOTEBOOK);
        newProduct1.setDiscount(new BigDecimal("0.2"));
        newProduct1.setDescription("Better choice");
        crud.create(newProduct1);

        Product newProduct2 = new Product("Acer 2", 2000.00, Category.NOTEBOOK);
        newProduct2.setDiscount(new BigDecimal("0.3"));
        newProduct2.setDescription("Better choice 2");
        newProduct2.setCurrency(Currency.BYN);
        crud.create(newProduct2);
    }
}
