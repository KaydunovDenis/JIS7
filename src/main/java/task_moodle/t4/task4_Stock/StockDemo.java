package task_moodle.t4.task4_Stock;

public class StockDemo {
    public static void main(String[] args) {
        Stock google = new Stock("GOOGLE", 10);
        google.printInformation();
        google.updatePrice(15);
        google.updatePrice(7);
        google.updatePrice(14);
        google.printInformation();
    }
}
