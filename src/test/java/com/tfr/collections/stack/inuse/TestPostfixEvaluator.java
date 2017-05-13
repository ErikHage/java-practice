package com.tfr.collections.stack.inuse;

import com.tfr.collections.stack.StackOverflowException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for PostfixEvaluator
 *
 * Created by Erik on 4/28/2017.
 */
public class TestPostfixEvaluator {

    private PostfixEvaluator postfixEvaluator;

    @Before
    public void setUp() {
        postfixEvaluator = new PostfixEvaluator();
    }

    @Test
    public void test1_ExpectNegative16() {
        test("4 5 7 2 + - x", -16);
    }

    @Test
    public void test2_Expect2() {
        test("3 4 + 2 x 7 /", 2);
    }

    @Test
    public void test3_Expect48() {
        test("5 7 + 6 2 - x", 48);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test4_ExpectIllegalArgumentException() {
        test("4 2 3 5 1 - + x + x", 0);
    }

    @Test
    public void test5_Expect18() {
        test("4 2 + 3 5 1 - x +", 18);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test6_ExpectIllegalArgumentException() {
        test("3 5 7 9 + +", 0);
    }

    @Test
    public void test7_Expect48() {
        test("5 7 + 6 2 - x", 48);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test8_ExpectIllegalArgumentException() {
        test("5 3 7 9 ^ + -", 0);
    }

    @Test
    public void test9_Expect1275() {
        test("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +", 1275);
    }

    @Test(expected = StackOverflowException.class)
    public void test10_ExpectStackOverflowException() {
        test("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +", 0);
    }

    private void test(String expression, int expectedResult) {
        int actualResult = postfixEvaluator.evaluate(expression);
        assertEquals(expectedResult, actualResult);
    }

}
