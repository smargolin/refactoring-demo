package com.scrumtrek.simplestore;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

public class Rental {
    private String customerName;
    private String orderId;
    private String movieTitle;
    private PriceCode priceCode;
    private int daysRented;

    @SuppressWarnings("unused")
    private Rental() {
    }

    public Rental(String customerName, String orderId, String movieTitle, PriceCode priceCode,
                  int daysRented) {
        this.customerName = customerName;
        this.orderId = orderId;
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

    public String getOrderId() {
        return orderId;
    }

    public String toString () {
        StringBuilder result = new StringBuilder();
        result.append("\t");
        result.append(getMovieTitle());
        result.append("\t");
        result.append(getPriceCode().getPrice(getDaysRented()));
        result.append("\n");
        return  result.toString();
    }

    public String toJSON () {
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder()
                .add("title", getMovieTitle())
                .add("price", getPriceCode().getPrice(getDaysRented()));
        return  jsonBuilder.build().toString();
    }
}

