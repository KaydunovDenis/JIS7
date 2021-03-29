package com.github.KaydunovDenis.crud.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Product extends SuperProduct {
    public String name;
    public BigDecimal regularPrice;
    public Category category;

    public BigDecimal discount = new BigDecimal(0);// (example: 0.05) (т.е 5%)
    public String description;// - тип данных String (example: Tasty apples from Latvia)
    private final MathContext context = new MathContext(2, RoundingMode.HALF_UP);

    //TODO
    /*
    Перенести  вcе конструкторы   в конструктор с array

    обработать ошибку null при создании продукта
     */

    public Product(String name, BigDecimal regularPrice, Category category) {
        this.name = name;
        this.regularPrice = regularPrice;
        this.category = category;
    }

    public Product(String name, BigDecimal regularPrice, Category category, BigDecimal discount) {
        this.name = name;
        this.regularPrice = regularPrice;
        this.category = category;
        this.discount = discount;
    }

    public Product(String name, BigDecimal regularPrice, Category category, BigDecimal discount, String description) {
        this.name = name;
        this.regularPrice = regularPrice;
        this.category = category;
        this.discount = discount;
        this.description = description;
    }

    public Product(String name, int regularPrice, Category category, BigDecimal discount, String description) {
        this.name = name;
        this.regularPrice = new BigDecimal(regularPrice, context);
        this.category = category;
        this.discount = discount;
        this.description = description;
    }

    public Product(String name, int regularPrice, Category category) {
        this.name = name;
        this.regularPrice = new BigDecimal(regularPrice, context);
        this.category = category;
    }

    public Product(String name, double regularPrice, Category category) {
        this.name = name;
        this.regularPrice = new BigDecimal(regularPrice, context);
        this.category = category;
    }

    public Product(String[] array) {
        int length = array.length;
        if (length >= 4) {
            name = array[1];
            regularPrice = new BigDecimal(array[2], context);
            category = Category.valueOf(array[3]);
        }
        if (length >= 5) {
            discount = new BigDecimal(array[4], context);
        }
        if (length >=6) {
            description = Arrays.stream(array, 4, length).collect(Collectors.joining());
        }
    }

    public String getDescription() {
        if (description != null && !description.equals(""))
            return "Description: " + description + '\n';
        else return "";
    }

    /**
     * Product information:
     * Id: 123
     * Name: Apple
     * Regular price: 0.40
     * Discount: 25%
     * Actual price: 0.30
     */
    @Override
    public String toString() {
        String textRegularPrice = String.valueOf(regularPrice.doubleValue());
        String textActualPrice = getActualPrice();
        return "Product information:\n" +
                "ID: " + id + '\n' +
                "Name: " + category.toString() + " " + name + '\n' +
                "Regular price: " + textRegularPrice + " " + currency + "\n" +
                "Discount: " + discount + "%\n" +
                "Actual price: " + textActualPrice + " " + currency +"\n" +
                "Description: " + getDescription();
    }

    private String getActualPrice() {
        BigDecimal percentCost = (new BigDecimal("1")).subtract(discount);
        BigDecimal actualPrice = regularPrice.multiply(percentCost);
        //TODO сделать красивый вывод актуальной цены без степеней
        return String.valueOf(actualPrice.doubleValue());
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
