package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class TextReportTest {
    @Test
    public void generateFull() throws Exception {
        Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());

        Customer custMickeyMouse = new Customer("Mickey Mouse");

        Rental rental1 = new Rental(Arrays.asList(movCinderella, movStarWars), 5);

        custMickeyMouse.addRental(rental1);

        TextReport reporter = new TextReport();
        reporter.setReportType(AbstractReporter.ReportType.FULL);
        String statement = reporter.report(custMickeyMouse);
        String expected = "AbstractRental record for Mickey Mouse\n" +
                "\tRental 5 days\tsum 9.5\n" +
                "\t\tCinderella\t3.0\n" +
                "\t\tStar Wars\t6.5\n" +
                "Amount owed is 9.5\n" +
                "You earned 3 frequent renter points.";

        Assert.assertEquals(expected, statement);
    }

    @Test
    public void generateMedium() throws Exception {
        Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());

        Customer custMickeyMouse = new Customer("Mickey Mouse");

        Rental rental1 = new Rental(Arrays.asList(movCinderella, movStarWars), 5);

        custMickeyMouse.addRental(rental1);

        TextReport reporter = new TextReport();
        reporter.setReportType(AbstractReporter.ReportType.MEDIUM);
        String statement = reporter.report(custMickeyMouse);
        String expected = "AbstractRental record for Mickey Mouse\n" +
                "\tRental 5 days\tsum 9.5\n" +
                "Amount owed is 9.5\n" +
                "You earned 3 frequent renter points.";

        Assert.assertEquals(expected, statement);
    }

    @Test
    public void generateShort() throws Exception {
        Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());

        Customer custMickeyMouse = new Customer("Mickey Mouse");

        Rental rental1 = new Rental(Arrays.asList(movCinderella, movStarWars), 5);

        custMickeyMouse.addRental(rental1);

        TextReport reporter = new TextReport();
        reporter.setReportType(AbstractReporter.ReportType.SHORT);
        String statement = reporter.report(custMickeyMouse);
        String expected = "AbstractRental record for Mickey Mouse\n" +
                "Amount owed is 9.5\n" +
                "You earned 3 frequent renter points.";

        Assert.assertEquals(expected, statement);
    }

}