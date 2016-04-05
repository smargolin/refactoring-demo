package com.crumtrek.simplestore;

import org.junit.Test;

import static com.scrumtrek.simplestore.PriceCode.*;

/**
 * Created by Student on 05.04.2016.
 */
public class PriceCodeTest {
    @Test
    public void testRegular() {
        assert (Regular.getPrice(-1) == 0.0);
        assert (Regular.getPrice(0) == 0.0);
        assert (Regular.getPrice(5) == 6.5);
        assert (Regular.getRentalPoints(0) == 0);
        assert (Regular.getRentalPoints(5) == 1);
    }

    @Test
    public void testNewRelease() {
        assert (NewRelease.getPrice(-1) == 0.0);
        assert (NewRelease.getPrice(0) == 0.0);
        assert (NewRelease.getPrice(5) == 15.0);
        assert (NewRelease.getRentalPoints(0) == 0);
        assert (NewRelease.getRentalPoints(5) == 2);
    }

    @Test
    public void testChildrens() {
        assert (Childrens.getPrice(-1) == 0.0);
        assert (Childrens.getPrice(0) == 0.0);
        assert (Childrens.getPrice(5) == 3.0);
        assert (Childrens.getRentalPoints(0) == 0);
        assert (Childrens.getRentalPoints(5) == 1);
    }

    @Test
    public void testXXXPriceCode() {
        assert (XXXPriceCode.getPrice(-1) == 0.0);
        assert (XXXPriceCode.getPrice(0) == 0.0);
        assert (XXXPriceCode.getPrice(5) == 3.5);
        assert (XXXPriceCode.getRentalPoints(0) == 0);
        assert (XXXPriceCode.getRentalPoints(5) == 1);
    }
}