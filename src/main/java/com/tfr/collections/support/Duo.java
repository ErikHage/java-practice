package com.tfr.collections.support;

/**
 * A Tuple of two values
 *
 * Created by Erik Hage on 5/25/2017.
 */
public class Duo<A,B> {

    private A a;
    private B b;

    public Duo() {

    }

    public Duo(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
