package com.tfr.sort.nlogn;

import com.tfr.sort.SortUtils;

/**
 * O(NlogN)
 *
 * Created by Erik on 6/14/2017.
 */
public class QuickSort {

    private static int[] localValues;

    public static int[] sort(int[] values) {
        localValues = values;
        quickSort(0, values.length-1);
        return localValues;
    }

    private static void quickSort(int first, int last) {
        System.out.println(String.format("quickSort(first:%s,last:%s)",first, last));
        if(first < last) {
            int splitPoint = split(first, last);
            quickSort(first, splitPoint-1);
            quickSort(splitPoint+1, last);
        }
    }

    private static int split(int first, int last) {
        System.out.println(String.format("split(first:%s,last:%s)",first, last));
        int splitVal = localValues[first];
        int saveFirst = first;
        boolean onCorrectSide;

        first++;

        do{
            onCorrectSide = true;
            while(onCorrectSide) { //move first toward last
                if(localValues[first] > splitVal) {
                    onCorrectSide= false;
                } else {
                    first++;
                    onCorrectSide = first <= last;
                }
            }

            onCorrectSide = first <= last;
            while(onCorrectSide) { //move last toward first
                if(localValues[last] <= splitVal) {
                    onCorrectSide = false;
                } else {
                    last--;
                    onCorrectSide = first <= last;
                }
            }

            if(first < last) {
                SortUtils.swap(localValues, first, last);
                first++;
                last--;
            }
        } while(first <= last);

        SortUtils.swap(localValues, saveFirst, last);
        return last;
    }

}
