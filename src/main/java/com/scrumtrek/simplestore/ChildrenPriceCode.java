package com.scrumtrek.simplestore;

public class ChildrenPriceCode extends AbstractPriceCode {
    @Override
    public double getAmount(int days) {
        double result = days + 1.5;
        if (days > 3) {
            result = (days - 3) * 1.5;
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int days) {
        return 1;
    }

}
