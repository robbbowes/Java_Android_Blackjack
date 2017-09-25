package com.example.user.blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 23/09/2017.
 */

public class BlackJackLogicTest {

    Player player;
    Player dealerPlayer;
//    Dealer dealer;
//    NumberGenerating numberGenerator;
    BlackjackLogic blackjackLogic;

    @Before
    public void before() {

        player = new Player("Player 1", false);
        dealerPlayer = new Player("Dealer", true);
//        numberGenerator = new FixedNumberGenerator();
//        dealer = new Dealer();
//        dealer.createDeck();
        blackjackLogic = new BlackjackLogic();
    }

    @Test
    public void aceWillNotCountAsHighIfOver12() {
        Card aceSpades = new Card(Suit.SPADES, Value.ACE);
        Card aceClubs = new Card(Suit.CLUBS, Value.ACE);
        Card aceDiamonds = new Card(Suit.DIAMONDS, Value.ACE);
        Card kingDiamonds = new Card(Suit.DIAMONDS, Value.KING);
        Card eightClubs = new Card(Suit.CLUBS, Value.EIGHT);
        player.addCardToHand(aceSpades);
//        player.addCardToHand(aceClubs);
//        player.addCardToHand(aceDiamonds);
        player.addCardToHand(kingDiamonds);
//        player.addCardToHand(eightClubs);
        assertEquals( 21, player.getHandWorth() );
    }

    @Test
    public void dealerAlwaysWinsWithSameResult() {
        Card kingDiamonds = new Card(Suit.DIAMONDS, Value.KING);
        Card eightClubs = new Card(Suit.CLUBS, Value.EIGHT);
        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
        player.addCardToHand(kingDiamonds);
        player.addCardToHand(eightClubs);
        dealerPlayer.addCardToHand(kingHearts);
        dealerPlayer.addCardToHand(eightSpades);
        assertEquals( player.getHandWorth(), 18 );
        assertEquals( dealerPlayer.getHandWorth(), 18 );
        Player winner = blackjackLogic.decideWinner(player, dealerPlayer);
        assertEquals( winner, dealerPlayer );
    }

    @Test
    public void playerWinsWithBlackjack() {
        Card kingDiamonds = new Card(Suit.DIAMONDS, Value.KING);
        Card aceClubs = new Card(Suit.CLUBS, Value.ACE);
        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
        player.addCardToHand(kingDiamonds);
        player.addCardToHand(aceClubs);
        dealerPlayer.addCardToHand(kingHearts);
        dealerPlayer.addCardToHand(eightSpades);
        blackjackLogic.playerBlackjack(player);
        blackjackLogic.dealerBlackjack(dealerPlayer);
        assertEquals( true, player.isBlackjack() );
        Player winner = blackjackLogic.decideWinner(dealerPlayer, player);
        assertEquals( winner, player);
    }
//
    @Test
    public void dealerPlayerWinsWithBlackjack() {
        Card kingDiamonds = new Card(Suit.DIAMONDS, Value.KING);
        Card aceClubs = new Card(Suit.CLUBS, Value.ACE);
        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
        dealerPlayer.addCardToHand(kingDiamonds);
        dealerPlayer.addCardToHand(aceClubs);
        player.addCardToHand(kingHearts);
        player.addCardToHand(eightSpades);
        blackjackLogic.playerBlackjack(player);
        blackjackLogic.dealerBlackjack(dealerPlayer);
        assertEquals( true, dealerPlayer.isBlackjack() );
        assertEquals( false, player.isBlackjack() );
        Player winner = blackjackLogic.decideWinner(dealerPlayer, player);
        assertEquals( winner, dealerPlayer);
    }
//
    @Test
    public void playerWinsNormally() {
        Card tenDiamonds = new Card(Suit.DIAMONDS, Value.TEN);
        Card tenClubs = new Card(Suit.CLUBS, Value.TEN);
        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
        player.addCardToHand(tenDiamonds);
        player.addCardToHand(tenClubs);
        dealerPlayer.addCardToHand(kingHearts);
        dealerPlayer.addCardToHand(eightSpades);
        blackjackLogic.playerBlackjack(player);
        blackjackLogic.dealerBlackjack(dealerPlayer);
        assertEquals( false, player.isBlackjack() );
        assertEquals( false, dealerPlayer.isBlackjack());
        Player winner = blackjackLogic.decideWinner(dealerPlayer, player);
        assertEquals( winner, player);
    }
//
    @Test
    public void dealerWinsNormally() {
        Card tenDiamonds = new Card(Suit.DIAMONDS, Value.TEN);
        Card tenClubs = new Card(Suit.CLUBS, Value.TEN);
        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
        dealerPlayer.addCardToHand(tenDiamonds);
        dealerPlayer.addCardToHand(tenClubs);
        player.addCardToHand(kingHearts);
        player.addCardToHand(eightSpades);
        blackjackLogic.playerBlackjack(player);
        blackjackLogic.dealerBlackjack(dealerPlayer);
        assertEquals( false, player.isBlackjack() );
        assertEquals( false, dealerPlayer.isBlackjack());
        Player winner = blackjackLogic.decideWinner(dealerPlayer, player);
        assertEquals( winner, dealerPlayer);
    }
//
//    @Test
//    public void dealToBothWorks() {
//        blackjackGame.dealToBoth();
//        assertEquals( 2, blackjackGame.player.getHand().size() );
//        assertEquals( 2, blackjackGame.dealerPlayer.getHand().size() );
//    }
//
//    @Test
//    public void dealToPlayerWork() {
//        blackjackGame.dealToBoth();
//        assertEquals( 2, blackjackGame.player.getHand().size() );
//        assertEquals( 2, blackjackGame.dealerPlayer.getHand().size() );
//        blackjackGame.dealACardToPlayer();
//        assertEquals( 3, blackjackGame.player.getHand().size());
//    }
//
//        @Test
//    public void dealerCannotHaveLessThan17() {
//        Card threeDiamonds = new Card(Suit.DIAMONDS, Value.THREE);
//        Card fourClubs = new Card(Suit.CLUBS, Value.FOUR);
//        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
//        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
//        dealerPlayer.addCardToHand(threeDiamonds);
//        dealerPlayer.addCardToHand(fourClubs);
//        player.addCardToHand(kingHearts);
//        player.addCardToHand(eightSpades);
//        assertEquals( dealerPlayer.getHandWorth(), 7);
//        blackjackGame.dealerHasLessThan17(dealerPlayer);
////        blackjackGame.decideWinner(player, dealerPlayer);
//        assertEquals( 17, dealerPlayer.getHandWorth());
//    }


}
