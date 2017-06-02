package com.tfr.collections.list.example;

import com.tfr.collections.list.ArrayBasedList;
import com.tfr.collections.list.List;
import com.tfr.collections.support.card.Card;
import org.junit.Test;

/**
 *
 * Created by Erik on 5/30/2017.
 */
public class TestCardDeck {

    @Test
    public void test_5CardHand() {
        CardDeck deck = new CardDeck();
        List<Card> hand = new ArrayBasedList<>(5);

        deck.shuffle();

        for(int i=0; i<5; i++) {
            hand.add(deck.getNextCard());

            System.out.print("Hand so far: ");
            for(Card card : hand) {
                System.out.print(card.getRank() + " of " + card.getSuit() + "s | ");
            }
            System.out.println();
        }
    }

    @Test
    public void test_HigherOrLower() {
        for(int i=0; i<10; i++) {
            testHigherOrLower();
        }
    }

    private void testHigherOrLower() {
        Card card1;
        Card card2;

        CardDeck deck = new CardDeck();
        deck.shuffle();

        card1 = deck.getNextCard();
        System.out.print("Card 1: " + card1 + " | ");
        card2 = deck.getNextCard();
        System.out.println("Card 2: " + card2);

        System.out.print("Card 2 is ");
        if(card2.compareTo(card1) > 0) {
            System.out.println("Higher");
        } else if(card2.compareTo(card1) < 0) {
            System.out.println("Lower");
        } else {
            System.out.println("Same");
        }
    }

    @Test
    public void test_HowRareIsAPair() {
        int handSize = 5;
        int numberOfHands = 1000000;
        int numberOfPairs = 0;
        boolean isPair;
        float probability;
        Card card;
        CardDeck deck = new CardDeck();
        List<Card> hand;

        for(int i=0; i<numberOfHands; i++) {
            deck.shuffle();
            hand = new ArrayBasedList<>(handSize);
            isPair = false;
            for(int j=0; j<handSize; j++) {
                card = deck.getNextCard();
                if(hand.contains(card)) {
                    isPair = true;
                }
                hand.add(card);
            }
            if(isPair) {
                numberOfPairs++;
            }
        }

        probability = numberOfPairs / (float)numberOfHands;

        System.out.println(numberOfPairs + " hands out of " + numberOfHands + " had at least 1 pair");
        System.out.println("Calculated probability = " + probability);
    }

}
