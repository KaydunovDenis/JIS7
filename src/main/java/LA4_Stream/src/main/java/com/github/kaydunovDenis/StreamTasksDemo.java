package com.github.kaydunovDenis;

import com.github.kaydunovDenis.repository.ProductRepository;
import com.github.kaydunovDenis.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static com.github.kaydunovDenis.service.ProductRepositoryService.*;
import static com.github.kaydunovDenis.service.UserRepositoryService.*;

public class StreamTasksDemo {
    public static void main(String[] args) {
        //1
        System.out.println("1. Создать Stream на коллекции рандомных целочисленных значений" +
                "и отфильтровать только четные.");
        var listInteger = new ArrayList<>(generateCollectionIntegerNumber(10));
        System.out.println("List before the filtration:");
        listInteger.forEach(System.out::println);
        System.out.println("List after the filtration:");
        listInteger.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        //2
        var listStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten");
        listStrings.stream().filter(x -> findArgInStartOrEndString(x, "e")).forEach(System.out::println);
        //3
        System.out.println("\nСоздать модель продукт. У него есть название цена и скидка. " +
                "Создать массив этих продуктов.");
        var productRepository = new ProductRepository();
        productRepository.generateTestProduct(10, 1, 20);
        productRepository.getListProducts().forEach(System.out::println);
        //tasks 3a, 3b, 3c
        System.out.println(findProductsWithDiscountAndPrice(productRepository));
        System.out.println(findMostExpensiveProductWithoutDiscount(productRepository));
        System.out.println(findCheapestProductWithMaxDiscount(productRepository));
        //4.1
        System.out.println(sortListProductByAscendingPriceFirstByWithoutDiscount(productRepository));
        //4.2
        UserRepository userRepository = new UserRepository();
        System.out.println(increaseUsersStatus(userRepository));
        //4.3
        System.out.println(getUserListOver18SortedByNicknameAndUpdateStatusUserUnder18YearsOld(userRepository));
        //4.4
        System.out.println(getNumberUsersWithStatusUser(userRepository));
    }

    private static boolean findArgInStartOrEndString(String text, String arg) {
        System.out.println("\nСоздать коллекцию строк, написать метод который принимает аргумент (часть строки)\n" +
                "отфильтровать строки которые заканчиваются или начинаются на ту строку которая пришла в параметре\n" +
                "вывести в консоль используя Stream API:");
        return text.startsWith(arg) || text.endsWith(arg);
    }

    private static ArrayList<Integer> generateCollectionIntegerNumber(int count) {
        var list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt());
        }
        return list;
    }
}

