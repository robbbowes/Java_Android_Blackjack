package com.example.user.blackjack;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public class Deck {
    ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void addCardToDeck(Card card) {
        deck.add(card);
    }

    public void removeCardFromDeck(int randomNumber) {}



}
