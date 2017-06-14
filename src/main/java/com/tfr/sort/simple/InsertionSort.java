package com.tfr.sort.simple;

import com.tfr.sort.SortUtils;

/**
 *
 *
 * Created by Erik on 6/13/2017.
 */
public class InsertionSort {

    public static void sort(int[] values) {
        for(int count=1; count<values.length; count++) {
            insertElement(values, 0, count);
        }
    }

    private static void insertElement(int[] values, int startIndex, int endIndex) {
        boolean finished = false;
        int current = endIndex;
        boolean moreToSearch = true;

        while(moreToSearch && !finished) {
            if(values[current] < values[current-1]) {
                SortUtils.swap(values, current, current-1);
                current--;
                moreToSearch = (current != startIndex);
            } else {
                finished = true;
            }
        }
    }
}
