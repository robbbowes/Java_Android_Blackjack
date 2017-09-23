package com.example.user.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 22/09/2017.
 */

public class CardTest {

    Card card;

    @Before
    public void before() {
        card = new Card(Suit.SPADES, Value.ACE);
    }

    @Test
    public void canGetSuit() {
        assertEquals( Suit.SPADES, card.getSuit());
    }

    @Test
    public void canGetValue() {
        assertEquals( Value.ACE, card.getValue());
    }

    @Test
    public void aceIsHigh() {
        assertEquals( 13, card.getValueRanking());
    }



//    @Test
//    public void
}
