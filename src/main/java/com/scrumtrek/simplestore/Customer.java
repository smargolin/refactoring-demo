package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();
    private double discount;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public void setDiscount (double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}

