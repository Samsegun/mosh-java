package com.codewithmosh;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        long viewsCount = 3_123_456_789L;
//        float price = 10.99F;
//        Date now = new Date();
//
//        System.out.println(age);
//        System.out.println(viewsCount);
//        System.out.println(price);
//        System.out.println(now);

        Point point1 = new Point(1,1);
        Point point2 = point1;

        point1.x = 2;
        System.out.println(point2);

//        String message = "Hello World!!";
//        System.out.println(message.replace("!", "*"));
        String message = "c:\\windows\\...";
        System.out.println(message);

        int[] numbers = {2,5,4,1,7,6};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

//        int[][] nestedNumbers = new int[2][4];
        int[][] nestedNumbers = {{2,3,4}, {5,6}};
        System.out.println("Length of nestedNumbers array is = " + nestedNumbers.length);
        System.out.println(Arrays.deepToString(nestedNumbers));

//        constants
        final float PI = 3.14F;
        System.out.println(PI);

        int result = 2 / 3;
        int x = 1;
        int y = ++x;
        System.out.println(x);
        System.out.println(y);

//        implicit casting
//        byte > short(2bytes) > int(4bytes) > long > float > double
        double a = 1.1;
        double b = a + 2;
        System.out.println(b);

        int rounded = (int) (Math.random() * 1000);
        System.out.println(rounded);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String currencyResult = currency.format(1234567.896);
        System.out.println(currencyResult);

        NumberFormat percentIns = NumberFormat.getPercentInstance();
        String percentResult = percentIns.format(0.65);
        System.out.println(percentResult);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age: ");
        short age = scanner.nextShort();
        System.out.println("You are " + age);
    }
}
