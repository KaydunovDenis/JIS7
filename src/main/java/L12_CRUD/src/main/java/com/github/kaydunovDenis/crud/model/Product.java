package com.github.kaydunovDenis.crud.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Product extends SuperProduct {
    //ID
    //Name
    public BigDecimal regularPrice;
    public ProductCategory productCategory;
    public BigDecimal discount = new BigDecimal(0);
    public String description = "";
    final private static MathContext FILTER_SETTING = new MathContext(10, RoundingMode.HALF_UP);

    /**
     * @param args <br> 1 Name: Apple
     *             <br> 2 Regular price: 0.40
     *             <br> 3 Product category: PHONE
     *             <br> 4 Discount: 25%
     *             <br> 5 Description: information
     * @author Kaydunov Denis
     */
    public Product(String[] args) {
        int length = args.length;
        if (length >= 3) {
            name = args[0];
            regularPrice = new BigDecimal(args[1]);
            productCategory = ProductCategory.valueOf(args[2]);
        }
        if (length >= 4) {
            discount = new BigDecimal(args[3], FILTER_SETTING);
        }
        if (length >= 5) {
            description = args[4];
            //Arrays.stream(args, 4, length).collect(Collectors.joining());
        }
    }

    /**
     * @return Product information:
     * <br>ID: 123
     * <br>Name: Apple
     * <br>Regular price: 0.40
     * <br>Discount: 25%
     * <br>Actual price: 0.30
     * <br>Description: description
     */
    @Override
    public String toString() {
        //String textRegularPrice = String.valueOf(regularPrice.setScale(2, RoundingMode.HALF_UP).doubleValue());
        return "Product information:\n" +
                "ID: " + ID + '\n' +
                "Name: " + productCategory.toString() + " " + name + '\n' +
                "Regular price: " + regularPrice.toString() + " евро" + "\n" +
                "Discount: " + discount + "%\n" +
                "Actual price: " + getActualPrice() + " евро" + "\n" +
                "Description: " + description;
    }

    private String getActualPrice() {
        //todo исправить формулу расчета чтобы не было отрицательных символов
        //todo либо сделать валидацию входящих данных при создании продукта
        BigDecimal percentCost = (new BigDecimal("1")).subtract(discount);
        BigDecimal actualPrice = regularPrice.multiply(percentCost);
        //TODO сделать красивый вывод актуальной цены без степеней
        return String.valueOf(actualPrice.doubleValue());
    }
}
