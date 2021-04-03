package com.github.KaydunovDenis.LA2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static int[] massive = new int[5];
    public static void main(String[] args) {
        generateMassive(scanner.nextInt());
        Arrays.stream(massive).forEach(System.out::println);
    }

    public static void generateMassive(int number) {
        if (number >= massive.length) {
            int newLength = (int) (number * 1.5);
            massive = new int[newLength];
        }
        for (int i = 0; i < number; i++) {
            massive[i] = random.nextInt(100);
        }
    }
}
