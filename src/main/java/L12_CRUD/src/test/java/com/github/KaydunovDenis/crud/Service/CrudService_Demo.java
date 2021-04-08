package com.github.KaydunovDenis.crud.Service;

import com.github.KaydunovDenis.crud.Model.Category;
import com.github.KaydunovDenis.crud.Model.Currency;
import com.github.KaydunovDenis.crud.Model.Model;
import com.github.KaydunovDenis.crud.Model.Product;
import com.github.KaydunovDenis.crud.UIConsole.Console;

import java.math.BigDecimal;

public class CrudService_Demo {
    public static Model model = new Model();
    public static CrudService crudService = new CrudService(model);
    public static Console console = new Console();

    public static void main(String[] args) {
        model.initialModelDemo();
        console.print(crudService.read(2L));
    }

    private void addTestProduct() {
        Product newProduct1 = new Product("Acer 1", 2000.00, Category.NOTEBOOK);
        newProduct1.setDiscount(new BigDecimal("0.2"));
        newProduct1.setDescription("Better choice");
        crudService.create(newProduct1);

        Product newProduct2 = new Product("Acer 2", 2000.00, Category.NOTEBOOK);
        newProduct2.setDiscount(new BigDecimal("0.3"));
        newProduct2.setDescription("Better choice 2");
        newProduct2.setCurrency(Currency.BYN);
        crudService.create(newProduct2);
    }
}
