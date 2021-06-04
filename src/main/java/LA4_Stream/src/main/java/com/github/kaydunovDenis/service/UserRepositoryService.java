package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.Status;
import com.github.kaydunovDenis.model.User;
import com.github.kaydunovDenis.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryService {
    public static List<User> updateStatusForMinorUser(UserRepository userRepository) {
        System.out.println("Написать метод, который сортирует юзеров по нику и отфильтровывает, чтобы в этой" +
                " коллекции были юзеры старше 18 лет, если младше? то тем юзерам флаг меняется на " +
                "isActive false и статус переходит в guest.");
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

    public static long getNumberUsersWithStatusUser(UserRepository userRepository) {
        System.out.println("Написать метод, который выводит количество юзеров со статусом USER и флагом true");
        return userRepository.getUserList().stream()
                .filter(it -> it.getStatus().equals(Status.USER) && it.isActive())
                .count();
    }

    public static List<User> increaseUsersStatus(UserRepository userRepository) {
        System.out.println("\n Если юзеры имеют статус guest, то" +
                "установить им статус USER и перевести флаг isActive в true,\n" +
                "а если уже был USER и isActive то перевести в VIP USER.");
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
}
