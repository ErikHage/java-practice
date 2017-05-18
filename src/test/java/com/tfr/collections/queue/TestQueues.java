package com.tfr.collections.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class TestQueues {

    /* ArrayBoundedQueue */

    @Test
    public void testABQ_EnqueueDequeue_ExpectSuccess() {
        Queue<Integer> queue = populateQueue(5, new ArrayBoundedQueue<>());
        int num1 = queue.dequeue();
        assertEquals(1, num1);
    }

    @Test
    public void testABQ_GetSize_Expect10() {
        Queue<Integer> queue = populateQueue(10, new ArrayBoundedQueue<>());
        assertEquals(10, queue.getSize());
    }

    @Test (expected = QueueUnderflowException.class)
    public void testABQ_ExpectUnderflowException() {
        Queue<Integer> queue = populateQueue(1, new ArrayBoundedQueue<>());
        queue.dequeue();
        queue.dequeue();
    }

    @Test (expected = QueueOverflowException.class)
    public void testABQ_ExpectOverflowException() {
        Queue<Integer> queue = populateQueue(1, new ArrayBoundedQueue<>(1));
        queue.enqueue(2);
    }

    /* ArrayUnboundedQueue */

    @Test
    public void testAUQ_EnqueueDequeue_ExpectSuccess() {
        Queue<Integer> queue = populateQueue(5, new ArrayUnboundedQueue<>());
        int num1 = queue.dequeue();
        assertEquals(1, num1);
    }

    @Test
    public void testAUQ_GetSize_Expect10() {
        Queue<Integer> queue = populateQueue(10, new ArrayUnboundedQueue<>());
        assertEquals(10, queue.getSize());
    }

    @Test (expected = QueueUnderflowException.class)
    public void testAUQ_ExpectUnderflowException() {
        Queue<Integer> queue = populateQueue(1, new ArrayUnboundedQueue<>());
        queue.dequeue();
        queue.dequeue();
    }

    @Test
    public void testAUQ_ExpectNoException() {
        Queue<Integer> queue = populateQueue(1, new ArrayUnboundedQueue<>(1));
        queue.enqueue(2);
    }

    /* LinkedQueue */

    @Test
    public void testLinkedQ_EnqueueDequeue_ExpectSuccess() {
        Queue<Integer> queue = populateQueue(5, new LinkedQueue<>());
        int num1 = queue.dequeue();
        assertEquals(1, num1);
    }

    @Test
    public void testLinkedQ_GetSize_Expect10() {
        Queue<Integer> queue = populateQueue(10, new LinkedQueue<>());
        assertEquals(10, queue.getSize());
    }

    @Test (expected = QueueUnderflowException.class)
    public void testLinkedQ_ExpectUnderflowException() {
        Queue<Integer> queue = populateQueue(1, new LinkedQueue<>());
        queue.dequeue();
        queue.dequeue();
    }

    @Test
    public void testLinkedQ_ExpectNoException() {
        Queue<Integer> queue = populateQueue(1, new LinkedQueue<>());
        queue.enqueue(2);
    }

    /* CircularLinkedQueue */

    @Test
    public void testCLinkedQ_EnqueueDequeue_ExpectSuccess() {
        Queue<Integer> queue = populateQueue(5, new CircularLinkedQueue<>());
        int num1 = queue.dequeue();
        assertEquals(1, num1);
    }

    @Test
    public void testCLinkedQ_GetSize_Expect10() {
        Queue<Integer> queue = populateQueue(10, new CircularLinkedQueue<>());
        assertEquals(10, queue.getSize());
    }

    @Test (expected = QueueUnderflowException.class)
    public void testCLinkedQ_ExpectUnderflowException() {
        Queue<Integer> queue = populateQueue(1, new CircularLinkedQueue<>());
        queue.dequeue();
        queue.dequeue();
    }

    @Test
    public void testCLinkedQ_ExpectNoException() {
        Queue<Integer> queue = populateQueue(1, new CircularLinkedQueue<>());
        queue.enqueue(2);
    }





    private Queue<Integer> populateQueue(int num, Queue<Integer> queue) {
        for(int i=1; i<=num; i++) {
            queue.enqueue(i);
        }
        return queue;
    }

}
