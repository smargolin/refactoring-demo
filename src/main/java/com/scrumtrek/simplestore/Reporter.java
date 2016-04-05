package com.scrumtrek.simplestore;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.util.Collection;

/**
 * Created by Student on 05.04.2016.
 */
public class Reporter {
    public static int REPORT_LEVEL_BRIEF = 1;
    public static int REPORT_LEVEL_MEDIUM = 2;
    public static int REPORT_LEVEL_FULL = 3;

    /**
     * Формирует отчет по заказам клиента из предоставленного списка заказов.
     *
     * @param customerName идентификатор клиента
     * @param rentals      список всех заказов
     * @return
     */
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
                result.append(r.toString());
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

    /**
     * Метод формирует JSON отчет по клиенту
     *
     * @return
     */
    public static String customerJSONReport(String customerName, Collection<Rental> rentals) {
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        jsonBuilder.add("customer", customerName);

        double totalAmount = 0;
        long rentalPoints = 0;
        JsonObjectBuilder movies = Json.createObjectBuilder();
        for (Rental r : rentals) {
            if (customerName.equals(r.getCustomerName())) {
                totalAmount += r.getPriceCode().getPrice(r.getDaysRented());
                rentalPoints += r.getPriceCode().getRentalPoints(r.getDaysRented());
                movies.add(r.getMovieTitle(), r.getPriceCode().getPrice(r.getDaysRented()));
            }
        }
        jsonBuilder.add("movies", movies);
        jsonBuilder.add("total", totalAmount);
        jsonBuilder.add("rentals", rentalPoints);
        return jsonBuilder.build().toString();
    }
}
