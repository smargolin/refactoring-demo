package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

public class ChildrenPriceCodeTest {
    @Test
    public void getAmount() throws Exception {
        ChildrenPriceCode target = new ChildrenPriceCode();
        Assert.assertEquals(2.5d, target.getAmount(1), 0.2d);
        Assert.assertEquals(1.5d, target.getAmount(4), 0.2d);
        Assert.assertEquals(3d, target.getAmount(5), 0.2d);
    }

    @Test
    public void getFrequentRenterPoints() throws Exception {
        ChildrenPriceCode target = new ChildrenPriceCode();
        Assert.assertEquals(1, target.getFrequentRenterPoints(5));
    }
}