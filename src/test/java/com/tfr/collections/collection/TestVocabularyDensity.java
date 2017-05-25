package com.tfr.collections.collection;

import com.tfr.collections.collection.example.VocabularyDensity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by Erik Hage on 5/25/2017.
 */
public class TestVocabularyDensity {

    private VocabularyDensity vocabularyDensity = new VocabularyDensity();

    @Test
    public void test_1() throws Exception {
        String data = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        assertEquals(1.0, vocabularyDensity.getDensity(data), 0.1);
    }

    @Test
    public void test_2() throws Exception {
        String data = "a b b c d d e f g g h i j k l m n o p q r s t u v w x y z z";
        assertEquals(30/26, vocabularyDensity.getDensity(data), 0.1);
    }
}
