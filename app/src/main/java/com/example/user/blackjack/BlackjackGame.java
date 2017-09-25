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
        this.dealerPlayer = new Player("Dealer", true);
        this.player = new Player("Player", false);
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

//    public void dealerHasLessThan17() {
//        if (dealerPlayer.getHandWorth() < 17) {
//             dealACardToDealerPlayer();
//        }
//    }

    public void dealerWhileUnder17() {
        do {
            dealACardToDealerPlayer();
        } while (dealerPlayer.getHandWorth() < 17 );
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
        dealerWhileUnder17();
        if ( player.isBlackjack() && ( !dealerPlayer.isBlackjack() ) ) {
            Log.d("outcome", "player blackjack dealer not");
            return player;
        }
        else if( ( player.getHandWorth() > dealerPlayer.getHandWorth() ) && !player.isBust() ) {
            Log.d("outcome","player > dealer / player not bust");
            return player;
        }
        else if( !player.isBust() && dealerPlayer.isBust() ) {
            Log.d("outcome", "player not bust / dealer is");
            return player;
        }
        else {
            Log.d("outcome", "Other (dealerwin)");
            return dealerPlayer;
        }
    }



//    public String displayWinner() {
//        if ( decideWinner() == player ) {
//            return ""
//        }
//    }


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
