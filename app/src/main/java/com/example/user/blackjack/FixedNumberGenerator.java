package com.example.user.blackjack;

/**
 * Created by user on 22/09/2017.
 */

public class FixedNumberGenerator implements NumberGenerating {

    public int generateNumber(int num) {
        if(num == 0){
            return 0;
        }else{
            return num - 1;
        }

    }

}
