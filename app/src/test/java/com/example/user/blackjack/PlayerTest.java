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
        player2 = new Player("Dave");
        deck = new Deck();
        dealer = new Dealer(deck);
        deck.createDeck();
        numberGenerator = new FixedNumberGenerator();
    }

    @Test
    public void playerHasName() {
        assertEquals( "Robb", player1.getName());
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

    @Test
    public void getTwoCards() {
        Card card1 = deck.removeCardAtRandom(numberGenerator);
        Card card2 = deck.removeCardAtRandom(numberGenerator);
        player1.addCardToHand(card1);
        player1.addCardToHand(card2);

        assertEquals( Suit.CLUBS, player1.getHand().get(0).getSuit() );
        assertEquals( Value.ACE, player1.getHand().get(0).getValue() );
        assertEquals( Suit.CLUBS, player1.getHand().get(1).getSuit() );
        assertEquals( Value.KING, player1.getHand().get(1).getValue() );

    }

    @Test
    public void canCalculateHand() {
        Card card1 = deck.removeCardAtRandom(numberGenerator);
        Card card2 = deck.removeCardAtRandom(numberGenerator);
        player1.addCardToHand(card1);
        player1.addCardToHand(card2);
        assertEquals( 21, player1.getHandWorth());
    }

    @Test
    public void hasTwoAces() {
        Card aceSpades = new Card(Suit.SPADES, Value.ACE);
        Card aceClubs = new Card(Suit.CLUBS, Value.ACE);
        Card threeHearts = new Card(Suit.HEARTS, Value.THREE);
        player1.addCardToHand(aceSpades);
        player1.addCardToHand(aceClubs);
        player1.addCardToHand(threeHearts);
        ArrayList<Card> player1Hand = player1.getHand();
        assertEquals( 2, player1.numOfAces(player1Hand));
    }

    @Test
    public void hasNoAces() {
        Card threeHearts = new Card(Suit.HEARTS, Value.THREE);
        player1.addCardToHand(threeHearts);
        ArrayList<Card> player1Hand = player1.getHand();
        assertEquals( 0, player1.numOfAces(player1Hand));
    }



}
