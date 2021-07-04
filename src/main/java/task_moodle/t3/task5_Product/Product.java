package task_moodle.t3.task5_Product;

class Product {
    private String name;
    private double regularPrice;
    private double discount;

    public Product(String name) {
        this.name = name;
    }

    double actualPrice() throws Exception {
        if (regularPrice < 0 || discount < 0 || discount > 1) {
            System.out.println("Product - " + name + " were input error value. Enter correct value.");
            //System.exit(0);
            // **********Так лучше не делать. Ты останавливаешь работу программы.
            // Подумай как сделать лучше. Приложения Java должны быть отказоустойчивы***************//
            throw new Exception("Product - " + name + " were input error value. Enter correct value.");
        }
        return regularPrice * (1- discount);
    }

    public void printInformation()  {
        try {
            System.out.printf(
                    "Product : name = %s, regular price = %.2f EUR, discount = %.2f%% actual price = %.2f EUR\n",
                    name, regularPrice, discount, actualPrice());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
