package com.example.user.blackjack;

import java.util.ArrayList;
import java.util.HashMap;

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

        HashMap<Value, Integer> values = new HashMap<>();
        values.put(Value.TWO, 2);
        values.put(Value.THREE, 3);
        values.put(Value.FOUR, 4);
        values.put(Value.FIVE, 5);
        values.put(Value.SIX, 6);
        values.put(Value.SEVEN, 7);
        values.put(Value.EIGHT, 8);
        values.put(Value.NINE, 9);
        values.put(Value.TEN, 10);
        values.put(Value.JACK, 10);
        values.put(Value.QUEEN, 10);
        values.put(Value.KING, 10);
        values.put(Value.ACE, 1);

        int handWorth = 0;
        boolean aceCounter = false;

        for (Card card : hand) {
            if(card.getValue() == Value.ACE){
                aceCounter = true;
            }
            handWorth += values.get(card.getValue());
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
