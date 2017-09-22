package com.example.user.blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/09/2017.
 */

public class PlayerTest {

    Player player1;
    Player player2;
    Deck deck;
    Dealer dealer;
    NumberGenerating numberGenerator;

    @Before
    public void before() {

        player1 = new Player("Robb");
        player1 = new Player("Dave");
        deck = new Deck();
        dealer = new Dealer(deck);
        deck.createDeck();
        numberGenerator = new FixedNumberGenerator();
    }

    @Test
    public void playersStartWithNoCards() {
        assertEquals( 0, player1.getHand().size() );
    }

    @Test
    public void playerHasCards() {
        assertEquals( 52, deck.getSize() );
        Card card = deck.removeCardAtRandom(numberGenerator);
        player1.addCardToHand(card);
        assertEquals( 1, player1.getHand().size() );
    }

    @Test
    public void playerHasCard() {
        Card card = deck.removeCardAtRandom(numberGenerator);
        player1.addCardToHand(card);
        assertEquals( Suit.CLUBS, player1.getHand().get(0).getSuit() );
        assertEquals( Value.ACE, player1.getHand().get(0).getValue() );
    }






}
