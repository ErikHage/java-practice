package com.tfr.collections.tree.example;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Test;

import java.io.IOException;

/**
 *
 * Created by Erik on 6/5/2017.
 */
public class TestWordFrequencyCounter {

    @Test
    public void test1() throws IOException {
        String content = Resources.toString(Resources.getResource("collections/tree/wordFreqTest1.txt"), Charsets.UTF_8);
        WordFrequencyCounter.count(content, 1, 1);
    }

    @Test
    public void test2() throws IOException {
        String content = Resources.toString(Resources.getResource("collections/tree/wordFreqTest2.txt"), Charsets.UTF_8);
        WordFrequencyCounter.count(content, 5, 7);
    }

}
