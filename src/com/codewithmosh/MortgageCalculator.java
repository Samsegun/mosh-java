package com.codewithmosh;

public class MortgageCalculator {
    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;

    private int principal;
    private float annualInterestRate;

    private byte period;

    public MortgageCalculator(int principal, float annualInterestRate, byte period) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.period = period;
    }



    public double calculateMortgage() {
        double monthlyInterestRate = getMonthlyInterestRate();
        double actualInterestRateByPeriod = Math.pow(1 + monthlyInterestRate, getNumberOfPayments());

        double upperCalc = monthlyInterestRate * actualInterestRateByPeriod;
        double lowerCalc = actualInterestRateByPeriod - 1;

        return principal * (upperCalc / lowerCalc);
    }

    public  double calculateMortgageBalance(int numberOfPaymentsMade) {
        double monthlyInterestRate = getMonthlyInterestRate();
        double monthlyInterestByPeriod = Math.pow((1 + monthlyInterestRate), getNumberOfPayments());

        double upperCalc = monthlyInterestByPeriod - Math.pow((1 + monthlyInterestRate), numberOfPaymentsMade);
        double lowerCalc =  monthlyInterestByPeriod - 1;

        return (principal * upperCalc) / lowerCalc;
    }

    public double[] getRemainingBalances() {
        double[] balances = new double[getNumberOfPayments()];
        for (int month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateMortgageBalance(month);

        return balances;
    }

    private int getNumberOfPayments() {
        return period * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / PERCENT / MONTHS_IN_YEAR;
    }
}
