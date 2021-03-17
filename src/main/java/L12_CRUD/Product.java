package L12_CRUD;

import java.math.BigDecimal;

public class Product extends SuperProduct {


    public Product(String name, BigDecimal price, Category category) {
        this.name = name;
        this.regularPrice = price;
        this.category = category;
    }

    public Product(String name, int price, Category category) {
        this.name = name;
        this.regularPrice = BigDecimal.valueOf(price);
        this.category = category;
    }

    public Product(String name, double price, Category category) {
        this.name = name;
        this.regularPrice = BigDecimal.valueOf(price);
        this.category = category;
    }

    public Product(String name, double price, Category category, String description) {
        this.name = name;
        this.regularPrice = BigDecimal.valueOf(price);
        this.category = category;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        if (description != null && !description.equals("")) return "Description: " + description + '\n';
        return "";
    }

    /**
     * Product information:
     * Id: 123
     * Name: Apple
     * Regular price: 0.14
     * Discount: 50%
     * Actual price: 0.07
     */
    @Override
    public String toString() {
        return "Product information:\n" +
                "ID: " + id + '\n' +
                category.toString() + ": " + name + '\n' +
                "Regular price: " + regularPrice + +'\n' +
                "Discount: " + discount + "%\n" +
                "Actual price: " + getActualPrice() + "\n" +
                getDescription() + '\n';

    }

    private String getActualPrice() {
        return regularPrice.multiply(discount).toString();
    }
}
