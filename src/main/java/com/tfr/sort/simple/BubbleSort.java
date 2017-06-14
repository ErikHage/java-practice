package com.tfr.sort.simple;

import com.tfr.sort.SortUtils;

/**
 * O(N^2)
 *
 * Created by Erik on 6/13/2017.
 */
public class BubbleSort {

    public static void sort(int[] values) {
        int current = 0;
        while(current < values.length-1) {
            bubbleUp(values, current, values.length-1);
            current++;
        }
    }

    private static void bubbleUp(int[] values, int startIndex, int endIndex) {
        for(int index=endIndex; index>startIndex; index--) {
            if(values[index] < values[index-1]) {
                SortUtils.swap(values, index, index-1);
            }
        }
    }

    public static void sortShort(int[] values) {
        int current = 0;
        boolean sorted = false;
        while(current < values.length-1 && !sorted) {
            sorted = bubbleUp2(values, current, values.length-1);
            current++;
        }
    }

    private static boolean bubbleUp2(int[] values, int startIndex, int endIndex) {
        boolean sorted = true;
        for(int index=endIndex; index>startIndex; index--) {
            if(values[index] < values[index-1]) {
                SortUtils.swap(values, index, index-1);
                sorted = false;
            }
        }
        return sorted;
    }
}
