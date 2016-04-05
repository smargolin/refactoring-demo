package com.scrumtrek.simplestore;

import java.util.Collection;

/**
 * Created by Student on 05.04.2016.
 */
public class Reporter {
    public static String customerReport(String customerName, Collection<Rental> rentals) {
        StringBuilder result = new StringBuilder();
        result.append("Rental record for ");
        result.append(customerName);
        result.append("\n");

        double totalAmount = 0;
        long rentalPoints = 0;
        for (Rental r : rentals) {
            if (customerName.equals(r.getCustomerName())) {
                totalAmount += r.getPriceCode().getPrice(r.getDaysRented());
                rentalPoints += r.getPriceCode().getRentalPoints(r.getDaysRented());
                result.append("\t");
                result.append(r.getMovieTitle());
                result.append("\t");
                result.append(r.getPriceCode().getPrice(r.getDaysRented()));
                result.append("\n");
            }
        }

        result.append("Amount owed is ");
        result.append(totalAmount);
        result.append("\n");
        result.append("You earned ");
        result.append(rentalPoints);
        result.append(" frequent renter points.");
        return result.toString();
    }
}
