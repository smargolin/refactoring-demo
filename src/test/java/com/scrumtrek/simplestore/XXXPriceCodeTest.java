package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

public class XXXPriceCodeTest {
    @Test
    public void getAmount() throws Exception {
        XXXPriceCode target = new XXXPriceCode();
        Assert.assertEquals(4d, target.getAmount(1), 0.2d);
        Assert.assertEquals(4d, target.getAmount(4), 0.2d);
        Assert.assertEquals(5.5d, target.getAmount(5), 0.2d);
    }

    @Test
    public void getFrequentRenterPoints() throws Exception {
        XXXPriceCode target = new XXXPriceCode();
        Assert.assertEquals(1, target.getFrequentRenterPoints(1));
        Assert.assertEquals(1, target.getFrequentRenterPoints(2));
    }

}