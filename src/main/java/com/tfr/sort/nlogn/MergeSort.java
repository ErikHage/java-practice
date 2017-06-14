package com.tfr.sort.nlogn;

/**
 * O(NlogN)
 *
 * Created by Erik on 6/13/2017.
 */
public class MergeSort {

    private static int[] localValues;

    public static int[] sort(int[] values) {
        localValues = values;
        mergeSort(0, values.length-1);
        return localValues;
    }

    private static void mergeSort(int first, int last) {
        System.out.println(String.format("mergeSort(first:%s,last:%s)",first, last));
        if(first < last) {
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle+1, last);
            merge(first, middle, middle+1, last);
        }
    }

    private static void merge(int leftFirst, int leftLast, int rightFirst, int rightLast) {
        System.out.println(String.format("merge(leftFirst:%s,leftLast:%s,rightFirst:%s,rightLast:%s)",
                leftFirst, leftLast, rightFirst, rightLast));
        int[] tempArray = new int[localValues.length];
        int index = leftFirst;
        int saveFirst = leftFirst;  //to remember where to copy back

        while((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
            if(localValues[leftFirst] < localValues[rightFirst]) {
                tempArray[index] = localValues[leftFirst];
                leftFirst++;
            } else {
                tempArray[index] = localValues[rightFirst];
                rightFirst++;
            }
            index++;
        }

        while(leftFirst <= leftLast) { //copy remaining elements from left half
            tempArray[index] = localValues[leftFirst];
            leftFirst++;
            index++;
        }

        while(rightFirst <= rightLast) { //copy remaining elements from right half
            tempArray[index] = localValues[rightFirst];
            rightFirst++;
            index++;
        }

        for(index = saveFirst; index <= rightLast; index++) {
            localValues[index] = tempArray[index];
        }
    }


}
