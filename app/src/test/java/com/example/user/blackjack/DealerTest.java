package com.example.user.blackjack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 22/09/2017.
 */

public class DealerTest {

    Deck deck;
    Card threeHearts;
    Card aceSpades;
    Card twoClubs;
    Dealer dealer;
    RandomNumberGenerator numberGenerator;
    FixedNumberGenerator fixedNumberGenerator;
    Player player1;


    @Before
    public void before() {

        deck = new Deck();
        deck.createDeck();
        aceSpades = new Card(Suit.SPADES, Value.ACE);
        threeHearts = new Card(Suit.HEARTS, Value.THREE);
        twoClubs = new Card(Suit.CLUBS, Value.TWO);
        fixedNumberGenerator = new FixedNumberGenerator();
        player1 = new Player("Daniel");
        dealer = new Dealer(deck, fixedNumberGenerator);
    }

    @Test
    public void dealerCanDealACard() {
        dealer.dealCard(player1);
        assertEquals( 1, player1.getHand().size() );
    }

}
