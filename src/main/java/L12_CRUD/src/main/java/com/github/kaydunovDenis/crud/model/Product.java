package com.github.kaydunovDenis.crud.model;

import com.github.kaydunovDenis.crud.service.ErrorCommandException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Product {
    public Long ID;
    public String name;
    public BigDecimal regularPrice;
    public ProductCategory productCategory;
    public BigDecimal discount = new BigDecimal(0);
    public String description = " - ";

    private static Long counterID = 1L;
    final private static MathContext SETTING_FILTER_BIG_DECIMAL =
            new MathContext(10, RoundingMode.HALF_UP);

    final private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("########0.00");

    final private static String MESSAGE_ERROR_CATEGORY =
            " Error write category.Use next name of category:\n" +
                    String.join(" ", Arrays.toString(ProductCategory.values()));

    final private static String MESSAGE_ERROR_NUMBER =
            " Error format input it number. Object don't create.\n" +
                    "You need to enter the command with right number.\n" +
                    "The number must be represented by a fractional number between 0 and 1. \n" +
                    "Use a period as a separator.";

    final private static String MESSAGE_ERROR_CREATE =
            "Your command is error. You need will write name product, regular price product," +
                    " and category product";


    /**
     * @param args <br> 1 Name: Apple
     *             <br> 2 Regular price: 0.40
     *             <br> 3 Product category: PHONE
     *             <br> 4 Discount: 25%
     *             <br> 5 Description: information
     * @author Kaydunov Denis
     */
    public Product(String[] args) throws ErrorCommandException {
        int length = args.length;
        if (length < 3) {
            throw new ErrorCommandException(MESSAGE_ERROR_CREATE);
        } else {
            name = args[0];
            validatePrice(args[1]);
            validateCategory(args[2]);
        }
        if (length >= 4) {
            validateAndCreateDiscount(args[3]);
        }
        if (length >= 5) {
            createDescription(args);
        }
        ID = counterID++;
    }

    private void validateCategory(String category) throws ErrorCommandException {
        if (ProductCategory.contains(category)) {
            productCategory = ProductCategory.valueOf(category);
        } else throw new ErrorCommandException(name + MESSAGE_ERROR_CATEGORY);
    }

    private void validatePrice(String textPrice) throws ErrorCommandException {
        textPrice = replaceSeparator(textPrice);
        try {
            regularPrice = new BigDecimal(textPrice, SETTING_FILTER_BIG_DECIMAL);
        } catch (NumberFormatException exception) {
            throw new ErrorCommandException(name + MESSAGE_ERROR_NUMBER);
        }
    }

    public static String replaceSeparator(String number) {
        if (number.contains(",")) number = number.replaceAll(",", ".");
        return number;
    }


    private String getDiscountForToString() {
        return DECIMAL_FORMAT.format(discount.multiply(BigDecimal.valueOf(100)));
    }

    private String getActualPrice() {
        BigDecimal percentCost = (new BigDecimal("1")).subtract(discount);
        BigDecimal actualPrice = regularPrice.multiply(percentCost);
        return DECIMAL_FORMAT.format(actualPrice);
    }

    public void validateAndCreateDiscount(String textDiscount) throws ErrorCommandException {
        textDiscount = replaceSeparator(textDiscount);
        if (textDiscount.equals("")) textDiscount = "0";
        try {
            discount = new BigDecimal(textDiscount, SETTING_FILTER_BIG_DECIMAL);

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

    public void createDescription(String[] args) {
        //TODO проверить правильность заполнения
        description = Arrays.stream(args, 4, args.length)
                .collect(Collectors.joining(" "));

    }

    /**
     * @return Product information:
     * <br>ID: 12
     * <br>Name: Apple
     * <br>Regular price: 100
     * <br>Discount: 25%  (input: 0.25)
     * <br>Actual price: 75.00
     * <br>Description: description
     */
    @Override
    public String toString() {
        return "ID: " + ID + '\n' +
                "Name: " + productCategory.toString() + " " + name + '\n' +
                "Regular price: " + DECIMAL_FORMAT.format(regularPrice)/*regularPrice.toString()*/ + " евро" + "\n" +
                "Discount: " + getDiscountForToString() + "%\n" +
                "Actual price: " + getActualPrice() + " евро" + "\n" +
                "Description: " + description + "\n\n";
    }
}
