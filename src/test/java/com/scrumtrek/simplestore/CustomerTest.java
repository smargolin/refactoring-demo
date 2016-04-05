package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class CustomerTest {
    @Test
    public void statementText() throws Exception {
        Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());
        Movie movGladiator = new Movie("Gladiator", new NewReleasePriceCode());

        Customer custMickeyMouse = new Customer("Mickey Mouse");

        Rental rental1 = new Rental(Collections.singletonList(movCinderella), 5);
        Rental rental2 = new Rental(Collections.singletonList(movStarWars), 5);
        Rental rental3 = new Rental(Collections.singletonList(movGladiator), 5);

        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        String statement = new TextReport().report(custMickeyMouse);
        String expected = "AbstractRental record for Mickey Mouse\n" +
                "\tRental 5 days\tsum 3.0\n" +
                "\t\tCinderella\t3.0\n" +
                "\tRental 5 days\tsum 6.5\n" +
                "\t\tStar Wars\t6.5\n" +
                "\tRental 5 days\tsum 15.0\n" +
                "\t\tGladiator\t15.0\n" +
                "Amount owed is 24.5\n" +
                "You earned 4 frequent renter points.";

        Assert.assertEquals(expected, statement);
    }

    @Test
    public void statementText2() throws Exception {
        Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());
        Movie movGladiator = new Movie("Gladiator", new NewReleasePriceCode());

        Customer custMickeyMouse = new Customer("Mickey Mouse");

        Rental rental1 = new Rental(Collections.singletonList(movCinderella), 3);
        Rental rental2 = new Rental(Collections.singletonList(movStarWars), 5);
        Rental rental3 = new Rental(Collections.singletonList(movGladiator), 5);

        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        String statement = new TextReport().report(custMickeyMouse);
        String expected = "AbstractRental record for Mickey Mouse\n" +
                "\tRental 3 days\tsum 4.5\n" +
                "\t\tCinderella\t4.5\n" +
                "\tRental 5 days\tsum 6.5\n" +
                "\t\tStar Wars\t6.5\n" +
                "\tRental 5 days\tsum 15.0\n" +
                "\t\tGladiator\t15.0\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent renter points.";

        Assert.assertEquals(expected, statement);
    }

    @Test
    public void statementText3() throws Exception {
        Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());
        Movie movGladiator = new Movie("Gladiator", new NewReleasePriceCode());

        Customer custMickeyMouse = new Customer("Mickey Mouse");

        Rental rental1 = new Rental(Collections.singletonList(movCinderella), 5);
        Rental rental2 = new Rental(Collections.singletonList(movStarWars), 1);
        Rental rental3 = new Rental(Collections.singletonList(movGladiator), 5);

        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        String statement = new TextReport().report(custMickeyMouse);
        String expected = "AbstractRental record for Mickey Mouse\n" +
                "\tRental 5 days\tsum 3.0\n" +
                "\t\tCinderella\t3.0\n" +
                "\tRental 1 days\tsum 2.0\n" +
                "\t\tStar Wars\t2.0\n" +
                "\tRental 5 days\tsum 15.0\n" +
                "\t\tGladiator\t15.0\n" +
                "Amount owed is 20.0\n" +
                "You earned 3 frequent renter points.";

        Assert.assertEquals(expected, statement);
    }

    @Test
    public void statementJson() throws Exception {
        Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());
        Movie movGladiator = new Movie("Gladiator", new NewReleasePriceCode());

        Customer custMickeyMouse = new Customer("Mickey Mouse");

        Rental rental1 = new Rental(Collections.singletonList(movCinderella), 5);
        Rental rental2 = new Rental(Collections.singletonList(movStarWars), 5);
        Rental rental3 = new Rental(Collections.singletonList(movGladiator), 5);

        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        String statement = new JsonReport().report(custMickeyMouse);
        String expected = "{\"customer\":\"Mickey Mouse\",\"rentals\":[{\"days\":5,\"price\":3.0,\"movies\":[{\"name\":\"Cinderella\",\"price\":3.0}]},{\"days\":5,\"price\":6.5,\"movies\":[{\"name\":\"Star Wars\",\"price\":6.5}]},{\"days\":5,\"price\":15.0,\"movies\":[{\"name\":\"Gladiator\",\"price\":15.0}]}],\"totalPrice\":24.5,\"frequentRenterPoints\":4}";

        Assert.assertEquals(expected, statement);
    }

    @Test
    public void discountTestJSON () {
        Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());
        Movie movGladiator = new Movie("Gladiator", new NewReleasePriceCode());

        Customer custMickeyMouse = new Customer("Mickey Mouse");

        Rental rental1 = new Rental(Collections.singletonList(movCinderella), 5);
        Rental rental2 = new Rental(Collections.singletonList(movStarWars), 5);
        Rental rental3 = new Rental(Collections.singletonList(movGladiator), 5);

        custMickeyMouse.setDiscount(50);
        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        String statement = new JsonReport().report(custMickeyMouse);
        String expected = "{\"customer\":\"Mickey Mouse\",\"rentals\":[{\"days\":5,\"price\":3.0,\"movies\":[{\"name\":\"Cinderella\",\"price\":3.0}]},{\"days\":5,\"price\":6.5,\"movies\":[{\"name\":\"Star Wars\",\"price\":6.5}]},{\"days\":5,\"price\":15.0,\"movies\":[{\"name\":\"Gladiator\",\"price\":15.0}]}],\"totalPrice\":12.25,\"frequentRenterPoints\":4}";

        Assert.assertEquals(expected, statement);
    }

    @Test
    public void statementDiscountText() throws Exception {
        Movie movCinderella = new Movie("Cinderella", new ChildrenPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());
        Movie movGladiator = new Movie("Gladiator", new NewReleasePriceCode());

        Customer custMickeyMouse = new Customer("Mickey Mouse");
        custMickeyMouse.setDiscount(50);

        Rental rental1 = new Rental(Collections.singletonList(movCinderella), 5);
        Rental rental2 = new Rental(Collections.singletonList(movStarWars), 5);
        Rental rental3 = new Rental(Collections.singletonList(movGladiator), 5);

        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        String statement = new TextReport().report(custMickeyMouse);
        String expected = "AbstractRental record for Mickey Mouse\n" +
                "\tRental 5 days\tsum 3.0\n" +
                "\t\tCinderella\t3.0\n" +
                "\tRental 5 days\tsum 6.5\n" +
                "\t\tStar Wars\t6.5\n" +
                "\tRental 5 days\tsum 15.0\n" +
                "\t\tGladiator\t15.0\n" +
                "Amount owed is 12.25\n" +
                "You earned 4 frequent renter points.";

        Assert.assertEquals(expected, statement);
    }

}