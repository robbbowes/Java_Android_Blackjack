package com.example.user.blackjack;

/**
 * Created by user on 22/09/2017.
 */

public class Card {
    Enum<Suit> suit;
    Enum<Value> value;

    public Card(Enum<Suit> suit, Enum<Value> value) {
        this.suit = suit;
        this.value = value;
    }

    Enum<Suit> getSuit() {
        return suit;
    }

    Enum<Value> getValue() {
        return value;
    }

    int getValueRanking() {
        return value.ordinal() + 1;
    }

    String getSuitString() {
        return suit.toString().toLowerCase();
    }

    String getValueString() {
        return value.toString().toLowerCase();
    }
}
