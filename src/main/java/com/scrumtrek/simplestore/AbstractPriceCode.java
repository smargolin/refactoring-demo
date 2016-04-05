package com.scrumtrek.simplestore;

/**
 * Base class for price codes
 */
public abstract class AbstractPriceCode {
    /**
     * calculate price
     * @param days days rented
     * @return price
     */
    public abstract double getAmount(int days);

    /**
     * calculate frequent renter points
     * @param days days rented
     * @return frequent renter points
     */
    public abstract int getFrequentRenterPoints(int days);
}
