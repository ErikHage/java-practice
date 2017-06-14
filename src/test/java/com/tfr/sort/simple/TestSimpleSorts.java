package com.tfr.sort.simple;

import com.tfr.sort.SortUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 *
 * Created by Erik on 6/13/2017.
 */
public class TestSimpleSorts {

    @Test
    public void testSelectionSort() {
        System.out.println("Selection Sort");
        int[] values = SortUtils.getRandomIntArray(50);
        SortUtils.printValues(values);
        SelectionSort.sort(values);
        assertTrue(SortUtils.isSorted(values));
        SortUtils.printValues(values);
    }

    @Test
    public void testInsertionSort() {
        System.out.println("Insertion Sort");
        int[] values = SortUtils.getRandomIntArray(50);
        SortUtils.printValues(values);
        InsertionSort.sort(values);
        assertTrue(SortUtils.isSorted(values));
        SortUtils.printValues(values);
    }

    @Test
    public void testBubbleSort() {
        System.out.println("Bubble Sort");
        int[] values = SortUtils.getRandomIntArray(50);
        SortUtils.printValues(values);
        BubbleSort.sort(values);
        assertTrue(SortUtils.isSorted(values));
        SortUtils.printValues(values);
    }

    @Test
    public void testBubbleSortShort() {
        System.out.println("BubbleShort Sort");
        int[] values = SortUtils.getRandomIntArray(50);
        SortUtils.printValues(values);
        BubbleSort.sortShort(values);
        assertTrue(SortUtils.isSorted(values));
        SortUtils.printValues(values);
    }


}
