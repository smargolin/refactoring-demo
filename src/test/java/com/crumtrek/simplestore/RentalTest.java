package com.crumtrek.simplestore;

import com.scrumtrek.simplestore.Rental;
import org.junit.Assert;
import org.junit.Test;

import static com.scrumtrek.simplestore.PriceCode.*;

/**
 * Created by Student on 05.04.2016.
 */
public class RentalTest {
    @Test
    public void testRental() {
        Rental r1 = new Rental("A1", "1", "B1", Regular, 1);
        Assert.assertTrue ("A1".equals(r1.getCustomerName()));
        Assert.assertTrue ("B1".equals(r1.getMovieTitle()));
        Assert.assertTrue (Regular.equals(r1.getPriceCode()));
        Assert.assertTrue (r1.getDaysRented() == 1);
        Rental r2 = new Rental("A2", "2", "B2", Childrens, 2);
        Assert.assertTrue ("A2".equals(r2.getCustomerName()));
        Assert.assertTrue ("B2".equals(r2.getMovieTitle()));
        Assert.assertTrue (Childrens.equals(r2.getPriceCode()));
        Assert.assertTrue (r2.getDaysRented() == 2);
        Rental r3 = new Rental("A3", "3", "B3", NewRelease, 3);
        Assert.assertTrue ("A3".equals(r3.getCustomerName()));
        Assert.assertTrue ("B3".equals(r3.getMovieTitle()));
        Assert.assertTrue (NewRelease.equals(r3.getPriceCode()));
        Assert.assertTrue (r3.getDaysRented() == 3);
    }
}
