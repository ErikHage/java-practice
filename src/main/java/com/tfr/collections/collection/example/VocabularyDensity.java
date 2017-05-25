package com.tfr.collections.collection.example;

import com.tfr.collections.collection.ArrayBasedCollection;
import com.tfr.collections.collection.Collection;

/**
 *
 * Created by Erik Hage on 5/25/2017.
 */
public class VocabularyDensity {

    public double getDensity(String content) throws Exception {

        String[] allWords = content.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        int numWords = allWords.length;

        Collection<String> uniqueWords = new ArrayBasedCollection<>(numWords);

        for(String s : allWords) {
            if(!uniqueWords.contains(s)) {
                uniqueWords.add(s);
            }
        }

        return numWords/uniqueWords.getSize();
    }

}
