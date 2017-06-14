package com.tfr.collections.priorityQueue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * Created by Erik on 6/8/2017.
 */
public class TestHeapPriorityQueue {

    @Test
    public void test() {
        PriorityQueue<String> queue = new HeapPriorityQueue<>(10);

        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        System.out.println(queue.toString());

        queue.enqueue("H");
        System.out.println(queue.toString());
        queue.enqueue("A");
        System.out.println(queue.toString());
        queue.enqueue("B");
        System.out.println(queue.toString());
        queue.enqueue("D");
        System.out.println(queue.toString());
        queue.enqueue("F");
        System.out.println(queue.toString());

        assertFalse(queue.isFull());
        assertFalse(queue.isEmpty());

        queue.enqueue("G");
        System.out.println(queue.toString());
        queue.enqueue("I");
        System.out.println(queue.toString());
        queue.enqueue("E");
        System.out.println(queue.toString());
        queue.enqueue("J");
        System.out.println(queue.toString());
        queue.enqueue("C");
        System.out.println(queue.toString());

        assertTrue(queue.isFull());
        assertFalse(queue.isEmpty());

        assertEquals(10, queue.getSize());

        assertEquals("J", queue.dequeue());
        System.out.println(queue.toString());

        System.out.print("Dequeue order: ");
        int size = queue.getSize();
        for(int i=0; i<size; i++) {
            System.out.print(queue.dequeue());
        }
        System.out.println("\n"+queue.toString());


    }

}
