package com.tfr.collections.tree.example;

import java.text.DecimalFormat;

/**
 *
 * Created by Erik on 6/5/2017.
 */
public class WordFrequency implements Comparable<WordFrequency> {

    private String word;
    private int frequency;

    private DecimalFormat format = new DecimalFormat("00000");

    public WordFrequency(String word) {
        this.word = word;
        this.frequency = 0;
    }

    public void increment() {
        frequency++;
    }

    @Override
    public String toString() {
        return format.format(frequency) + " " + word;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public int compareTo(WordFrequency o) {
        return this.word.compareTo(o.word);
    }
}
