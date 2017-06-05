package com.tfr.collections.tree.example;

import com.tfr.collections.tree.BinarySearchTree;

/**
 *
 * Created by Erik on 6/5/2017.
 */
public class WordFrequencyCounter {

    public static void count(String content, int minLength, int minFrequency) {

        BinarySearchTree<WordFrequency> tree = new BinarySearchTree<>();

        String[] wordsIn = content.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

        int wordCount = 0;
        int wordValidCount = 0;
        int countValidFreq = 0;

        WordFrequency wordToTest;
        WordFrequency wordInTree;
        for(String word : wordsIn) {
            wordCount++;
            if(word.length() > minLength) {
                wordValidCount++;
                wordToTest = new WordFrequency(word);
                wordInTree = tree.get(wordToTest);
                if (wordInTree != null) {
                    wordInTree.increment();
                } else {
                    wordToTest.increment();
                    tree.add(wordToTest);
                }
            }
        }

        System.out.println("Freq  Word");
        System.out.println("----- ------------------");
        for(WordFrequency wordFrequency : tree) {
            if(wordFrequency.getFrequency() >= minFrequency) {
                countValidFreq++;
                System.out.println(String.format("%s %s", wordFrequency.getFrequency(), wordFrequency.getWord()));
            }
        }
        System.out.println("Words in content: " + wordCount);
        System.out.println("Words with length > " + minLength + ": " + wordValidCount);
        System.out.println("Words with freq > " + minFrequency + ": " + countValidFreq);

    }

}
