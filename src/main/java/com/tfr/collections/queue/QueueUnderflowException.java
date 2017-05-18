package com.tfr.collections.queue;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class QueueUnderflowException extends RuntimeException {

    public QueueUnderflowException() {
        super();
    }

    public QueueUnderflowException(String message) {
        super(message);
    }

    public QueueUnderflowException(String message, Throwable cause) {
        super(message, cause);
    }
}
