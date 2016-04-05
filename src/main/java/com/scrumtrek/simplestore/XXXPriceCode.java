package com.scrumtrek.simplestore;

public class XXXPriceCode extends AbstractPriceCode {
    @Override
    public double getAmount(int days) {
        double result = 4;
        if (days > 4) {
            result += (days - 4) * 1.5;
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int days) {
        return 1;
    }
}
