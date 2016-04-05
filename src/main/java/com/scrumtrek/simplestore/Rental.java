package com.scrumtrek.simplestore;

public class Rental {
    private String customerName;
    private String movieTitle;
    private PriceCode priceCode;
    private int daysRented;

    @SuppressWarnings("unused")
    private Rental() {
    }

    public Rental(String customerName, String movieTitle, PriceCode priceCode,
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

