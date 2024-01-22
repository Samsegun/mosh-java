package com.codewithmosh;

public class ControlFlow {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = "";
//
//        while (true) {
//            System.out.print("Enter value: ");
//            input = scanner.next().toLowerCase();
//
//            if(input.equals("pass")) continue;
//            if(input.equals("quit")) break;
//            System.out.println(input);
//        }

        String[] fruits = {"apples", "oranges", "bananas"};
        for (int i = fruits.length - 1; i >= 0; i--) {
            System.out.println(fruits[i]);
        }

//        for (String fruit : fruits) {
//            System.out.println(fruit);
//        }

    }
}

