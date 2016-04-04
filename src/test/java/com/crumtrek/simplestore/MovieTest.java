package com.scrumtrek.simplestore.tests;

import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import org.junit.Test;

/**
 * Created by Student on 04.04.2016.
 */
public class MovieTest {
    String title1 = "Cinderella";
    String title2 = "Star Wars";
    String title3 = "Gladiator";
    Movie m1 = new Movie(title1, PriceCodes.Childrens);
    Movie m2 = new Movie(title2, PriceCodes.Regular);
    Movie m3 = new Movie(title3, PriceCodes.NewRelease);

    @Test
    public void testTitle() {
        assert (title1.equals(m1.getTitle()));
        assert (title2.equals(m2.getTitle()));
        assert (title3.equals(m3.getTitle()));
    }

    @Test
    public void testPriceCode() {
        assert (PriceCodes.Childrens.equals(m1.getPriceCode()));
        assert (PriceCodes.Regular.equals(m2.getPriceCode()));
        assert (PriceCodes.NewRelease.equals(m3.getPriceCode()));
    }
}
