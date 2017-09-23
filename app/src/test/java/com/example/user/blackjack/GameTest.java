package com.example.user.blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 23/09/2017.
 */

public class GameTest {

    Player player;
    Player dealerPlayer;
    Deck deck;
    NumberGenerating numberGenerator;
    ArrayList<Player> blackjackPlayers;

    @Before
    public void before() {

        player = new Player("Robb", false);
        dealerPlayer = new Player("Dealer", true);
        blackjackPlayers = new ArrayList<>();
        blackjackPlayers.add(player);
        blackjackPlayers.add(dealerPlayer);
        deck = new Deck();
        deck.createDeck();
        numberGenerator = new FixedNumberGenerator();
//        blackjackGame = new BlackjackGame( blackjackPlayers,  )
    }

    @Test
    public void aceWillNotCountAsHighIfOver12() {
        Card aceSpades = new Card(Suit.SPADES, Value.ACE);
        Card aceClubs = new Card(Suit.CLUBS, Value.ACE);
        Card aceDiamonds = new Card(Suit.DIAMONDS, Value.ACE);
        Card kingDiamonds = new Card(Suit.DIAMONDS, Value.KING);
        Card eightClubs = new Card(Suit.CLUBS, Value.EIGHT);
        player.addCardToHand(aceSpades);
        player.addCardToHand(aceClubs);
        player.addCardToHand(aceDiamonds);
        player.addCardToHand(kingDiamonds);
        player.addCardToHand(eightClubs);
        assertEquals( 21, player.getHandWorth() );
    }

//    @Test
//    public void dealerAlwaysWins() {
//        Card kingDiamonds = new Card(Suit.DIAMONDS, Value.KING);
//        Card eightClubs = new Card(Suit.CLUBS, Value.EIGHT);
//        Card kingHearts = new Card(Suit.HEARTS, Value.KING);
//        Card eightSpades = new Card(Suit.SPADES, Value.EIGHT);
//        player.addCardToHand(kingDiamonds);
//        player.addCardToHand(eightClubs);
//        dealerPlayer.addCardToHand(kingHearts);
//        dealerPlayer.addCardToHand(eightSpades);
//        assertEquals( player.getHandWorth(), 18 );
//        assertEquals( dealerPlayer.getHandWorth(), 18 );
//        assertEquals( bl, );

//    }
}
