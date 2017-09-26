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
        blackjackGame = new BlackjackGame(numberGenerator);
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
        blackjackGame.dealerWhileUnder17();
        //fixed dealer will be dealing an ace(Top card)
        assertEquals( 18, blackjackGame.player.getHandWorth());
    }

    @Test
    public void aceWillNotCountAsHighIfOver12() {
        Card aceSpades = new Card(Suit.SPADES, Value.ACE);
        Card aceClubs = new Card(Suit.CLUBS, Value.ACE);
        Card aceDiamonds = new Card(Suit.DIAMONDS, Value.ACE);
        Card kingDiamonds = new Card(Suit.DIAMONDS, Value.KING);
        Card eightClubs = new Card(Suit.CLUBS, Value.EIGHT);
        blackjackGame.player.addCardToHand(aceSpades);
//        player.addCardToHand(aceClubs);
//        player.addCardToHand(aceDiamonds);
        blackjackGame.player.addCardToHand(kingDiamonds);
//        player.addCardToHand(eightClubs);
        assertEquals( 21,  blackjackGame.player.getHandWorth() );
    }

    @Test
    public void dealerAlwaysWinsWithSameResult() {
        Card kingDiamonds = new Card(Suit.DIAMONDS, Value.KING);
        Card eightClubs = new Card(Suit.CLUBS, Value.EIGHT);
        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
        blackjackGame.player.addCardToHand(kingDiamonds);
        blackjackGame.player.addCardToHand(eightClubs);
        blackjackGame.dealerPlayer.addCardToHand(kingHearts);
        blackjackGame.dealerPlayer.addCardToHand(eightSpades);
        assertEquals(  blackjackGame.player.getHandWorth(), 18 );
        assertEquals(  blackjackGame.dealerPlayer.getHandWorth(), 18 );
        blackjackGame.decideWinnerString();
        assertEquals( true, blackjackGame.dealerPlayer.winner );
    }

    @Test
    public void playerWinsWithBlackjack() {
        Card kingDiamonds = new Card(Suit.DIAMONDS, Value.KING);
        Card aceClubs = new Card(Suit.CLUBS, Value.ACE);
        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
        blackjackGame.player.addCardToHand(kingDiamonds);
        blackjackGame.player.addCardToHand(aceClubs);
        blackjackGame.dealerPlayer.addCardToHand(kingHearts);
        blackjackGame.dealerPlayer.addCardToHand(eightSpades);
        blackjackGame.playerBlackjack();
        blackjackGame.dealerBlackjack();
        assertEquals( true, blackjackGame.player.isBlackjack() );
        blackjackGame.decideWinnerString();
        assertEquals( true, blackjackGame.player.winner);
    }
    //
    @Test
    public void dealerPlayerWinsWithBlackjack() {
        Card kingDiamonds = new Card(Suit.DIAMONDS, Value.KING);
        Card aceClubs = new Card(Suit.CLUBS, Value.ACE);
        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
        blackjackGame.dealerPlayer.addCardToHand(kingDiamonds);
        blackjackGame.dealerPlayer.addCardToHand(aceClubs);
        blackjackGame.player.addCardToHand(kingHearts);
        blackjackGame.player.addCardToHand(eightSpades);
        blackjackGame.playerBlackjack();
        blackjackGame.dealerBlackjack();
        assertEquals( true, blackjackGame.dealerPlayer.isBlackjack() );
        assertEquals( false, blackjackGame.player.isBlackjack() );
        blackjackGame.decideWinnerString();
        assertEquals( true , blackjackGame.dealerPlayer.winner);
    }
    //
    @Test
    public void playerWinsNormally() {
        Card tenDiamonds = new Card(Suit.DIAMONDS, Value.TEN);
        Card tenClubs = new Card(Suit.CLUBS, Value.TEN);
        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
        blackjackGame.player.addCardToHand(tenDiamonds);
        blackjackGame.player.addCardToHand(tenClubs);
        blackjackGame.dealerPlayer.addCardToHand(kingHearts);
        blackjackGame.dealerPlayer.addCardToHand(eightSpades);
        blackjackGame.playerBlackjack();
        blackjackGame.dealerBlackjack();
        assertEquals( false, blackjackGame.player.isBlackjack() );
        assertEquals( false, blackjackGame.dealerPlayer.isBlackjack());
        blackjackGame.decideWinnerString();
        assertEquals( true, blackjackGame.player.winner);
    }
    //
    @Test
    public void dealerWinsNormally() {
        Card tenDiamonds = new Card(Suit.DIAMONDS, Value.TEN);
        Card tenClubs = new Card(Suit.CLUBS, Value.TEN);
        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
        blackjackGame.dealerPlayer.addCardToHand(tenDiamonds);
        blackjackGame.dealerPlayer.addCardToHand(tenClubs);
        blackjackGame.player.addCardToHand(kingHearts);
        blackjackGame.player.addCardToHand(eightSpades);
        blackjackGame.playerBlackjack();
        blackjackGame.dealerBlackjack();
        assertEquals( false, blackjackGame.player.isBlackjack() );
        assertEquals( false, blackjackGame.dealerPlayer.isBlackjack());
        blackjackGame.decideWinnerString();
        assertEquals( true, blackjackGame.dealerPlayer.winner);
    }


}

