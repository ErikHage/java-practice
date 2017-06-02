package com.tfr.collections.support.card;

/**
 *
 * Created by Erik on 5/30/2017.
 */
public class Card implements Comparable<Card> {

    public enum Rank {Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace}

    public enum Suit {Club, Diamond, Heart, Spade}

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card other) {
        return this.rank.compareTo(other.rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return rank == card.rank;
    }

    @Override
    public int hashCode() {
        return rank.hashCode();
    }

    @Override
    public String toString() {
        return rank + " of " + suit + "s";
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
