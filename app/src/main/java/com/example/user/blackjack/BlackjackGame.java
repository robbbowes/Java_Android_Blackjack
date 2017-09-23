package com.example.user.blackjack;

import java.util.ArrayList;

/**
 * Created by user on 23/09/2017.
 */

public class BlackjackGame implements CardGame {

    private ArrayList<Player> players;
    private Deck deck;

    public BlackjackGame(ArrayList<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    public ArrayList<Player> playersWithBlackjack() {

        ArrayList blackjackArray = new ArrayList<>();

        for ( Player player : players ) {
            if ( ( player.getHandWorth() == 21 ) && ( player.getHand().size() == 2 )) {
                blackjackArray.add(player);
            }
        }
        return blackjackArray;
    }

    public boolean dealerHasBlackjack(ArrayList<Player> players) {

        boolean dealerWins = false;

        for (Player player : players ) {
            if (player.isDealer()) {
                dealerWins = true;
            }
            else {
                dealerWins = false;
            }
        }
        return dealerWins;
    }

    public Player winner() {

        Player winner = players.get(0);

        for (Player player : players) {
            if ( (player.getHandWorth() > winner.getHandWorth() ) && !player.isBust() ) {
                winner = player;
            }
            else if ( player.isDealer() && player.getHandWorth() == winner.getHandWorth() && !player.isBust()){
                winner = player;
            }
        }
        return winner;
    }

}
