package com.tfr.collections.list.example;

import com.tfr.collections.list.ArrayBasedList;
import com.tfr.collections.list.List;
import com.tfr.collections.support.card.Card;

import java.util.Iterator;
import java.util.Random;

/**
 *
 *
 * Created by Erik on 5/30/2017.
 */
public class CardDeck {

    public static final int NUMBER_OF_CARDS = 52;

    protected List<Card> deck;
    protected Iterator<Card> deal;

    public CardDeck() {
        this.deck = new ArrayBasedList<>(NUMBER_OF_CARDS);
        for(Card.Rank rank : Card.Rank.values()) {
            for(Card.Suit suit : Card.Suit.values()) {
                deck.add(new Card(rank, suit));
            }
        }
        deal = deck.iterator();
    }

    public void shuffle() {
        Random random = new Random();
        int randomLocation;
        Card tempCard;

        for(int i=(NUMBER_OF_CARDS-1); i>0; i--) {
            randomLocation = random.nextInt(i);
            tempCard = deck.get(randomLocation);
            deck.set(randomLocation, deck.get(i));
            deck.set(i, tempCard);
        }

        deal = deck.iterator();
    }

    public boolean hasNextCard() {
        return deal.hasNext();
    }

    public Card getNextCard() {
        return deal.next();
    }




}
