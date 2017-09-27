package com.example.user.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CardGamesLauncherActivity extends AppCompatActivity {

    ImageButton blackjack_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_games_launcher);

        blackjack_button = (ImageButton) findViewById(R.id.blackjack__choice_button);
    }

    public void onClickBlackjack(View button) {

        Intent intent = new Intent(this, BlackjackActivity.class);
        startActivity(intent);
        finish();
    }

}

