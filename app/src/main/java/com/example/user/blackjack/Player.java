package com.example.user.blackjack;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public class Player implements CanPlay {
    public String name;
    ArrayList<Card> hand;
    public int handWorth;

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

//    public int getHandWorth() {
//        return handWorth;
//    }

    public Player(String name, ArrayList<Card> hand, int handWorth) {
        this.name = name;
        this.hand = hand;
        this.handWorth = handWorth;
    }

//    public void assessHandWorth


}
