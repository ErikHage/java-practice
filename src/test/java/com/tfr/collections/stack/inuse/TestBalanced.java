package com.tfr.collections.stack.inuse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for Balanced
 *
 * Created by Erik on 4/28/2017.
 */
public class TestBalanced {

    private Balanced balanced;

    @Before
    public void setUp() {
        balanced = new Balanced("({[",")}]");
    }

    @Test
    public void test1_Expect0() {
        test("(11{123}[456])", 0);
    }

    @Test
    public void test2_Expect1() {
        test("(ttttt]", 1);
    }

    @Test
    public void test3_Expect2() {
        test("((())", 2);
    }

    @Test
    public void test4_Expect0() {
        test("(){}{}[({{[{({})}]}})]", 0);
    }

    private void test(String expression, int expectedResult) {
        int result = balanced.test(expression);
        assertEquals(expectedResult, result);
    }

}
