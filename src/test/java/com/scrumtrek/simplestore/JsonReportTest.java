package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class JsonReportTest {
    @Test
    public void generateFull() throws Exception {
        Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());

        Customer custMickeyMouse = new Customer("Mickey Mouse");

        Rental rental1 = new Rental(Arrays.asList(movCinderella, movStarWars), 5);

        custMickeyMouse.addRental(rental1);

        JsonReport reporter = new JsonReport();
        reporter.setReportType(AbstractReporter.ReportType.FULL);
        String statement = reporter.report(custMickeyMouse);
        String expected = "{\"customer\":\"Mickey Mouse\",\"rentals\":[{\"days\":5,\"price\":9.5,\"movies\":[{\"name\":\"Cinderella\",\"price\":3.0},{\"name\":\"Star Wars\",\"price\":6.5}]}],\"totalPrice\":9.5,\"frequentRenterPoints\":3}";

        Assert.assertEquals(expected, statement);
    }

    @Test
    public void generateMedium() throws Exception {
        Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());

        Customer custMickeyMouse = new Customer("Mickey Mouse");

        Rental rental1 = new Rental(Arrays.asList(movCinderella, movStarWars), 5);

        custMickeyMouse.addRental(rental1);

        JsonReport reporter = new JsonReport();
        reporter.setReportType(AbstractReporter.ReportType.MEDIUM);
        String statement = reporter.report(custMickeyMouse);
        String expected = "{\"customer\":\"Mickey Mouse\",\"rentals\":[{\"days\":5,\"price\":9.5}],\"totalPrice\":9.5,\"frequentRenterPoints\":3}";

        Assert.assertEquals(expected, statement);
    }

    @Test
    public void generateShort() throws Exception {
        Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());

        Customer custMickeyMouse = new Customer("Mickey Mouse");

        Rental rental1 = new Rental(Arrays.asList(movCinderella, movStarWars), 5);

        custMickeyMouse.addRental(rental1);

        JsonReport reporter = new JsonReport();
        reporter.setReportType(AbstractReporter.ReportType.SHORT);
        String statement = reporter.report(custMickeyMouse);
        String expected = "{\"customer\":\"Mickey Mouse\",\"totalPrice\":9.5,\"frequentRenterPoints\":3}";

        Assert.assertEquals(expected, statement);
    }

}