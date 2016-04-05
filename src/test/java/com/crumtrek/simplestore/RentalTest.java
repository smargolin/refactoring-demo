package com.crumtrek.simplestore;

import com.scrumtrek.simplestore.Rental;
import org.junit.Test;

import static com.scrumtrek.simplestore.PriceCode.*;

/**
 * Created by Student on 05.04.2016.
 */
public class RentalTest {
    @Test
    public void testRental() {
        Rental r1 = new Rental("A1", "B1", Regular, 1);
        assert ("A1".equals(r1.getCustomerName()));
        assert ("B1".equals(r1.getMovieTitle()));
        assert (Regular.equals(r1.getPriceCode()));
        assert (r1.getDaysRented() == 1);
        Rental r2 = new Rental("A2", "B2", Childrens, 2);
        assert ("A2".equals(r2.getCustomerName()));
        assert ("B2".equals(r2.getMovieTitle()));
        assert (Childrens.equals(r2.getPriceCode()));
        assert (r2.getDaysRented() == 2);
        Rental r3 = new Rental("A3", "B3", NewRelease, 3);
        assert ("A3".equals(r3.getCustomerName()));
        assert ("B3".equals(r3.getMovieTitle()));
        assert (NewRelease.equals(r3.getPriceCode()));
        assert (r3.getDaysRented() == 3);
    }
}
