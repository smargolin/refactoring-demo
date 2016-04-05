package com.scrumtrek.simplestore;

import com.sun.istack.internal.NotNull;

public class Rental {
    private String customerName;
    private String movieTitle;
    private PriceCode priceCode;
    private int daysRented;

    @SuppressWarnings("unused")
    private Rental() {
    }

    public Rental(@NotNull String customerName, @NotNull String movieTitle, @NotNull PriceCode priceCode,
                  int daysRented) {
        this.customerName = customerName;
        this.movieTitle = movieTitle;
        this.priceCode = priceCode;
        this.daysRented = daysRented;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public int getDaysRented() {
        return daysRented;
    }
}

