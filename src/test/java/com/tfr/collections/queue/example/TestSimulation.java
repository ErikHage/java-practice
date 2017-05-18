package com.tfr.collections.queue.example;

import org.junit.Test;

/**
 *
 * Created by Erik on 5/18/2017.
 */
public class TestSimulation {

    @Test
    public void test() {
        Simulation simulation = new Simulation(5,10,15,20);
        simulation.simulate(1,20);
        float result = simulation.getAverageWaitTime();
        System.out.println("Average Wait Time = " + result);
    }

}
