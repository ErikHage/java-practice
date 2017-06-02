package com.tfr.collections.list.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by Erik on 6/2/2017.
 */
public class TestLargeInt {

    @Test
    public void testAdd_BothPositive() {
        LargeInt li1 = new LargeInt("999");
        LargeInt li2 = new LargeInt("987");
        LargeInt li3 = LargeInt.add(li1, li2);
        assertEquals("+1,986", li3.toString());
    }

    @Test
    public void testAdd_BothNegative() {
        LargeInt li1 = new LargeInt("-999");
        LargeInt li2 = new LargeInt("-987");
        LargeInt li3 = LargeInt.add(li1, li2);
        assertEquals("-1,986", li3.toString());
    }

    @Test
    public void testAdd_DifferentSigns() {
        LargeInt li1 = new LargeInt("999");
        LargeInt li2 = new LargeInt("-987");
        LargeInt li3 = LargeInt.add(li1, li2);
        assertEquals("+12", li3.toString());
    }

    @Test
    public void testSubtract_BothPositive() {
        LargeInt li1 = new LargeInt("999");
        LargeInt li2 = new LargeInt("987");
        LargeInt li3 = LargeInt.subtract(li1, li2);
        assertEquals("+12", li3.toString());
    }

    @Test
    public void testSubtract_BothNegative() {
        LargeInt li1 = new LargeInt("-999");
        LargeInt li2 = new LargeInt("-987");
        LargeInt li3 = LargeInt.subtract(li1, li2);
        assertEquals("-12", li3.toString());
    }

    @Test
    public void testSubtract_DifferentSigns() {
        LargeInt li1 = new LargeInt("999");
        LargeInt li2 = new LargeInt("-987");
        LargeInt li3 = LargeInt.subtract(li1, li2);
        assertEquals("+1,986", li3.toString());
    }

}
