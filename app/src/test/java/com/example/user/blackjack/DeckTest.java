package com.example.user.blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/09/2017.
 */

public class DeckTest {

    Deck deck;
    Card threeHearts;
    Card aceSpades;
    Card twoClubs;
    RandomNumberGenerator numberGenerator;
    FixedNumberGenerator fixedNumberGenerator;

    @Before
    public void before() {

        deck = new Deck();
        aceSpades = new Card(Suit.SPADES, Value.ACE);
        threeHearts = new Card(Suit.HEARTS, Value.THREE);
        twoClubs = new Card(Suit.CLUBS, Value.TWO);
        numberGenerator = new RandomNumberGenerator();
        fixedNumberGenerator = new FixedNumberGenerator();
    }

    @Test
    public void deckStartsEmpty() {
        assertEquals(0, deck.getSize());
    }

    @Test
    public void canAddCard() {
        deck.addCardToDeck(threeHearts);
        assertEquals(1, deck.getDeck().size());
    }

    @Test
    public void canRemoveCard() {
        deck.addCardToDeck(threeHearts);
        deck.addCardToDeck(aceSpades);
        assertEquals(deck.getDeck().size(), 2 );
        deck.removeCard(threeHearts);
        assertEquals(deck.getDeck().size(), 1);
    }

    @Test
    public void notRandomCard() {
        deck.addCardToDeck(threeHearts);
        deck.addCardToDeck(twoClubs);
        deck.addCardToDeck(aceSpades);
        assertEquals( aceSpades, deck.removeCardAtRandom(fixedNumberGenerator));
    }

    @Test
    public void deckHas52cards() {
        deck.createDeck();
        assertEquals( 52, deck.getDeck().size());
    }

    @Test
    public void randomCard() {
        deck.addCardToDeck(aceSpades);
        assertEquals( aceSpades, deck.removeCardAtRandom(numberGenerator));
    }
}

