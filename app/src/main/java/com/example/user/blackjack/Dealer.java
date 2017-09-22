package com.example.user.blackjack;

import java.util.ArrayList;

/**
 * Created by user on 22/09/2017.
 */

public class Dealer {

    Deck deck;
    NumberGenerating numberGenerator;

    public Dealer(Deck deck, NumberGenerating numberGenerator) {
        this.deck = deck;
        this.numberGenerator = numberGenerator;
    }

    public void dealCard(Player player) {
        Card randomCard = deck.removeCardAtRandom(numberGenerator);
        player.addCardToHand(randomCard);
    }

}
