package com.example.user.blackjack;

import java.util.ArrayList;

/**
 * Created by user on 23/09/2017.
 */

public class BlackjackGame implements CardGame {

    private ArrayList<Player> players;
    private Dealer dealer;
    private Deck deck;
    private NumberGenerating numberGenerator;

    public BlackjackGame(ArrayList<Player> players, Dealer dealer, Deck deck, NumberGenerating numberGenerator) {
        this.players = players;
        this.dealer = dealer;
        this.deck = deck;
        this.numberGenerator = numberGenerator;
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
