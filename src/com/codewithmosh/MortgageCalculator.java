package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte period = (byte) readNumber("Period (Years): ", 1, 30);

        printMortgage(principal, annualInterestRate, period);
        printPaymentSchedule(principal, annualInterestRate, period);
    }

    private static void printMortgage(int principal, float annualInterestRate, byte period) {
        double mortgage = calculateMortgage(principal, annualInterestRate, period);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE \n--------\nMonthly Payments: " + formattedMortgage);
    }

    private static void printPaymentSchedule(int principal, float annualInterestRate, byte period) {
        System.out.println("PAYMENT SCHEDULE \n---------------");
        for (int month = 1; month <= period * 12; month++) {
            System.out.println(calculateMortgageBalance(annualInterestRate, period, principal, month));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if ((value < min) || (value > max)) {
                System.out.println("Enter a value between " + (int)min + " and " + (int)max);
                continue;
            }
            break;
        }
        return value;
    }

    public static double calculateMortgage(int principal, float annualInterestRate, int period) {

        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        double actualInterestRateByPeriod = Math.pow(1 + monthlyInterestRate, period * MONTHS_IN_YEAR);

        double upperCalc = monthlyInterestRate * actualInterestRateByPeriod;
        double lowerCalc = actualInterestRateByPeriod - 1;

        return principal * (upperCalc / lowerCalc);
    }

    public static String calculateMortgageBalance(float annualInterestRate,
                                                  byte period, int principal,
                                                  int numberOfPaymentsMade) {
        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int NUMBER_OF_PAYMENTS = period * MONTHS_IN_YEAR;

        double monthlyInterestByPeriod = Math.pow((1 + monthlyInterestRate), NUMBER_OF_PAYMENTS);

        double upperCalc = monthlyInterestByPeriod - Math.pow((1 + monthlyInterestRate), numberOfPaymentsMade);
        double lowerCalc =  monthlyInterestByPeriod - 1;
        return NumberFormat.getCurrencyInstance().format((principal * upperCalc) / lowerCalc);
    }
}
