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

        player1 = new Player("Robb", false);
        player2 = new Player("Dave", false);
        deck = new Deck();
        dealer = new Dealer(deck, numberGenerator);
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

    @Test
    public void aceCountsAs11And1() {
        Card aceSpades = new Card(Suit.SPADES, Value.ACE);
        Card aceClubs = new Card(Suit.CLUBS, Value.ACE);
        player1.addCardToHand(aceSpades);
        player1.addCardToHand(aceClubs);
        assertEquals( 12, player1.getHandWorth());
    }

    @Test
    public void singleAceCountsAs11() {
        Card aceSpades = new Card(Suit.SPADES, Value.ACE);
        player1.addCardToHand(aceSpades);
        assertEquals( 11, player1.getHandWorth());
    }

    @Test
    public void fourAcesCountAs14() {
        Card aceSpades = new Card(Suit.SPADES, Value.ACE);
        Card aceClubs = new Card(Suit.CLUBS, Value.ACE);
        Card aceDiamonds = new Card(Suit.DIAMONDS, Value.ACE);
        Card aceHearts = new Card(Suit.HEARTS, Value.ACE);
        player1.addCardToHand(aceSpades);
        player1.addCardToHand(aceClubs);
        player1.addCardToHand(aceDiamonds);
        player1.addCardToHand(aceHearts);
        assertEquals( 14, player1.getHandWorth());
    }

    @Test
    public void aceWillNotCountAsHighIfOver12() {
        Card aceSpades = new Card(Suit.SPADES, Value.ACE);
        Card aceClubs = new Card(Suit.CLUBS, Value.ACE);
        Card aceDiamonds = new Card(Suit.DIAMONDS, Value.ACE);
        Card kingDiamonds = new Card(Suit.DIAMONDS, Value.KING);
        Card eightClubs = new Card(Suit.CLUBS, Value.EIGHT);
        player1.addCardToHand(aceSpades);
        player1.addCardToHand(aceClubs);
        player1.addCardToHand(aceDiamonds);
        player1.addCardToHand(kingDiamonds);
        player1.addCardToHand(eightClubs);
        assertEquals( 21, player1.getHandWorth() );
    }

    @Test
    public void playerIsBust() {
        Card kingDiamonds = new Card(Suit.DIAMONDS, Value.KING);
        Card kingClubs = new Card(Suit.CLUBS, Value.KING);
        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
        player1.addCardToHand(kingDiamonds);
        player1.addCardToHand(kingClubs);
        player1.addCardToHand(kingHearts);
        assertEquals( player1.getHandWorth(), 30 );
        assertEquals( player1.isBust(), true );
    }

    @Test
    public void dealerAlwaysWins() {

    }





}
