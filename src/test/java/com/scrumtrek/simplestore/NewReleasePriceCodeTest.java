package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

public class NewReleasePriceCodeTest {
    @Test
    public void getAmount() throws Exception {
        NewReleasePriceCode target = new NewReleasePriceCode();
        Assert.assertEquals(3d, target.getAmount(1), 0.2d);
        Assert.assertEquals(6d, target.getAmount(2), 0.2d);
    }

    @Test
    public void getFrequentRenterPoints() throws Exception {
        NewReleasePriceCode target = new NewReleasePriceCode();
        Assert.assertEquals(1, target.getFrequentRenterPoints(5));
    }
}