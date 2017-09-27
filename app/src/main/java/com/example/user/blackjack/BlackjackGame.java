package com.example.user.blackjack;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by user on 23/09/2017.
 */

public class BlackjackGame {

    Player player;
    Player dealerPlayer;
    Dealer dealer;
    NumberGenerating randomNumberGenerator;

    public BlackjackGame(NumberGenerating numberGenerator) {
        this.player = new Player("Player", false);
        this.dealerPlayer = new Player("Dealer", true);
        this.dealer = new Dealer();
        dealer.createDeck();
        this.randomNumberGenerator = numberGenerator;
    }

    public BlackjackGame() {
        this( new RandomNumberGenerator() );
    }


    public void dealToBoth() {
        Card firstPlayerCard = dealer.removeCardAtRandom(randomNumberGenerator);
        player.addCardToHand(firstPlayerCard);

        Card firstDealerCard = dealer.removeCardAtRandom(randomNumberGenerator);
        dealerPlayer.addCardToHand(firstDealerCard);

        Card secondPlayerCard = dealer.removeCardAtRandom(randomNumberGenerator);
        player.addCardToHand(secondPlayerCard);

        Card secondDealerCard = dealer.removeCardAtRandom(randomNumberGenerator);
        dealerPlayer.addCardToHand(secondDealerCard);
    }

    public Card dealACardToPlayer() {
        Card additionalCard = dealer.removeCardAtRandom(randomNumberGenerator);
        player.addCardToHand(additionalCard);
        return additionalCard;
    }

    public Card dealACardToDealerPlayer() {
        Card additionalCard = dealer.removeCardAtRandom(randomNumberGenerator);
        dealerPlayer.addCardToHand(additionalCard);
        return additionalCard;
    }

    public void dealerWhileUnder17() {
        while ( dealerPlayer.getHandWorth() < 17 ) {
            dealACardToDealerPlayer();
        }
    }

    public void dealerBlackjack() {

        if ( ( dealerPlayer.getHandWorth() == 21 ) && ( dealerPlayer.getHand().size() == 2 )) {
            dealerPlayer.setBlackjack(true);
        }
    }

    public void playerBlackjack() {

        if ( ( player.getHandWorth() == 21 ) && ( player.getHand().size() == 2 )) {
            player.setBlackjack(true);
        }
    }

    public String decideWinnerString() {
        dealerWhileUnder17();
        player.isBust();
        dealerPlayer.isBust();
        playerBlackjack();
        dealerBlackjack();
        if ( player.isBlackjack() && ( !dealerPlayer.isBlackjack() ) ) {
            player.setWinner(true);
            return "OMG U G07 BL4KKJ4KK!!! L337!! H4XX0R!!!";
        }
        else if( ( player.getHandWorth() > dealerPlayer.getHandWorth() ) && !player.isBust() ) {
            player.setWinner(true);
            return "You won!";
        }
        else if( !player.isBust() && dealerPlayer.isBust() ) {
            player.setWinner(true);
            return "Lol, the dealer is bust!";
        }
        else if( player.isBust() && dealerPlayer.isBust() ) {
            return "Nobody won this time around!";
        }
        else {
            dealerPlayer.setWinner(true);
            return "The dealer won!  You suck lol";
        }
    }

}
