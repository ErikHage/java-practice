package com.tfr.collections.stack;

/**
 * Created by Erik on 4/28/2017.
 */
public class StackUnderflowException extends RuntimeException {

    public StackUnderflowException() {
        super();
    }

    public StackUnderflowException(String message) {
        super(message);
    }
}
