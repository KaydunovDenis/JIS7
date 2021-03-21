package L12_CRUD.Service;

import java.math.BigDecimal;

public class Product extends SuperProduct {
    public String name;
    public BigDecimal regularPrice;
    public Category category;

    public BigDecimal discount = new BigDecimal(0);// (example: 0.05) (т.е 5%)
    public String description;// - тип данных String (example: Tasty apples from Latvia)

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
        this.regularPrice = new BigDecimal(regularPrice);
        this.category = category;
        this.discount = discount;
        this.description = description;
    }

    public Product(String name, int regularPrice, Category category) {
        this.name = name;
        this.regularPrice = new BigDecimal(regularPrice);
        this.category = category;

    }

    public Product(String name, double regularPrice, Category category) {
        this.name = name;
        this.regularPrice = new BigDecimal(regularPrice);
        this.category = category;
    }

    public String getDescription() {
        if (description != null && !description.equals("")) return "Description: " + description + '\n';
        return "";
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
        return "Product information:\n" +
                "ID: " + id + '\n' +
                "Name: " + category.toString() + " " + name + '\n' +
                "Regular price: " + regularPrice + " " + currency + "\n" +
                "Discount: " + discount + "%\n" +
                "Actual price: " + getActualPrice() + " " + currency +"\n" +
                getDescription() + '\n';
    }

    private String getActualPrice() {
        BigDecimal percentCost = (new BigDecimal("1")).subtract(discount);
        return regularPrice.multiply(percentCost).toString();
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

    public void setName(String name) {
        this.name = name;
    }

    public void setRegularPrice(BigDecimal regularPrice) {
        this.regularPrice = regularPrice;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
