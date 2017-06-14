package com.tfr.sort.simple;

import com.tfr.sort.SortUtils;

/**
 * O(N^2)
 *
 * Created by Erik on 6/13/2017.
 */
public class SelectionSort {

    public static void sort(int[] values) {
        int endIndex = values.length - 1;
        for(int current = 0; current < endIndex; current++) {
            int minIndex = minIndex(values, current, endIndex);
            SortUtils.swap(values, current, minIndex);
        }
    }

    private static int minIndex(int[] values, int startIndex, int endIndex) {
        int indexOfMin = startIndex;
        for(int index = startIndex + 1; index <= endIndex; index++) {
            if(values[index] < values[indexOfMin]) {
                indexOfMin = index;
            }
        }
        return indexOfMin;

    }

}
