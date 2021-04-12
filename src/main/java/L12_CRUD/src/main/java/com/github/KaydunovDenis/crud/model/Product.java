package com.github.KaydunovDenis.crud.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Product extends SuperProduct {
    public BigDecimal regularPrice;
    public ProductCategory productCategory;
    public BigDecimal discount = new BigDecimal(0);
    public String description;
    private final MathContext FILTER_SETTING = new MathContext(10, RoundingMode.HALF_UP);

    //TODO
    /*
    Перенести  вcе конструкторы   в конструктор с array

    Сделать правильный вывод цен, чтобы не было неправильного округления BigDecimal

    обработать ошибку null при создании продукта
     */

    public Product(String name, BigDecimal regularPrice, ProductCategory productCategory) {
        this.name = name;
        this.regularPrice = regularPrice;
        this.productCategory = productCategory;
    }

    public Product(String name, BigDecimal regularPrice, ProductCategory productCategory, BigDecimal discount) {
        this.name = name;
        this.regularPrice = regularPrice;
        this.productCategory = productCategory;
        this.discount = discount;
    }

    public Product(String name, BigDecimal regularPrice, ProductCategory productCategory, BigDecimal discount, String description) {
        this.name = name;
        this.regularPrice = regularPrice;
        this.productCategory = productCategory;
        this.discount = discount;
        this.description = description;
    }

    public Product(String name, int regularPrice, ProductCategory productCategory, BigDecimal discount, String description) {
        this.name = name;
        this.regularPrice = new BigDecimal(regularPrice, FILTER_SETTING);
        this.productCategory = productCategory;
        this.discount = discount;
        this.description = description;
    }

    public Product(String name, int regularPrice, ProductCategory productCategory) {
        this.name = name;
        this.regularPrice = new BigDecimal(regularPrice, FILTER_SETTING);
        this.productCategory = productCategory;
    }

    public Product(String name, double regularPrice, ProductCategory productCategory) {
        this.name = name;
        this.regularPrice = new BigDecimal(regularPrice, FILTER_SETTING);
        this.productCategory = productCategory;
    }

    public Product(String[] array) {
        int length = array.length;
        if (length >= 4) {
            name = array[1];
            regularPrice = new BigDecimal(array[2], FILTER_SETTING);
            productCategory = ProductCategory.valueOf(array[3]);
        }
        if (length >= 5) {
            discount = new BigDecimal(array[4], FILTER_SETTING);
        }
        if (length >= 6) {
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
        String textRegularPrice = String.valueOf(regularPrice.setScale(2, RoundingMode.HALF_UP).doubleValue());
        String textActualPrice = getActualPrice();
        return "Product information:\n" +
                "ID: " + ID + '\n' +
                "Name: " + productCategory.toString() + " " + name + '\n' +
                "Regular price: " + textRegularPrice + " " + currency + "\n" +
                "Discount: " + discount + "%\n" +
                "Actual price: " + textActualPrice + " " + currency + "\n" +
                "Description: " + getDescription();
    }

    private String getActualPrice() {
        BigDecimal percentCost = (new BigDecimal("1")).subtract(discount);
        BigDecimal actualPrice = regularPrice.multiply(percentCost);
        Scanner scanner = new Scanner(System.in);
        scanner.next();
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
