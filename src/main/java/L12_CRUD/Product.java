package L12_CRUD;

import java.math.BigDecimal;

public class Product {
    private String name;
    private Long id;
    private BigDecimal price;
    private Category category;

    private BigDecimal discount;// (example: 0.05) (т.е 5%)
    private String description;// - тип данных String (example: Tasty apples from Latvia)

    public Product(String name, BigDecimal price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public String getDescription() {
        return description;
    }
}
