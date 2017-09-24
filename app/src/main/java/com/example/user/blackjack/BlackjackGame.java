package com.example.user.blackjack;

import java.util.ArrayList;

/**
 * Created by user on 23/09/2017.
 */

public class BlackjackGame {

    Player player;
    Player dealerPlayer;
    Dealer dealer;
    RandomNumberGenerator randomNumberGenerator;

    public BlackjackGame() {
        this.player = new Player("Bruno", true);
        this.dealerPlayer = new Player("Nicky", false);
        this.dealer = new Dealer();
        dealer.createDeck();
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void playerBlackjack(Player player) {

         if ( ( player.getHandWorth() == 21 ) && ( player.getHand().size() == 2 )) {
             player.setBlackjack(true);
         }
    }

    public void dealerBlackjack(Player dealerPlayer) {

        if ( ( dealerPlayer.getHandWorth() == 21 ) && ( dealerPlayer.getHand().size() == 2 )) {
            dealerPlayer.setBlackjack(true);
        }
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
        dealerPlayer.addCardToHand(additionalCard);
    }

    public void dealerHasLessTHan17() {
        if (dealerPlayer.getHandWorth() < 17) {
             dealACardToDealerPlayer();
        }
    }

    public Player decideWinner(Player player, Player dealerPlayer) {
        dealerHasLessTHan17();
        dealerHasLessTHan17();
        dealerHasLessTHan17();
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
