package com.github.kaydunovDenis.crud.model;

import com.github.kaydunovDenis.crud.service.ErrorCommandException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Product extends SuperProduct {
    //ID
    //Name
    public BigDecimal regularPrice;
    public ProductCategory productCategory;
    public BigDecimal discount = new BigDecimal(0);
    public String description = " - ";
    final private static MathContext SETTING_FILTER_BIGDECIMAL = new MathContext(10, RoundingMode.HALF_UP);
    final String MESSAGE_ERROR_NUMBER =
            " Error format input it number. Object don't create.\n" +
            "You need to enter the command with right number.\n"+
            "The number must be represented by a fractional number between 0 and 1. \n"+
            "Use a period as a separator.";


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
        try {
            if (length >= 3) {
                name = args[0];
                validatePrice(args[1]);
                validateCategory(args[2]);
            }
            if (length >= 4) {
                validateAndCreateDiscount(args[3]);
            }
            if (length >= 5) {
                //TODO args5 args6 args7 ......etc
                description = args[4];
                //Arrays.stream(args, 4, length).collect(Collectors.joining());
            }
        } catch (ErrorCommandException e) {
            //todo
        }
    }

    private void validateCategory(String category) throws ErrorCommandException {
        if (ProductCategory.contains(category)) {
            productCategory = ProductCategory.valueOf(category);
        } else throw new ErrorCommandException(name + MESSAGE_ERROR_NUMBER);
    }

    private void validatePrice(String textPrice) throws ErrorCommandException {
        try {
            regularPrice = new BigDecimal(textPrice, SETTING_FILTER_BIGDECIMAL);
        } catch (NumberFormatException exception) {
            throw new ErrorCommandException(name + MESSAGE_ERROR_NUMBER);
        }
    }

    /**
     * @return Product information:
     * <br>ID: 12
     * <br>Name: Apple
     * <br>Regular price: 100
     * <br>Discount: 0,25 = 25%
     * <br>Actual price: 75.00
     * <br>Description: description
     */
    @Override
    public String toString() {
        return "Product information:\n" +
                "ID: " + ID + '\n' +
                "Name: " + productCategory.toString() + " " + name + '\n' +
                "Regular price: " + regularPrice.toString() + " евро" + "\n" +
                "Discount: " + discount + "%\n" +
                "Actual price: " + getActualPrice() + " евро" + "\n" +
                "Description: " + description + "\n\n";
    }

    private String getActualPrice() {
        BigDecimal percentCost = (new BigDecimal("1")).subtract(discount);
        BigDecimal actualPrice = regularPrice.multiply(percentCost);
        return String.valueOf(actualPrice.doubleValue());
    }

    public void validateAndCreateDiscount(String textDiscount) throws ErrorCommandException {
        try {
            discount = new BigDecimal(textDiscount, SETTING_FILTER_BIGDECIMAL);
        } catch (NumberFormatException e) {
            throw new ErrorCommandException(name + MESSAGE_ERROR_NUMBER);
        }
        if (discount.doubleValue() > 1) {
            discount = new BigDecimal("1");
        }
        if (discount.doubleValue() < 0) {
            discount = new BigDecimal("0");
        }
    }
}
