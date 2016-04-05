package com.scrumtrek.simplestore;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static com.scrumtrek.simplestore.PriceCode.Childrens;
import static com.scrumtrek.simplestore.PriceCode.NewRelease;
import static com.scrumtrek.simplestore.PriceCode.Regular;

/**
 * Created by Student on 04.04.2016.
 */
public class ReprterTest {
    final static String MIKKI_REPORT = "Rental record for Mickey Mouse\n" +
            "\tCinderella\t3.0\n" +
            "\tStar Wars\t6.5\n" +
            "\tGladiator\t15.0\n" +
            "Amount owed is 24.5\n" +
            "You earned 4 frequent renter points.";
final static String JSO_NMIKKI_REPORT ="{\"customer\":\"Mickey Mouse\",\"movies\":{\"Cinderella\":3.0,\"Star Wars\":6.5,\"Gladiator\":15.0},\"total\":24.5,\"rentals\":4}";
    @Test
    public void testCustomerReport() {
        String custormer = "Mickey Mouse";
        String order = "N1";
        List<Rental> rentals = new ArrayList<>();
        rentals.add(new Rental(custormer, order, "Cinderella", Childrens, 5));
        rentals.add(new Rental(custormer, order, "Star Wars", Regular, 5));
        rentals.add(new Rental(custormer, order, "Gladiator", NewRelease, 5));

        // Generate invoice
        String statement = Reporter.customerReport(custormer, rentals);
        assert (MIKKI_REPORT.equals(statement));
    }

    @Test
    public void testJSONCustomerReport() {
        String custormer = "Mickey Mouse";
        String order = "N1";
        List<Rental> rentals = new ArrayList<>();
        rentals.add(new Rental(custormer, order, "Cinderella", Childrens, 5));
        rentals.add(new Rental(custormer, order, "Star Wars", Regular, 5));
        rentals.add(new Rental(custormer, order, "Gladiator", NewRelease, 5));

        // Generate invoice
        String statement = Reporter.customerJSONReport(custormer, rentals);
        assert (JSO_NMIKKI_REPORT.equals(statement));
    }
}
