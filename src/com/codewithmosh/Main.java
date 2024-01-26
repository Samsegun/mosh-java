package com.codewithmosh;

public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte period = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var balance1 = new MortgageCalculator(principal, annualInterestRate, period);
        var mortgageReport = new MortgageReport(balance1);

        mortgageReport.printMortgage();
        mortgageReport.printPaymentSchedule();
    }


}
