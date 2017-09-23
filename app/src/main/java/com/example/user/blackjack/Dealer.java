package com.example.user.blackjack;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public class Dealer {
    private ArrayList<Card> deck;

    Dealer() {
        this.deck = new ArrayList<>();
    }

    ArrayList<Card> getDeck() {
        return deck;
    }

    void addCardToDeck(Card card) {
        deck.add(card);
    }

    void removeCard(Card card) {
        deck.remove(card);
    }

    int getSize() {
        return deck.size();
    }

    void createDeck() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                Card card = new Card(suit, value);
                deck.add(card);
            }
        }
    }

    Card getCardByIndex(int randomNum) {
        return this.deck.get(randomNum);
    }

    Card removeCardAtRandom(NumberGenerating numberGenerator) {
        int randomIndex = numberGenerator.generateNumber(deck.size());
        Card randomCard = getCardByIndex(randomIndex);
        deck.remove(randomCard);
        return randomCard;
    }

}
