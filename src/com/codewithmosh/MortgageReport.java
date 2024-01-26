package com.codewithmosh;

import java.text.NumberFormat;

public class MortgageReport {

    private final MortgageCalculator calculator;
    private final NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String formattedMortgage = currency.format(mortgage);
        System.out.println("MORTGAGE \n--------\nMonthly Payments: " + formattedMortgage);
    }

    public void printPaymentSchedule() {
        System.out.println("\nPAYMENT SCHEDULE \n---------------");
        for(double balance: calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }
}
