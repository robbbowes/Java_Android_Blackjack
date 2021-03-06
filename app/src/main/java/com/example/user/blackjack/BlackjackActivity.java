package com.example.user.blackjack;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class BlackjackActivity extends AppCompatActivity {

    BlackjackGame blackjackGame;

    Button twist_button;
    Button stick_button;

    TextView playerScore;
    TextView dealerScore;
    TextView winnerDisplay;

    ImageButton back_to_games;

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
    ImageView dealerFirstCard;

    //    ADDITIONAL CARDS
//    PLAYER
    TextView third_card;
    TextView fourth_card;
    TextView fifth_card;
    //    DEALER
    TextView dealer_third_card;
    TextView dealer_fourth_card;
    TextView dealer_fifth_card;

    HashMap<Value, String> rank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack_launcher);

//        SET UP GAME

        blackjackGame = new BlackjackGame();
        blackjackGame.dealToBoth();
        Log.d("Player first:", blackjackGame.player.getHand().get(0).getValueString() + blackjackGame.player.getHand().get(0).getSuit().toString());
        Log.d("Player second:", blackjackGame.player.getHand().get(1).getValueString() + blackjackGame.player.getHand().get(1).getSuit().toString());

//        CREATE AND ADD PICS TO FIRST AND SECOND CARDS BASED ON WHAT PLAYER AND DEALER HAVE IN THEIR HANDS

        rank = new HashMap<>();
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

        dealerFirstCard = (ImageView) findViewById(R.id.dealer_first_card);
        dealerFirstCard.setImageResource(R.drawable.cardback);
        back_to_games = (ImageButton) findViewById(R.id.back_to_games);


//        CREATE BOX FOR PLAYER SCORE

        String currentPlayerScore = "" + blackjackGame.player.getHandWorth();

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

//    ON CLICK NEW GAME BUTTON

    public void onClickNewGame(View button) {

        Intent intent = new Intent(this, BlackjackActivity.class);
        startActivity(intent);
        finish();
    }

    //    ON CLICK BACK TO GAMES BUTTON

    public void onClickBackToGames(View button) {

        Intent intent = new Intent(this, CardGamesLauncherActivity.class);
        startActivity(intent);
        finish();
    }

//    ON CLICK TWIST BUTTON

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

        if (blackjackGame.player.getHand().size() > 2) {

            String playerThirdCardSuit = "" + blackjackGame.player.getHand().get(2).getSuitString();
            String playerThirdCardRank = "" + blackjackGame.player.getHand().get(2).getValueString();
            third_card = (TextView) findViewById(R.id.third_card);
            third_card.setText("3rd: The " + playerThirdCardRank + " of " + playerThirdCardSuit);
            Log.d("Player third:", blackjackGame.player.getHand().get(2).getValueString());
        }

        if (blackjackGame.player.getHand().size() > 3) {

            String playerFourthCardSuit = "" + blackjackGame.player.getHand().get(3).getSuitString();
            String playerFourthCardRank = "" + blackjackGame.player.getHand().get(3).getValueString();
            fourth_card = (TextView) findViewById(R.id.fourth_card);
            fourth_card.setText("4th: The " + playerFourthCardRank + " of " + playerFourthCardSuit);
            Log.d("Player fourth:", blackjackGame.player.getHand().get(3).getValueString());
        }

        if (blackjackGame.player.getHand().size() > 4) {

            String playerFifthCardSuit = "" + blackjackGame.player.getHand().get(4).getSuitString();
            String playerFifthCardRank = "" + blackjackGame.player.getHand().get(4).getValueString();
            fifth_card = (TextView) findViewById(R.id.fifth_card);
            fifth_card.setText("5th: The " + playerFifthCardRank + " of " + playerFifthCardSuit);
            Log.d("Player fifth:", blackjackGame.player.getHand().get(4).getValueString());
        }

        if (blackjackGame.player.isBust()) {
            twist_button.setVisibility(View.INVISIBLE);
        }
    }

//    ON CLICK STICK BUTTON

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
        } else if (blackjackGame.player.winner) {
            MediaPlayer winSound = MediaPlayer.create(this, R.raw.youwinsound);
            winSound.start();
        } else {
            MediaPlayer drawSound = MediaPlayer.create(this, R.raw.draw);
            drawSound.start();
        }

//        FLIPS THE DEALERS FIRST CARD

        dealerFirstCard.setImageResource(R.drawable.blankcard);
        dealerFirstSuitImage = (ImageView) findViewById(R.id.dealer_first_suit);
        String dealerFirstSuit = blackjackGame.dealerPlayer.getHand().get(0).getSuitString();
        int dealerFirstCardSuitId = getResources().getIdentifier(dealerFirstSuit, "drawable", getPackageName());
        dealerFirstSuitImage.setImageResource(dealerFirstCardSuitId);

        String dealerFirstValueString = rank.get(blackjackGame.dealerPlayer.getHand().get(0).getValue());
        dealerFirstCardRank = (TextView) findViewById(R.id.dealer_first_rank);
        dealerFirstCardRank.setText(dealerFirstValueString);

        if (blackjackGame.dealerPlayer.getHand().size() > 2) {

            String dealerPlayerThirdCardSuit = "" + blackjackGame.dealerPlayer.getHand().get(2).getSuitString();
            String dealerPlayerThirdCardRank = "" + blackjackGame.dealerPlayer.getHand().get(2).getValueString();
            dealer_third_card = (TextView) findViewById(R.id.dealer_third_card);
            dealer_third_card.setText("3rd: The " + dealerPlayerThirdCardRank + " of " + dealerPlayerThirdCardSuit);
            Log.d("Dealer third:", blackjackGame.dealerPlayer.getHand().get(2).getValueString());
        }

        if (blackjackGame.dealerPlayer.getHand().size() > 3) {

            String dealerPlayerFourthCardSuit = "" + blackjackGame.dealerPlayer.getHand().get(3).getSuitString();
            String dealerPlayerFourthCardRank = "" + blackjackGame.dealerPlayer.getHand().get(3).getValueString();
            dealer_fourth_card = (TextView) findViewById(R.id.dealer_fourth_card);
            dealer_fourth_card.setText("4th Card: The " + dealerPlayerFourthCardRank + " of " + dealerPlayerFourthCardSuit);
            Log.d("Dealer fourth:", blackjackGame.dealerPlayer.getHand().get(3).getValueString());
        }

        if (blackjackGame.dealerPlayer.getHand().size() > 4) {

            String dealerPlayerFifthCardSuit = "" + blackjackGame.dealerPlayer.getHand().get(4).getSuitString();
            String dealerPlayerFifthCardRank = "" + blackjackGame.dealerPlayer.getHand().get(4).getValueString();
            dealer_fifth_card = (TextView) findViewById(R.id.dealer_fifth_card);
            dealer_fifth_card.setText("5th Card: The " + dealerPlayerFifthCardRank + " of " + dealerPlayerFifthCardSuit);
            Log.d("Dealer fifth:", blackjackGame.dealerPlayer.getHand().get(4).getValueString());
        }

    }
}