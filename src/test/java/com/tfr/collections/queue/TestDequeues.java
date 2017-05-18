package com.tfr.collections.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class TestDequeues {

    @Test
    public void testLinkedDQ_EnqueueFrontDequeueFront_Expect10() {
        Dequeue<Integer> dequeue = populateDequeueFront(10, new LinkedDequeue<>());
        assertEquals(10, dequeue.dequeueFront().intValue());
    }

    @Test
    public void testLinkedDQ_EnqueueFrontDequeueRear_Expect1() {
        Dequeue<Integer> dequeue = populateDequeueFront(10, new LinkedDequeue<>());
        assertEquals(1, dequeue.dequeueRear().intValue());
    }

    @Test
    public void testLinkedDQ_EnqueueRearDequeueFront_Expect1() {
        Dequeue<Integer> dequeue = populateDequeueRear(10, new LinkedDequeue<>());
        assertEquals(1, dequeue.dequeueFront().intValue());
    }

    @Test
    public void testLinkedDQ_EnqueueRearDequeueRear_Expect10() {
        Dequeue<Integer> dequeue = populateDequeueRear(10, new LinkedDequeue<>());
        assertEquals(10, dequeue.dequeueRear().intValue());
    }



    private Dequeue<Integer> populateDequeueFront(int num, Dequeue<Integer> dequeue) {
        for(int i=1; i<=num; i++) {
            dequeue.enqueueFront(i);
        }
        return dequeue;
    }

    private Dequeue<Integer> populateDequeueRear(int num, Dequeue<Integer> dequeue) {
        for(int i=1; i<=num; i++) {
            dequeue.enqueueRear(i);
        }
        return dequeue;
    }
}
