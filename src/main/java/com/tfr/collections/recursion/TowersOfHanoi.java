package com.tfr.collections.recursion;

/**
 * Recursively solving the Towers of Hanoi
 *
 * Created by Erik on 4/28/2017.
 */
public class TowersOfHanoi {

    public static void doTowers(int numOfRings, int startPeg, int auxPeg, int endPeg) {
        if(numOfRings == 1) {
            print(numOfRings, startPeg, endPeg);
        } else {
            doTowers(numOfRings-1, startPeg, endPeg, auxPeg);
            print(numOfRings, startPeg, endPeg);
            doTowers(numOfRings-1, auxPeg, startPeg, endPeg);
        }
    }

    private static void print(int num, int sPeg, int ePeg) {
        System.out.println(String.format("Move ring %s from peg %s to peg %s", num, sPeg, ePeg));
    }

}
