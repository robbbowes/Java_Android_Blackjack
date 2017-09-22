package com.example.user.blackjack;

import java.util.Random;

/**
 * Created by user on 22/09/2017.
 */

public class RandomNumberGenerator implements NumberGenerating {

        public int generateNumber(int maxThreshold) {
            Random random = new Random();
            int randomNumber = random.nextInt(maxThreshold);
            return randomNumber;
        }
}
