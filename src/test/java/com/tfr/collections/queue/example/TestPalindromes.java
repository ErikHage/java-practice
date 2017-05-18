package com.tfr.collections.queue.example;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class TestPalindromes {

    @Test
    public void test() {
        assertTrue(Palindromes.test("racecar"));
        assertTrue(Palindromes.test("Are we not drawn onward, we few? Drawn onward to new era!"));

        assertFalse(Palindromes.test("aabaaa"));
        assertFalse(Palindromes.test("fred"));
    }

}

