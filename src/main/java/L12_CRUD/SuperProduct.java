package L12_CRUD;

import java.math.BigDecimal;

public abstract class SuperProduct {
    public Long id = 0L;
    public String name;
    public BigDecimal regularPrice;
    public Category category;

    public BigDecimal discount = new BigDecimal(0);// (example: 0.05) (т.е 5%)
    public String description;// - тип данных String (example: Tasty apples from Latvia)

    public SuperProduct() {
        id = ++id;
    }
}
