package com.example.user.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_launcher);

        blackjackGame = new BlackjackGame();
        blackjackGame.dealToBoth();
        String currentPlayerScore = "" + blackjackGame.player.getHandWorth();

        String dealerFirstCard = blackjackGame.dealerPlayer.getHand().get(0).getValue().toString();
        String dealerSecondCard = blackjackGame.dealerPlayer.getHand().get(1).getValue().toString();

        Log.d("Dealer first card: ", dealerFirstCard);
        Log.d("Dealer second card: ", dealerSecondCard);

        twist_button = (Button) findViewById(R.id.twist_button);
        stick_button = (Button) findViewById(R.id.stick_button);
        third_card = (TextView) findViewById(R.id.third_card);
        winnerDisplay = (TextView) findViewById(R.id.winner_display);

        playerScore = (TextView) findViewById((R.id.player_score));
        playerScore.setText(currentPlayerScore);
    }

    public void onClickNewGame(View button) {
        blackjackGame = new BlackjackGame();
        blackjackGame.dealToBoth();
        String currentPlayerScore = "" + blackjackGame.player.getHandWorth();

        String dealerFirstCard = blackjackGame.dealerPlayer.getHand().get(0).getValue().toString();
        String dealerSecondCard = blackjackGame.dealerPlayer.getHand().get(1).getValue().toString();

        Log.d("Player score: ", currentPlayerScore);
        Log.d("Dealer first card: ", dealerFirstCard);
        Log.d("Dealer second card: ", dealerSecondCard);
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





        String whoWon = blackjackGame.decideWinner().getName();
        winnerDisplay = (TextView) findViewById(R.id.winner_display);
        winnerDisplay.setText(whoWon);

        Log.i("Test", "Stick button clicked");

//        Player winnerWinnerChickenDinner = blackjackGame.decideWinner();

//        Card cardDealtToDealer = blackjackGame.dealACardToDealerPlayer();

        Log.i("Dealer first card", blackjackGame.dealerPlayer.getHand().get(0).getValue().toString());
        Log.i("Dealer second card", blackjackGame.dealerPlayer.getHand().get(1).getValue().toString());
        Log.i("Dealer hand size:", "" + blackjackGame.dealerPlayer.getHand().size());

        Log.i("After", "" + blackjackGame.dealerPlayer.getHandWorth());






    }










}
