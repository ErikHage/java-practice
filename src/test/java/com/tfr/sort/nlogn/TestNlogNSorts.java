package com.tfr.sort.nlogn;

import com.tfr.sort.SortUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 *
 * Created by Erik on 6/13/2017.
 */
public class TestNlogNSorts {

    @Test
    public void testMergeSort() {
        System.out.println("Merge Sort");
        int[] values = SortUtils.getRandomIntArray(50);
        SortUtils.printValues(values);
        values = MergeSort.sort(values);
        SortUtils.printValues(values);
        assertTrue(SortUtils.isSorted(values));
    }

    @Test
    public void testQuickSort() {
        System.out.println("Quick Sort");
        int[] values = SortUtils.getRandomIntArray(50);
        SortUtils.printValues(values);
        values = QuickSort.sort(values);
        SortUtils.printValues(values);
        assertTrue(SortUtils.isSorted(values));
    }

    @Test
    public void testHeapSort() {
        System.out.println("Heap Sort");
        int[] values = SortUtils.getRandomIntArray(50);
        SortUtils.printValues(values);
        values = HeapSort.sort(values);
        SortUtils.printValues(values);
        assertTrue(SortUtils.isSorted(values));
    }

}
