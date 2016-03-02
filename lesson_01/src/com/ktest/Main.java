package com.ktest;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static void firstTask() {
        int[] arr = {10, 20, 30, 40};

        for (int i = 0; i < arr.length; i++)
            System.out.printf("arr[%d] = %d;%n", i, arr[i]);
    }

    private static void secondTask() {
        int counter;
        int sum = 0;
        int chislo;
        System.out.print("Введите количество чисел: ");
        if (sc.hasNextInt()) {
            counter = sc.nextInt();
            for (int i = 1; i <= counter; i++) {
                System.out.printf("Введите %dе чисело: ", i);
                if (sc.hasNextInt()) {
                    chislo = sc.nextInt();
                    if (chislo > 2) sum += chislo;
                }
            }

        } else {
            System.out.println("Вы ввели не целое число");
            return;
        }
        System.out.printf("Сумма введенных %d чисел больше 2: %d;%n", counter, sum);

    }

    public static void main(String[] args) {

        while (true) {
            System.out.print("Введите номер задания (1, 2 или 0, для выхода): ");
            if (sc.hasNextInt()) {
                switch (sc.nextInt()) {
                    case 1:
                        firstTask();
                        break;
                    case 2:
                        secondTask();
                        break;
                    case 0:
                        return;
                }
            } else {
                return;
            }

        }

    }
}
