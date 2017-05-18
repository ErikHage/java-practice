package com.tfr.collections.queue;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class QueueOverflowException extends RuntimeException {

    public QueueOverflowException() {
        super();
    }

    public QueueOverflowException(String message) {
        super(message);
    }

    public QueueOverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
