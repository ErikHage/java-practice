package com.tfr.sort.nlogn;

import com.tfr.sort.SortUtils;

/**
 * O(NlogN)
 *
 * Created by Erik on 6/14/2017.
 */
public class HeapSort {

    public static int[] sort(int[] values) {
        int index;

        for(index = values.length/2; index>=0; index--) {
            reheapDown(values, values[index], index, values.length-1);
        }

        for(index=values.length-1; index>=1; index--) {
            SortUtils.swap(values, 0, index);
            reheapDown(values, values[0], 0, index-1);
        }

        return values;
    }

    private static void reheapDown(int[] values, int value, int index, int last) {
        int hole = index;
        int next = newHole(values, hole, value, last);

        while(next != hole) {
            values[hole] = values[next];
            hole = next;
            next = newHole(values, hole, value, last);
        }
        values[hole] = value;
    }

    private static int newHole(int[] values, int hole, int value, int last) {
        int left = (hole*2) + 1;
        int right = (hole*2) + 2;

        //hole has no children
        if(left > last) {
            return hole;
        }
        //hole has left child only
        else if(left == last) {
            if(value < values[left]) { //element < left child
                return left;
            } else { //element >= left child
                return hole;
            }
        }
        //hole has 2 children
        else if(values[left] < values[right]) {
            if(values[right] <= value) { //right child <= element
                return hole;
            } else { //element < right child
                return right;
            }
        }
        //left child >= right child
        else if(values[left] <= value) { //left child <= element
            return hole;
        }
        //element < left child
        else {
            return left;
        }
    }

}
