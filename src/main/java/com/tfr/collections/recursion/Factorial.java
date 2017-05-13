package com.tfr.collections.recursion;

/**
 * Factorials with recursion
 *
 * Created by Erik on 4/28/2017.
 */
public class Factorial {

    public static int factorial(int n) {
        if(n == 0)
            return 1;
        else
            return n * factorial(n-1);
    }

}
