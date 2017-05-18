package com.tfr.collections.queue.example;

import com.tfr.collections.queue.LinkedGlassQueue;
import com.tfr.collections.support.Customer;
import com.tfr.collections.support.CustomerGenerator;

/**
 *
 * Created by Erik on 5/18/2017.
 */
@SuppressWarnings("unchecked")
public class Simulation {

    private final int MAXTIME = Integer.MAX_VALUE;

    private CustomerGenerator customerGenerator;
    private float averageWaitTime = 0.0f;

    public Simulation(int minInterArrivalTime, int maxInterArrivalTime, int minServiceTime, int maxServiceTime) {
        this.customerGenerator = new CustomerGenerator(minInterArrivalTime, maxInterArrivalTime,
                minServiceTime, maxServiceTime);
    }

    public float getAverageWaitTime() {
        return this.averageWaitTime;
    }

    public void simulate(int numberOfQueues, int numberOfCustomers) {

        LinkedGlassQueue<Customer>[] queues = new LinkedGlassQueue[numberOfQueues];

        Customer nextCustomer;
        Customer customer;
        Customer rearCustomer;

        int totalWaitTime = 0;
        int customerInCount = 0;
        int customerOutCount = 0;

        int nextArrivalTime;
        int nextDepartureTime;
        int nextQueue;

        int shortest;
        int shortestSize;
        int finishTime;

        for(int i=0; i<numberOfQueues; i++) {
            queues[i] = new LinkedGlassQueue<>();
        }

        customerGenerator.reset();
        nextCustomer = customerGenerator.nextCustomer();

        while(customerOutCount < numberOfCustomers) {
            if(customerInCount != numberOfCustomers) {
                nextArrivalTime = nextCustomer.getArrivalTime();
            } else {
                nextArrivalTime = MAXTIME;
            }

            nextDepartureTime = MAXTIME;
            nextQueue = -1;

            for(int i=0; i<numberOfQueues; i++) {
                if(queues[i].getSize() != 0) {
                    customer = queues[i].peekFront();
                    if(customer.getFinishTime() < nextDepartureTime) {
                        nextDepartureTime = customer.getFinishTime();
                        nextQueue = i;
                    }
                }
            }

            if(nextArrivalTime < nextDepartureTime) {
                shortest = 0;
                shortestSize = queues[0].getSize();
                for(int i=1; i<numberOfQueues; i++) {
                    if(queues[i].getSize() < shortestSize) {
                        shortest = i;
                        shortestSize = queues[i].getSize();
                    }
                }

                if(shortestSize == 0) {
                    finishTime = nextCustomer.getArrivalTime() + nextCustomer.getServiceTime();
                } else {
                    rearCustomer = queues[shortest].peekRear();
                    finishTime = rearCustomer.getFinishTime() + nextCustomer.getServiceTime();
                }

                nextCustomer.setFinishTime(finishTime);
                queues[shortest].enqueue(nextCustomer);

                customerInCount++;

                if(customerInCount < numberOfCustomers) {
                    nextCustomer = customerGenerator.nextCustomer();
                }
            } else {
                customer = queues[nextQueue].dequeue();
                totalWaitTime+=customer.getWaitTime();
                customerOutCount++;
            }

        }

        averageWaitTime = totalWaitTime/ (float)numberOfCustomers;
    }
}