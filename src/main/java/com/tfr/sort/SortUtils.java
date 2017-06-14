package com.tfr.sort;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * Created by Erik on 6/13/2017.
 */
public class SortUtils {

    public static int[] getRandomIntArray(int size) {
        int[] values = new int[size];
        for(int i=0; i<size; i++) {
            values[i] = ThreadLocalRandom.current().nextInt(0, 99);
        }
        return values;
    }

    public static void swap(int[] values, int index1, int index2) {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }

    public static boolean isSorted(int[] values) {
        for(int i=0; i<values.length-1; i++) {
            if(values[i] > values[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void printValues(int[] values) {
        int value;
        DecimalFormat format = new DecimalFormat("00");
        System.out.println("The values array is: ");
        for(int i=0; i<values.length; i++) {
            value = values[i];
            if((i+1)%10 == 0) {
                System.out.println(format.format(value) + " ");
            } else {
                System.out.print(format.format(value) + " ");
            }
        }
        System.out.println();
    }

}
