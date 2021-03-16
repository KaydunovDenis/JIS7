package L3.task5_Product;

public class Product {
    private String name;
    private double regularPrice;
    private double discount;

    public Product(String name) {
        this.name = name;
    }

    double actualPrice() {
        if (regularPrice < 0 || discount < 0 || discount > 1) {
            System.out.println("Product - " + name + " were input error value. Enter correct value.");
            System.exit(0);
        }
        return regularPrice * (1- discount);
    }

    public void printInformation() {
        System.out.printf("Product : name = %s, regular price = %.2f EUR, discount = %.2f%% actual price = %.2f EUR\n",
                name, regularPrice, discount, actualPrice());
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
