package com.example.user.blackjack;

import java.util.ArrayList;

/**
 * Created by user on 23/09/2017.
 */

public class BlackjackGame {

    Player player;
    Player dealerPlayer;
    Dealer dealer;

    public BlackjackGame(Player player, Player dealerPlayer, Dealer dealer) {
        this.player = player;
        this.dealerPlayer = dealerPlayer;
        this.dealer = dealer;
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

    public Player decideWinner(Player player, Player dealerPlayer) {
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

//    public Player winner() {
//
//        Player winner = players.get(0);
//
//        for (Player player : players) {
//            if ( (player.getHandWorth() > winner.getHandWorth() ) && !player.isBust() ) {
//                winner = player;
//            }
//            else if ( player.isDealer() && player.getHandWorth() == winner.getHandWorth() && !player.isBust()){
//                winner = player;
//            }
//        }
//        return winner;
//    }

}
