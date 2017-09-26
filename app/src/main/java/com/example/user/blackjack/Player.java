package com.example.user.blackjack;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public class Player {
    private String name;
    private ArrayList<Card> hand;
    boolean isDealer;
    boolean winner;
    private boolean blackjack;

    Player(String name, boolean isDealer) {
        this.name = name;
        hand = new ArrayList<>();
        this.isDealer = isDealer;
        this.winner = false;
        this.blackjack = false;
    }

    String getName() {
        return name;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    ArrayList<Card> getHand() {
        return hand;
    }

    void addCardToHand(Card card) {
        hand.add(card);
    }

    int numOfAces(ArrayList<Card> hand) {
        int aceCount = 0;
        for (Card card : hand ) {
            if (card.getValue() == Value.ACE) {
                aceCount++;
            }
        }
        return aceCount;
    }

    int getHandWorth() {

        int handWorth = 0;
        boolean aceCounter = false;

        for (Card card : hand) {
            if (card.getValue() == Value.TWO) {
                handWorth += 2;
            }
            if (card.getValue() == Value.THREE) {
                handWorth += 3;
            }
            if (card.getValue() == Value.FOUR) {
                handWorth += 4;
            }
            if (card.getValue() == Value.FIVE) {
                handWorth += 5;
            }
            if (card.getValue() == Value.SIX) {
                handWorth += 6;
            }
            if (card.getValue() == Value.SEVEN) {
                handWorth += 7;
            }
            if (card.getValue() == Value.EIGHT) {
                handWorth += 8;
            }
            if (card.getValue() == Value.NINE) {
                handWorth += 9;
            }
            if (card.getValue() == Value.TEN) {
                handWorth += 10;
            }
            if (card.getValue() == Value.JACK) {
                handWorth += 10;
            }
            if (card.getValue() == Value.QUEEN) {
                handWorth += 10;
            }
            if (card.getValue() == Value.KING) {
                handWorth += 10;
            }
            if (card.getValue() == Value.ACE) {
                handWorth++;
                aceCounter = true;
            }
        }
        if (aceCounter && ((handWorth + 10) < 22) ) {
            return handWorth + 10;
        } else {
            return handWorth;
        }
    }

    boolean isBust() {
        if (getHandWorth() >= 22) {
            return true;
        }
        else {
            return false;
        }
    }







}
