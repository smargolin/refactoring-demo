package com.scrumtrek.simplestore;

public class NewReleasePriceCode extends AbstractPriceCode {
    @Override
    public double getAmount(int days) {
        return days * 3d;
    }

    @Override
    public int getFrequentRenterPoints(int days) {
        return 1;
    }

}
