package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Product;
import com.github.kaydunovDenis.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class StreamTasks {
    public static void main(String[] args) {
        //1
        System.out.println("1. Создать Stream на коллекции рандомных целочисленных значений" +
                "и отфильтровать только четные.");
        List<Integer> listInteger = new ArrayList<>(generateCollectionIntegerNumber(10));
        System.out.println("List before the filtration:");
        listInteger.forEach(System.out::println);
        System.out.println("List after the filtration:");
        listInteger.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        //2
        System.out.println("\nСоздать коллекцию строк, написать метод который принимает аргумент (часть строки)\n" +
                "отфильтровать строки которые заканчиваются или начинаются на ту строку которая пришла в параметре\n" +
                "вывести в консоль используя Stream API:");
        List<String> listStrings = new ArrayList<>();
        listStrings.add("One");
        listStrings.add("Two");
        listStrings.add("Three");
        listStrings.add("Four");
        listStrings.add("Five");
        listStrings.add("Six");
        listStrings.add("Seven");
        listStrings.add("Eight");
        listStrings.add("Nine");
        listStrings.add("Ten");
        listStrings.stream().filter(x -> findArgInStartOrEndString(x, "e")).forEach(System.out::println);

        //3
        System.out.println("\nСоздать модель продукт. У него есть название цена и скидка. " +
                "Создать массив этих продуктов.");
        ProductRepository productRepository = new ProductRepository();
        productRepository.generateTestProduct(10, 1, 20);
        productRepository.getListProducts().forEach(System.out::println);

        System.out.println("\nНайти продукты со скидкой более 30% у которых цена не более 10.5 рублей:");
        productRepository.getListProducts().stream()
                .filter(x -> x.getDiscount() > 30 && x.getPrice() < 10.5)
                .forEach(System.out::println);

        System.out.println("\nНайти самый дорогой продукт у которого нет скидки:");
        Product tempProduct = productRepository.getListProducts().stream()
                .filter(x -> x.getDiscount() == 0)
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
        System.out.println(tempProduct);

        System.out.println("\nНайти самый дешевый продукт с самой большой скидкой:");
        tempProduct = productRepository.getListProducts().stream()
                .min(Comparator.comparing(Product::getPrice)
                .thenComparing((o1, o2) -> Double.compare(o2.getDiscount(), o1.getDiscount())))
                .orElse(null);
        System.out.println(tempProduct);
    }

    private static boolean findArgInStartOrEndString(String text, String arg) {
        return text.startsWith(arg) || text.endsWith(arg);
    }

    private static List<Integer> generateCollectionIntegerNumber(int count) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt());
        }
        return list;
    }
}

