package com.example.user.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/09/2017.
 */

public class DealerTest {

    Dealer dealer;
    Card threeHearts;
    Card aceSpades;
    Card twoClubs;
    RandomNumberGenerator numberGenerator;
    FixedNumberGenerator fixedNumberGenerator;
    Player player1;

    @Before
    public void before() {

        dealer = new Dealer();
        aceSpades = new Card(Suit.SPADES, Value.ACE);
        threeHearts = new Card(Suit.HEARTS, Value.THREE);
        twoClubs = new Card(Suit.CLUBS, Value.TWO);
        numberGenerator = new RandomNumberGenerator();
        fixedNumberGenerator = new FixedNumberGenerator();
        player1 = new Player("Danny", false);
    }

    @Test
    public void deckStartsEmpty() {
        assertEquals(0, dealer.getSize());
    }

    @Test
    public void canAddCard() {
        dealer.addCardToDeck(threeHearts);
        assertEquals(1, dealer.getDeck().size());
    }

    @Test
    public void canRemoveCard() {
        dealer.addCardToDeck(threeHearts);
        dealer.addCardToDeck(aceSpades);
        assertEquals(dealer.getDeck().size(), 2 );
        dealer.removeCard(threeHearts);
        assertEquals(dealer.getDeck().size(), 1);
    }

    @Test
    public void notRandomCard() {
        dealer.addCardToDeck(threeHearts);
        dealer.addCardToDeck(twoClubs);
        dealer.addCardToDeck(aceSpades);
        assertEquals( aceSpades, dealer.removeCardAtRandom(fixedNumberGenerator));
    }

    @Test
    public void deckHas52cards() {
        dealer.createDeck();
        assertEquals( 52, dealer.getDeck().size());
    }

    @Test
    public void randomCard() {
        dealer.addCardToDeck(aceSpades);
        assertEquals( aceSpades, dealer.removeCardAtRandom(numberGenerator));
    }

    @Test
    public void deckGetsSmallerAfterCardIsDealt() {
        dealer.createDeck();
        Card card = dealer.removeCardAtRandom(numberGenerator);
        player1.addCardToHand(card);
        assertEquals(51, dealer.getSize());
    }

}

