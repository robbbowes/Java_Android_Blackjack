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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_launcher);

        blackjackGame = new BlackjackGame();
        blackjackGame.dealToBoth();
        String playerscore = "" + blackjackGame.player.getHandWorth();

        twist_button = (Button) findViewById(R.id.twist_button);
        stick_button = (Button) findViewById(R.id.stick_button);
        third_card = (TextView) findViewById(R.id.third_card);

        playerScore = (TextView) findViewById((R.id.player_score));
        playerScore.setText(playerscore);
    }

    public void onClickTwist(View button) {

        Log.i("Test", "Twist button clicked");
        Log.i("Before", "" + blackjackGame.player.getHandWorth() );
        blackjackGame.dealACardToPlayer();
        blackjackGame.player.getHandWorth();
        Log.i("After", "" + blackjackGame.player.getHandWorth() );

        String playerscore = "" + blackjackGame.player.getHandWorth();
        playerScore = (TextView) findViewById((R.id.player_score));
        playerScore.setText(playerscore);

    }










}
