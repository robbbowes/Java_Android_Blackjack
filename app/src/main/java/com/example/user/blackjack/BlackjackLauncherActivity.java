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

import java.util.Random;

public class BlackjackLauncherActivity extends AppCompatActivity {

    BlackjackGame blackjackGame;
    Button twist_button;
    Button stick_button;
    TextView third_card;
    TextView playerScore;
    TextView winnerDisplay;
    TextView dealerScore;
    ImageView firstSuitImage;
    ImageView secondSuitImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_launcher);

//        SET UP GAME

        blackjackGame = new BlackjackGame();
        blackjackGame.dealToBoth();

//        CREATE AND ADD PICS TO FIRST AND SECOND CARDS BASED ON WHAT PLAYER HAS IN HAND

        firstSuitImage = (ImageView) findViewById(R.id.first_suit_image);
        String firstCardSuit = blackjackGame.player.getHand().get(0).getSuitString();
        int firstCardSuitId = getResources().getIdentifier(firstCardSuit, "drawable", getPackageName());
        firstSuitImage.setImageResource(firstCardSuitId);


        secondSuitImage = (ImageView) findViewById(R.id.second_suit_image);
        String secondCardSuit = blackjackGame.player.getHand().get(1).getSuitString();
        int secondCardSuitId = getResources().getIdentifier(secondCardSuit, "drawable", getPackageName());
        secondSuitImage.setImageResource(secondCardSuitId);

//        CREATE BOX FOR PLAYER SCORE

        String currentPlayerScore = "" + blackjackGame.player.getHandWorth();

        String dealerFirstCard = blackjackGame.dealerPlayer.getHand().get(0).getValue().toString();
        String dealerSecondCard = blackjackGame.dealerPlayer.getHand().get(1).getValue().toString();
        playerScore = (TextView) findViewById((R.id.player_score));
        playerScore.setText(currentPlayerScore);

        Log.d("Dealer first card: ", dealerFirstCard);
        Log.d("Dealer second card: ", dealerSecondCard);


//        CREATE BUTTONS FOR STICK AND TWIST AS WELL AS

        twist_button = (Button) findViewById(R.id.twist_button);
        stick_button = (Button) findViewById(R.id.stick_button);
        third_card = (TextView) findViewById(R.id.third_card);
        winnerDisplay = (TextView) findViewById(R.id.winner_display);
    }



    public void onClickNewGame(View button) {
        blackjackGame = new BlackjackGame();
        blackjackGame.dealToBoth();

//        REDRAW FIRST AND SECOND CARDS BASED ON NEW CARDS

        String firstCardSuit = blackjackGame.player.getHand().get(0).getSuitString();
        int firstCardSuitId = getResources().getIdentifier(firstCardSuit, "drawable", getPackageName());
        firstSuitImage.setImageResource(firstCardSuitId);

        String secondCardSuit = blackjackGame.player.getHand().get(1).getSuitString();
        int secondCardSuitId = getResources().getIdentifier(secondCardSuit, "drawable", getPackageName());
        secondSuitImage.setImageResource(secondCardSuitId);


        String currentPlayerScore = "" + blackjackGame.player.getHandWorth();

        String dealerFirstCard = blackjackGame.dealerPlayer.getHand().get(0).getValue().toString();
        String dealerSecondCard = blackjackGame.dealerPlayer.getHand().get(1).getValue().toString();

        Log.d("Player score: ", currentPlayerScore);
        Log.d("Dealer first card: ", dealerFirstCard);
        Log.d("Dealer second card: ", dealerSecondCard);

        String newPlayerScore = "" + blackjackGame.player.getHandWorth();
        playerScore = (TextView) findViewById(R.id.player_score);
        playerScore.setText(newPlayerScore);

        dealerScore = (TextView) findViewById(R.id.dealer_score);
        dealerScore.setText("");
        winnerDisplay = (TextView) findViewById(R.id.winner_display);
        winnerDisplay.setText("");

    }

    public void onClickTwist(View button) {

        Log.i("Test", "Twist button clicked");
        Log.i("Before", "" + blackjackGame.player.getHandWorth());

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





    }


    public void onClickStick(View button) {

        String whoWon = blackjackGame.decideWinnerString();
        winnerDisplay = (TextView) findViewById(R.id.winner_display);
        winnerDisplay.setText(whoWon);

        Log.i("Test", "Stick button clicked");
        Log.i("Dealer first card", blackjackGame.dealerPlayer.getHand().get(0).getValue().toString());
        Log.i("Dealer second card", blackjackGame.dealerPlayer.getHand().get(1).getValue().toString());
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
















}
