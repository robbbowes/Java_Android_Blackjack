package com.example.user.blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 23/09/2017.
 */

public class BlackjackGameTest {

    Dealer dealer;
    NumberGenerating numberGenerator;
    BlackjackGame blackjackGame;

    @Before
    public void before() {
        numberGenerator = new FixedNumberGenerator();
        dealer = new Dealer();
        dealer.createDeck();
        blackjackGame = new BlackjackGame();
    }
//
    @Test
    public void dealToBothWorks() {
        blackjackGame.dealToBoth();
        assertEquals( 2, blackjackGame.player.getHand().size() );
        assertEquals( 2, blackjackGame.dealerPlayer.getHand().size() );
    }
//
    @Test
    public void dealToPlayerWork() {
        blackjackGame.dealToBoth();
        assertEquals( 2, blackjackGame.player.getHand().size() );
        assertEquals( 2, blackjackGame.dealerPlayer.getHand().size() );
        blackjackGame.dealACardToPlayer();
        assertEquals( 3, blackjackGame.player.getHand().size());
    }
//
    @Test
    public void dealerCannotHaveLessThan17() {
        Card threeDiamonds = new Card(Suit.DIAMONDS, Value.THREE);
        Card fourClubs = new Card(Suit.CLUBS, Value.FOUR);
        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
        blackjackGame.dealerPlayer.addCardToHand(threeDiamonds);
        blackjackGame.dealerPlayer.addCardToHand(fourClubs);
        blackjackGame.player.addCardToHand(kingHearts);
        blackjackGame.player.addCardToHand(eightSpades);
        assertEquals( blackjackGame.dealerPlayer.getHandWorth(), 7);
        blackjackGame.dealerHasLessThan17();
//        blackjackGame.decideWinner(player, dealerPlayer);
        assertEquals( 17, blackjackGame.dealerPlayer.getHandWorth());
    }


}

