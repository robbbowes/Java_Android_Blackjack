package com.example.user.blackjack;

import java.util.ArrayList;
import java.util.Random;

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

    public void removeCard(Card card) {
        deck.remove(card);
    }

    public int getSize() {
        return deck.size();
    }

    public void createDeck() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                Card card = new Card(suit, value);
                deck.add(card);
            }
        }
    }

    public Card getCardByIndex(int randomNum) {
        return this.deck.get(randomNum);
    }

    public Card removeCardAtRandom(NumberGenerating numberGenerator) {
        int randomIndex = numberGenerator.generateNumber(getSize());
        Card randomCard = getCardByIndex(randomIndex);
        deck.remove(randomCard);
        return randomCard;
    }

}
