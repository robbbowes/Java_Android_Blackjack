package com.example.user.blackjack;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public class Player {
    String name;
    ArrayList<Card> hand;
    int handWorth;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        this.handWorth = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public int numOfAces(ArrayList<Card> hand) {
        int aceCount = 0;
        for (Card card : hand ) {
            if (card.getValue() == Value.ACE) {
                aceCount++;
            }
        }
        return aceCount;
    }

    public int getHandWorth() {
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
            if (card.getValue() == Value.ACE) {
                handWorth += 11;
            } else {
                handWorth += 10;
            }
        }
        return handWorth;
    }




}
