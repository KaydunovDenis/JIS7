package L12_CRUD;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Product> list = new ArrayList<>();

    public void initialModelDemo() {
        list.add(new Product("Apple 10.0", 1000, Category.PHONE));
        list.add(new Product("Samsung 6 PRO", 850, Category.PHONE));
        list.add(new Product("Huawei TIT ALL-00", 314.56, Category.PHONE));
        list.add(new Product("Huawei tablet 5.1", 420, Category.TABLET));
        list.add(new Product("Huawei tablet 6 PRO", 620, Category.TABLET));
        list.add(new Product("Huawei tablet 5.7", 470, Category.TABLET));
        list.add(new Product("Lenovo Plus 2020", 1200, Category.NOTEBOOK));
        list.add(new Product("Lenovo Plus 2021", 1300, Category.NOTEBOOK));
        list.add(new Product("Notebook Apple Pro 2021", 5300, Category.NOTEBOOK));
        list.add(new Product("Bug Computer 2016", 458.9, Category.COMPUTER));
        list.add(new Product("Bug Computer 2017", 468.3, Category.COMPUTER));
        list.add(new Product("Bug Computer 2018", 482.5, Category.COMPUTER));
        list.add(new Product("Agitator 2020 GameMaster 2.0", 91829.56, Category.COMPUTER));
        list.add(new Product("ACER E5", 829.56, Category.NOTEBOOK, "JForce 890М"));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product product: list) {
            result.append(product.toString())
                    .append("\n");
        }
        return result.toString();
    }

    public List<Product> getModel() {
        return list;
    }
}
