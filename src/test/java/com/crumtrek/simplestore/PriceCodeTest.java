package com.crumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

import static com.scrumtrek.simplestore.PriceCode.*;

/**
 * Created by Student on 05.04.2016.
 */
public class PriceCodeTest {
    @Test
    public void testRegular() {
        Assert.assertTrue(Regular.getPrice(-1) == 0.0);
        Assert.assertTrue(Regular.getPrice(0) == 0.0);
        Assert.assertTrue(Regular.getPrice(5) == 6.5);
        Assert.assertTrue(Regular.getRentalPoints(0) == 0);
        Assert.assertTrue(Regular.getRentalPoints(5) == 1);
    }

    @Test
    public void testNewRelease() {
        Assert.assertTrue (NewRelease.getPrice(-1) == 0.0);
        Assert.assertTrue (NewRelease.getPrice(0) == 0.0);
        Assert.assertTrue (NewRelease.getPrice(5) == 15.0);
        Assert.assertTrue (NewRelease.getRentalPoints(0) == 0);
        Assert.assertTrue (NewRelease.getRentalPoints(5) == 2);
    }

    @Test
    public void testChildrens() {
        Assert.assertTrue (Childrens.getPrice(-1) == 0.0);
        Assert.assertTrue (Childrens.getPrice(0) == 0.0);
        Assert.assertTrue (Childrens.getPrice(5) == 3.0);
        Assert.assertTrue (Childrens.getRentalPoints(0) == 0);
        Assert.assertTrue (Childrens.getRentalPoints(5) == 1);
    }

    @Test
    public void testXXXPriceCode() {
        Assert.assertTrue (XXXPriceCode.getPrice(-1) == 0.0);
        Assert.assertTrue (XXXPriceCode.getPrice(0) == 0.0);
        Assert.assertTrue (XXXPriceCode.getPrice(5) == 3.5);
        Assert.assertTrue (XXXPriceCode.getRentalPoints(0) == 0);
        Assert.assertTrue (XXXPriceCode.getRentalPoints(5) == 1);
    }
}