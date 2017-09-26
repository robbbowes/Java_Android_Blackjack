package com.example.user.blackjack;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class BlackjackLauncherActivity extends AppCompatActivity {

    BlackjackGame blackjackGame;

    Button twist_button;
    Button stick_button;

    TextView playerScore;
    TextView dealerScore;
    TextView winnerDisplay;

//    CARDS

//    PLAYER
    ImageView firstSuitImage;
    TextView firstCardRank;
    ImageView secondSuitImage;
    TextView secondCardRank;

//    DEALER
    ImageView dealerFirstSuitImage;
    TextView dealerFirstCardRank;
    ImageView dealerSecondSuitImage;
    TextView dealerSecondCardRank;

//    ADDITIONAL CARDS

//    PLAYER
    TextView third_card;
    TextView fourth_card;
    TextView fifth_card;

//    DEALER





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_launcher);

//        SET UP GAME

        blackjackGame = new BlackjackGame();
        blackjackGame.dealToBoth();
        Log.d("Player first:", blackjackGame.player.getHand().get(0).getValueString() + blackjackGame.player.getHand().get(0).getSuit().toString());
        Log.d("Player second:", blackjackGame.player.getHand().get(1).getValueString() + blackjackGame.player.getHand().get(1).getSuit().toString());

//        CREATE AND ADD PICS TO FIRST AND SECOND CARDS BASED ON WHAT PLAYER HAS IN HAND

        HashMap<Value, String> rank = new HashMap<>();
        rank.put(Value.TWO, "2");
        rank.put(Value.THREE, "3");
        rank.put(Value.FOUR, "4");
        rank.put(Value.FIVE, "5");
        rank.put(Value.SIX, "6");
        rank.put(Value.SEVEN, "7");
        rank.put(Value.EIGHT, "8");
        rank.put(Value.NINE, "9");
        rank.put(Value.TEN, "10");
        rank.put(Value.JACK, "J");
        rank.put(Value.QUEEN, "Q");
        rank.put(Value.KING, "K");
        rank.put(Value.ACE, "A");

        firstSuitImage = (ImageView) findViewById(R.id.first_suit_image);
        String firstCardSuit = blackjackGame.player.getHand().get(0).getSuitString();
        int firstCardSuitId = getResources().getIdentifier(firstCardSuit, "drawable", getPackageName());
        firstSuitImage.setImageResource(firstCardSuitId);

        String firstValueString = rank.get(blackjackGame.player.getHand().get(0).getValue());
        firstCardRank = (TextView) findViewById(R.id.first_card_rank);
        firstCardRank.setText(firstValueString);

        secondSuitImage = (ImageView) findViewById(R.id.second_suit_image);
        String secondCardSuit = blackjackGame.player.getHand().get(1).getSuitString();
        int secondCardSuitId = getResources().getIdentifier(secondCardSuit, "drawable", getPackageName());
        secondSuitImage.setImageResource(secondCardSuitId);

        String secondValueString = rank.get(blackjackGame.player.getHand().get(1).getValue());
        secondCardRank = (TextView) findViewById(R.id.second_card_rank);
        secondCardRank.setText(secondValueString);

        dealerSecondSuitImage = (ImageView) findViewById(R.id.dealer_second_suit);
        String dealerSecondSuit = blackjackGame.dealerPlayer.getHand().get(1).getSuitString();
        int dealerSecondCardSuitId = getResources().getIdentifier(dealerSecondSuit, "drawable", getPackageName());
        dealerSecondSuitImage.setImageResource(dealerSecondCardSuitId);

        String dealerSecondValueString = rank.get(blackjackGame.dealerPlayer.getHand().get(1).getValue());
        dealerSecondCardRank = (TextView) findViewById(R.id.dealer_second_rank);
        dealerSecondCardRank.setText(dealerSecondValueString);



//        CREATE BOX FOR PLAYER SCORE

        String currentPlayerScore = "" + blackjackGame.player.getHandWorth();

//        String dealerFirstCard = blackjackGame.dealerPlayer.getHand().get(0).getValue().toString();
//        String dealerSecondCard = blackjackGame.dealerPlayer.getHand().get(1).getValue().toString();
        playerScore = (TextView) findViewById((R.id.player_score));
        playerScore.setText(currentPlayerScore);

        Log.i("Dealer first card", blackjackGame.dealerPlayer.getHand().get(0).getValue().toString() + blackjackGame.dealerPlayer.getHand().get(0).getSuit().toString());
        Log.i("Dealer second card", blackjackGame.dealerPlayer.getHand().get(1).getValue().toString() + blackjackGame.dealerPlayer.getHand().get(1).getSuit().toString());


//        CREATE BUTTONS FOR STICK AND TWIST AS WELL AS

        twist_button = (Button) findViewById(R.id.twist_button);
        stick_button = (Button) findViewById(R.id.stick_button);
        third_card = (TextView) findViewById(R.id.third_card);
        winnerDisplay = (TextView) findViewById(R.id.winner_display);
    }



    public void onClickNewGame(View button) {

        Intent intent = new Intent(this, BlackjackLauncherActivity.class);
        startActivity(intent);
        finish();

    }



    public void onClickTwist(View button) {

        Log.i("Test", "Twist button clicked");
        Log.i("Before", "" + blackjackGame.player.getHandWorth());
        Log.d("Player first:", blackjackGame.player.getHand().get(0).getValueString() + blackjackGame.player.getHand().get(0).getSuit().toString());
        Log.d("Player second:", blackjackGame.player.getHand().get(1).getValueString() + blackjackGame.player.getHand().get(1).getSuit().toString());

        Card dealtCard = blackjackGame.dealACardToPlayer();

        String dealtCardValue = dealtCard.getValue().toString().toLowerCase();
        String dealthCardSuit = dealtCard.getSuit().toString().toLowerCase();

        Toast.makeText(this, "You just received the " + dealtCardValue + " of "
                + dealthCardSuit + "!", Toast.LENGTH_SHORT).show();

        blackjackGame.player.getHandWorth();
        Log.i("After", "" + blackjackGame.player.getHandWorth());

        String playerscore = "" + blackjackGame.player.getHandWorth();
        playerScore = (TextView) findViewById((R.id.player_score));
        playerScore.setText(playerscore);

        if (blackjackGame.player.getHand().size() > 2 ) {

            String playerThirdCardSuit = "" + blackjackGame.player.getHand().get(2).getSuitString();
            String playerThirdCardRank = "" + blackjackGame.player.getHand().get(2).getValueString();
            third_card = (TextView) findViewById(R.id.third_card);
            third_card.setText("3rd Card: The " + playerThirdCardRank + " of " + playerThirdCardSuit);
            Log.d("Player third:", blackjackGame.player.getHand().get(2).getValueString());

        }

        if (blackjackGame.player.getHand().size() > 3 ) {

            String playerFourthCardSuit = "" + blackjackGame.player.getHand().get(3).getSuitString();
            String playerFourthCardRank = "" + blackjackGame.player.getHand().get(3).getValueString();
            fourth_card = (TextView) findViewById(R.id.fourth_card);
            fourth_card.setText("4th Card: The " + playerFourthCardRank + " of " + playerFourthCardSuit);
            Log.d("Player fourth:", blackjackGame.player.getHand().get(3).getValueString());

        }

        if (blackjackGame.player.getHand().size() > 4 ) {

            String playerFifthCardSuit = "" + blackjackGame.player.getHand().get(4).getSuitString();
            String playerFifthCardRank = "" + blackjackGame.player.getHand().get(4).getValueString();
            fifth_card = (TextView) findViewById(R.id.fifth_card);
            fifth_card.setText("5th Card: The " + playerFifthCardRank + " of " + playerFifthCardSuit);
            Log.d("Player fifth:", blackjackGame.player.getHand().get(4).getValueString());

        }
    }


    public void onClickStick(View button) {

        String whoWon = blackjackGame.decideWinnerString();
        winnerDisplay = (TextView) findViewById(R.id.winner_display);
        winnerDisplay.setText(whoWon);

        Log.i("Test", "Stick button clicked");
        Log.i("Dealer first card", blackjackGame.dealerPlayer.getHand().get(0).getValue().toString() + blackjackGame.dealerPlayer.getHand().get(0).getSuit().toString());
        Log.i("Dealer second card", blackjackGame.dealerPlayer.getHand().get(1).getValue().toString() + blackjackGame.dealerPlayer.getHand().get(1).getSuit().toString());
        Log.i("Dealer hand size:", "" + blackjackGame.dealerPlayer.getHand().size());

        Log.i("After", "" + blackjackGame.dealerPlayer.getHandWorth());

        String currentDealerScore = "" + blackjackGame.dealerPlayer.getHandWorth();
        dealerScore = (TextView) findViewById(R.id.dealer_score);
        dealerScore.setText(currentDealerScore);

        if (blackjackGame.dealerPlayer.winner) {
            MediaPlayer loseSound = MediaPlayer.create(this, R.raw.youlosesound);
            loseSound.start();
        } else if (blackjackGame.player.winner){
            MediaPlayer winSound = MediaPlayer.create(this, R.raw.youwinsound);
            winSound.start();
        } else {
            MediaPlayer drawSound = MediaPlayer.create(this, R.raw.draw);
            drawSound.start();
        }


    }







//        HashMap<Value, String> rank = new HashMap<>();
//        rank.put(Value.TWO, "2");
//        rank.put(Value.THREE, "3");
//        rank.put(Value.FOUR, "4");
//        rank.put(Value.FIVE, "5");
//        rank.put(Value.SIX, "6");
//        rank.put(Value.SEVEN, "7");
//        rank.put(Value.EIGHT, "8");
//        rank.put(Value.NINE, "9");
//        rank.put(Value.TEN, "10");
//        rank.put(Value.JACK, "J");
//        rank.put(Value.QUEEN, "Q");
//        rank.put(Value.KING, "K");
//        rank.put(Value.ACE, "A");
//
//        blackjackGame = new BlackjackGame();
//        blackjackGame.dealToBoth();
//
////        REDRAW FIRST AND SECOND CARDS BASED ON NEW CARDS
//
//        String firstCardSuit = blackjackGame.player.getHand().get(0).getSuitString();
//        int firstCardSuitId = getResources().getIdentifier(firstCardSuit, "drawable", getPackageName());
//        firstSuitImage.setImageResource(firstCardSuitId);
//
//        String firstValueString = rank.get(blackjackGame.player.getHand().get(0).getValue());
//        firstCardRank = (TextView) findViewById(R.id.first_card_rank);
//        firstCardRank.setText(firstValueString);
//
//        String secondCardSuit = blackjackGame.player.getHand().get(1).getSuitString();
//        int secondCardSuitId = getResources().getIdentifier(secondCardSuit, "drawable", getPackageName());
//        secondSuitImage.setImageResource(secondCardSuitId);
//
//        String secondValueString = rank.get(blackjackGame.player.getHand().get(1).getValue());
//        secondCardRank = (TextView) findViewById(R.id.second_card_rank);
//        secondCardRank.setText(secondValueString);
//
//
//
//        String currentPlayerScore = "" + blackjackGame.player.getHandWorth();
//
//        String dealerFirstCard = blackjackGame.dealerPlayer.getHand().get(0).getValue().toString();
//        String dealerSecondCard = blackjackGame.dealerPlayer.getHand().get(1).getValue().toString();
//
//        Log.d("Player first:", blackjackGame.player.getHand().get(0).getValueString() + blackjackGame.player.getHand().get(0).getSuit().toString());
//        Log.d("Player second:", blackjackGame.player.getHand().get(1).getValueString() + blackjackGame.player.getHand().get(1).getSuit().toString());
//        Log.d("Player score: ", currentPlayerScore);
//        Log.i("Dealer first card", blackjackGame.dealerPlayer.getHand().get(0).getValue().toString() + blackjackGame.dealerPlayer.getHand().get(0).getSuit().toString());
//        Log.i("Dealer second card", blackjackGame.dealerPlayer.getHand().get(1).getValue().toString() + blackjackGame.dealerPlayer.getHand().get(1).getSuit().toString());
//
//        String newPlayerScore = "" + blackjackGame.player.getHandWorth();
//        playerScore = (TextView) findViewById(R.id.player_score);
//        playerScore.setText(newPlayerScore);
//
////        RESETS THE DEALER SCORE, WINNER DISPLAY, AND ADDITIONAL CARD DISPLAYS
//
//        dealerScore = (TextView) findViewById(R.id.dealer_score);
//        dealerScore.setText("");
//        winnerDisplay = (TextView) findViewById(R.id.winner_display);
//        winnerDisplay.setText("");
//
//        third_card = (TextView) findViewById(R.id.third_card);
//        third_card.setText("");
//
//        fourth_card = (TextView) findViewById(R.id.fourth_card);
//        fourth_card.setText("");
//
//        fifth_card = (TextView) findViewById(R.id.fifth_card);
//        fifth_card.setText("");








}
