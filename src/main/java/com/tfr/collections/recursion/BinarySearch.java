package com.tfr.collections.recursion;

import java.util.Arrays;

/**
 * Binary search using recursion
 *
 * Created by Erik on 4/28/2017.
 */
public class BinarySearch {

    public static boolean binarySearch(int[] values, int target) {
        int midpoint = (values.length) /2;

        if(target == values[midpoint]) {
            return true;
        } else if(values.length <- 1) {
            return false;
        } else if(target > values[midpoint]) {
            return binarySearch(Arrays.copyOfRange(values, midpoint+1, values.length-1), target);
        } else {
            return binarySearch(Arrays.copyOfRange(values, 0, midpoint-1), target);
        }
    }

    public static boolean binarySearch(int[] values, int target, int first, int last) {
        int midpoint = (first + last) / 2;

        if(first > last) {
            return false;
        } else {
            if(target == values[midpoint]) {
                return true;
            } else if(target > values[midpoint]) {
                return binarySearch(values, target, midpoint+1, last);
            } else {
                return binarySearch(values, target, first, midpoint-1);
            }
        }
    }


}
