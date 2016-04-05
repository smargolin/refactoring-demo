package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

public class RegularPriceCodeTest {
    @Test
    public void getAmount() throws Exception {
        RegularPriceCode target = new RegularPriceCode();
        Assert.assertEquals(2d, target.getAmount(1), 0.2d);
        Assert.assertEquals(2d, target.getAmount(2), 0.2d);
        Assert.assertEquals(3.5d, target.getAmount(3), 0.2d);
    }

    @Test
    public void getFrequentRenterPoints() throws Exception {
        RegularPriceCode target = new RegularPriceCode();
        Assert.assertEquals(1, target.getFrequentRenterPoints(1));
        Assert.assertEquals(2, target.getFrequentRenterPoints(3));
    }
}