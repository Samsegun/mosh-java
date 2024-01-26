package com.codewithmosh;

import java.util.Scanner;

public class Console {
    final private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt) {
        System.out.println(prompt);
        return scanner.nextDouble();
    }
    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if ((value < min) || (value > max)) {
                System.out.println("Enter a value between " + (int) min + " and " + (int) max);
                continue;
            }
            break;
        }
        return value;
    }
}
