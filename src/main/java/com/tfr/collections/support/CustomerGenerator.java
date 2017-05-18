package com.tfr.collections.support;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class CustomerGenerator {

    private int minInterArrivalTime;
    private int maxInterArrivalTime;

    private int minServiceTime;
    private int maxServiceTime;

    private int currentTime = 0;

    public CustomerGenerator(int minInterArrivalTime, int maxInterArrivalTime, int minServiceTime, int maxServiceTime) {
        this.minInterArrivalTime = minInterArrivalTime;
        this.maxInterArrivalTime = maxInterArrivalTime;
        this.minServiceTime = minServiceTime;
        this.maxServiceTime = maxServiceTime;
    }

    public void reset() {
        currentTime = 0;
    }

    public Customer nextCustomer() {
        int interArrivalTime = ThreadLocalRandom.current().nextInt(minInterArrivalTime, maxInterArrivalTime);
        int serviceTime = ThreadLocalRandom.current().nextInt(minServiceTime, maxServiceTime);

        currentTime = currentTime + interArrivalTime;

        Customer customer = new Customer(currentTime, serviceTime);
        return customer;
    }
}
