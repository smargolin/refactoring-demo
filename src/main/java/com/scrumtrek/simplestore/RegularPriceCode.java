package com.scrumtrek.simplestore;

public class RegularPriceCode extends AbstractPriceCode {
    @Override
    public double getAmount(int days) {
        double result = 2;
        if (days > 2) {
            result += (days - 2) * 1.5;
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int days) {
        return days > 1 ? 2 : 1;
    }
}
