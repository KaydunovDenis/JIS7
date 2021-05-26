package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Product;
import com.github.kaydunovDenis.model.Status;
import com.github.kaydunovDenis.model.User;
import com.github.kaydunovDenis.repository.ProductRepository;
import com.github.kaydunovDenis.repository.UserRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
        //tasks 3a, 3b, 3c
        oldMethod(productRepository);

        System.out.println("/n Отсортируйте продукты по цене по возрастанию" +
                "сначала те у которых скидки нет, затем идут отсортированные по цене со скидкой:");
        productRepository.getListProducts().stream()
                .sorted(Comparator
                        .comparing(Product::getDiscount)
                        .thenComparing(Product::getPrice))
                .forEach(System.out::println);


        //4.2
        UserRepository userRepository = new UserRepository();
        System.out.println("\n Если юзеры имеют статус guest, то" +
                "установить им статус USER и перевести флаг isActive в true,\n" +
                "а если уже был USER и isActive то перевести в VIP USER.");
        List<User> list = increaseUsersStatus(userRepository);
        list.forEach(System.out::println);

        //4.3
        System.out.println("Написать метод, который сортирует юзеров по нику и отфильтровывает, чтобы в этой" +
                " коллекции были юзеры старше 18 лет, если младше? то тем юзерам флаг меняется на " +
                "isActive false и статус переходит в guest.");
        List<User> newUserRepository = getUserListOver18SortedByNicknameAndUpdateStatusUserUnder18YearsOld(userRepository);
        newUserRepository.forEach(System.out::println);

        //4.4
        System.out.println("Написать метод, который выводит количество юзеров со статусом USER и флагом true");
        long numberUsersWithStatusUser = getNumberUsersWithStatusUser(userRepository);
        System.out.println(numberUsersWithStatusUser);
    }

    private static List<User> getUserListOver18SortedByNicknameAndUpdateStatusUserUnder18YearsOld(UserRepository userRepository) {
        return userRepository.getUserList().stream()
                .sorted(Comparator.comparing(User::getNickname))
                .peek(it -> {
                    if (it.getAge() < 18) {
                        it.setActive(false);
                        it.setStatus(Status.GUEST);
                    }
                })
                .filter(it -> it.getAge() > 18)
                .collect(Collectors.toList());
    }

    private static long getNumberUsersWithStatusUser(UserRepository userRepository) {
        return userRepository.getUserList().stream()
                .filter(it -> it.getStatus().equals(Status.USER) && it.isActive())
                .count();
    }

    private static List<User> increaseUsersStatus(UserRepository userRepository) {
        return userRepository.getUserList().stream()
                .peek(it -> {
                    if (it.getStatus().equals(Status.USER) && it.isActive()) {
                        it.setStatus(Status.VIP_USER);
                    }
                    if (it.getStatus().equals(Status.GUEST)) {
                        it.setStatus(Status.USER);
                        it.setActive(true);
                    }
                })
                .collect(Collectors.toList());
    }

    private static void oldMethod(ProductRepository productRepository) {
        System.out.println("\nНайти продукты со скидкой более 30% у которых цена не более 10.5 рублей:");
        productRepository.getListProducts().stream()
                .filter(x -> x.getDiscount() > 30 && x.getPrice() < 10.5)
                .forEach(System.out::println);

        System.out.println("\nНайти самый дорогой продукт у которого нет скидки:");
        productRepository.getListProducts().stream()
                .filter(x -> x.getDiscount() == 0)
                .max(Comparator.comparingDouble(Product::getPrice))
                .ifPresent(System.out::println);

        System.out.println("\nНайти самый дешевый продукт с самой большой скидкой:");
        productRepository.getListProducts().stream()
                .min(Comparator.comparing(Product::getPrice)
                        .thenComparing((o1, o2) -> Double.compare(o2.getDiscount(), o1.getDiscount())))
                .ifPresent(System.out::println);
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

