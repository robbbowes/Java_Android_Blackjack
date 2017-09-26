package com.example.user.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/09/2017.
 */

public class CardTest {

    Card aceSpades;
    Card jackClubs;
    Card queenDiamonds;
    Card tenHearts;


    @Before
    public void before() {
        aceSpades = new Card(Suit.SPADES, Value.ACE);
        jackClubs = new Card(Suit.CLUBS, Value.JACK);
        queenDiamonds = new Card(Suit.DIAMONDS, Value.QUEEN);
        tenHearts = new Card(Suit.HEARTS, Value.TEN);

    }

    @Test
    public void canGetSuit() {
        assertEquals( Suit.SPADES, aceSpades.getSuit());
    }

    @Test
    public void canGetValue() {
        assertEquals( Value.ACE, aceSpades.getValue());
    }

    @Test
    public void aceIsHigh() {
        assertEquals( 13, aceSpades.getValueRanking());
    }

    @Test
    public void canGetSuitasString() {
        assertEquals( "clubs", jackClubs.getSuitString());
        assertEquals( "hearts", tenHearts.getSuitString());
        assertEquals( "spades", aceSpades.getSuitString());
        assertEquals( "diamonds", queenDiamonds.getSuitString());
    }

    @Test
    public void canGetValueAsString() {
        assertEquals( "jack", jackClubs.getValueString());
        assertEquals( "ten", tenHearts.getValueString());
        assertEquals( "ace", aceSpades.getValueString());
        assertEquals( "queen", queenDiamonds.getValueString());
    }





}
