package com.example.user.blackjack;

/**
 * Created by user on 25/09/2017.
 */

public class BlackjackLogic {
    public void dealerBlackjack(Player dealerPlayer) {

        if ( ( dealerPlayer.getHandWorth() == 21 ) && ( dealerPlayer.getHand().size() == 2 )) {
            dealerPlayer.setBlackjack(true);
        }
    }

    public void playerBlackjack(Player player) {

        if ( ( player.getHandWorth() == 21 ) && ( player.getHand().size() == 2 )) {
            player.setBlackjack(true);
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
}
