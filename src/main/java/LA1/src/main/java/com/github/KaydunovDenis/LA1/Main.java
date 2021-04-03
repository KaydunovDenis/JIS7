package com.github.KaydunovDenis.LA1;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] massive = initializeMassive();           //1
        printMassive(massive);
        int[] sortMassive = sortMassive(massive);      //2
        printMassive(sortMassive);
        int[] reverseMassive = createReverseSortMassive(massive);//3
        printMassive(reverseMassive);
        uniteAndPrintMassive(sortMassive, reverseMassive);//4
    }

    public static int[] initializeMassive() {
        int[] massive = new int[5];
        for (int i = 0; i < 5; i++) {
            massive[i] = random.nextInt(100);
        }
        return massive;
    }

    public static void printMassive(int[] massive) {
        for (int element : massive) {
            System.out.print(element + " ");
        }
        System.out.println("\n");
    }

    public static int[] sortMassive(int[] massive) {
        Arrays.sort(massive);
        return massive;
    }

    public static int[] createReverseSortMassive(int[] massive) {
        int[] reverseMassive = new int[massive.length];
        int[] tempMassive = sortMassive(massive);
        for (int i = 0; i < massive.length; i++) {
            reverseMassive[i] = tempMassive[massive.length - i - 1];
        }
        return reverseMassive;
    }

    public static void uniteAndPrintMassive(int[] first, int[] second) {
        int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        printMassive(result);
    }
}
