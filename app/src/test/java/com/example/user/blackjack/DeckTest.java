package com.example.user.blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/09/2017.
 */

public class DeckTest {

    Deck deck;
    Card threeHearts;
    Card aceSpades;

    @Before
    public void before() {

        deck = new Deck();
        aceSpades = new Card(Suit.SPADES, Value.ACE);
        threeHearts = new Card(Suit.HEARTS, Value.THREE);
    }

    @Test
    public void deckStartsEmpty() {
        assertEquals(0, deck.getDeck().size());
    }

    @Test
    public void canAddCard() {
        deck.addCardToDeck(threeHearts);
        assertEquals(1, deck.getDeck().size());
    }
}

