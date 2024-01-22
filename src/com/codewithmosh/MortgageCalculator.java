package com.codewithmosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        int principal = 0;
        float annualInterestRate = 0;
        int period = 0;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if ((principal < 1000) || (principal > 1_000_000)) {
                System.out.println("Enter a number between 1,000 and 1,000,000.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if ((annualInterestRate < 1) || (annualInterestRate > 30)) {
                System.out.println("Enter a value greater than 0 and less than or equal to 30.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Period (Years): ");
            period = scanner.nextInt();
            if ((period < 1) || (period > 30)) {
                System.out.println("Enter a value greater than 0 and less than or equal to 30.");
                continue;
            }
            break;
        }

            scanner.close();

            double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
            double actualInterestRateByPeriod = Math.pow(1 + monthlyInterestRate, period * MONTHS_IN_YEAR);

            double upperCalc = monthlyInterestRate * actualInterestRateByPeriod;
            double lowerCalc = actualInterestRateByPeriod - 1;

            double mortgage = principal * (upperCalc / lowerCalc);
            String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

            System.out.println("Mortgage: " + formattedMortgage);


    }
}
