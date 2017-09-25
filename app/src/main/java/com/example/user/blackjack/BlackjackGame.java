package com.example.user.blackjack;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by user on 23/09/2017.
 */

public class BlackjackGame {

    public Player getPlayer() {
        return player;
    }

    public Player getDealerPlayer() {
        return dealerPlayer;
    }

    Player player;
    Player dealerPlayer;
    Dealer dealer;
    NumberGenerating randomNumberGenerator;

    public BlackjackGame(NumberGenerating numberGenerator) {
        this.player = new Player("Bruno", true);
        this.dealerPlayer = new Player("Nicky", false);
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

    public void dealACardToPlayer() {
        Card additionalCard = dealer.removeCardAtRandom(randomNumberGenerator);
        System.out.println(additionalCard.getValue());
        player.addCardToHand(additionalCard);
    }

    public void dealACardToDealerPlayer() {
        Card additionalCard = dealer.removeCardAtRandom(randomNumberGenerator);
        System.out.println("Dealing card to dealer player" + additionalCard.getValue());
        System.out.println("Dealing card to dealer player size before" + dealerPlayer.getHand().size());
        dealerPlayer.addCardToHand(additionalCard);
        System.out.println("Dealing card to dealer player size" + dealerPlayer.getHand().size());
        System.out.println("Dealing card to dealer player worth" + dealerPlayer.getHandWorth());

    }

    public void dealerHasLessThan17() {
        System.out.println("Checking if should deal card");
        System.out.println("Dealing less than 17 " + dealerPlayer.getHand().size());
        if (dealerPlayer.getHandWorth() < 17) {
             System.out.println("Dealing card to player" + dealerPlayer.getHandWorth());
             System.out.println("Dealing less than 17 inside " + dealerPlayer.getHand().size());
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

    public Player decideWinner() {
        if ( player.isBlackjack() && ( !dealerPlayer.isBlackjack() ) ) {
            return player;
        }
        else if( ( player.getHandWorth() > dealerPlayer.getHandWorth() ) && !player.isBust() ) {
            return player;
        }
        else if( !player.isBust() && dealerPlayer.isBust() ) {
            return player;
        }
        else {
            return dealerPlayer;
        }
    }


//    public void dealerBlackjack(Player dealerPlayer) {
//
//        if ( ( dealerPlayer.getHandWorth() == 21 ) && ( dealerPlayer.getHand().size() == 2 )) {
//            dealerPlayer.setBlackjack(true);
//        }
//    }
//
//    public void playerBlackjack(Player player) {
//
//        if ( ( player.getHandWorth() == 21 ) && ( player.getHand().size() == 2 )) {
//            player.setBlackjack(true);
//        }
//    }
//
//    public Player decideWinner(Player player, Player dealerPlayer) {
////        dealerHasLessThan17(dealerPlayer);
////        dealerHasLessThan17(dealerPlayer);
////        dealerHasLessThan17(dealerPlayer);
//        if ( player.isBlackjack() && ( !dealerPlayer.isBlackjack() ) ) {
//            return player;
//        }
//        else if( ( player.getHandWorth() > dealerPlayer.getHandWorth() ) && !player.isBust() ) {
//            return player;
//        }
//        else if( !player.isBust() && dealerPlayer.isBust() ) {
//            return player;
//        }
//        else {
//            return dealerPlayer;
//        }
//    }





//    boolean didTheDealerWin() {
//        if (dealerPlayer.getHandWorth() >= player.getHandWorth() ) {
//            return true;
//        } else if ( dealerPlayer.isBlackjack() ) {
//            return true;
//        } else if ( !dealerPlayer.isBust() && player.isBust() ) {
//            return true;
//        } else {
//            return false;
//        }
//    }

//    boolean didTheDealerWin() {
//        if ( player.isBlackjack() && ( !dealerPlayer.isBlackjack() ) ) {
//            return false;
//        }
//        else if( ( player.getHandWorth() > dealerPlayer.getHandWorth() ) && !player.isBust() ) {
//            return false;
//        }
//        else if( !player.isBust() && dealerPlayer.isBust() ) {
//            return false;
//        }
//        else {
//            return true;
//        }
//    }

//    String getResult() {
//        dealerHasLessTHan17();
//        dealerHasLessTHan17();
//        dealerHasLessTHan17();
//        if (didTheDealerWin() != false) {
//            return "The dealer always wins!";
//        } else {
//            return "You managed to win!";
//        }
//    }

}
