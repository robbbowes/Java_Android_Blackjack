package com.example.user.blackjack;

import org.junit.Before;

/**
 * Created by user on 22/09/2017.
 */

public class CanPlayTest {

    Player player1;
    Player player2;
    Dealer dealer;
    Deck deck;
    Card threeHearts;
    Card aceSpades;
    Card twoClubs;
    RandomNumberGenerator numberGenerator;
    FixedNumberGenerator fixedNumberGenerator;

    @Before
    public void before() {
        pl
        deck = new Deck();
        aceSpades = new Card(Suit.SPADES, Value.ACE);
        threeHearts = new Card(Suit.HEARTS, Value.THREE);
        twoClubs = new Card(Suit.CLUBS, Value.TWO);
        numberGenerator = new RandomNumberGenerator();
        fixedNumberGenerator = new FixedNumberGenerator();
    }


}
