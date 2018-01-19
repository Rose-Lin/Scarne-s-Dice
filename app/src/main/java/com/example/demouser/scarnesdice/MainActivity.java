package com.example.demouser.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     int USER_TURN = 0;
     int COMPUTER_TURN = 1;

     Button rollButton;
     Button holdButton;
     Button resetButton;
     int yourScore;
     int computerScore;
     int turnScore;
     int turn = USER_TURN;
     TextView yourScoreVal;
     TextView computerScoreVal;
     TextView turnScoreVal;
     ImageView diceImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollButton = findViewById(R.id.rollButton);
        holdButton = findViewById(R.id.holdButton);
        resetButton = findViewById(R.id.resettButton);
        yourScoreVal = findViewById(R.id.yourScoreVal);
        computerScoreVal = findViewById(R.id.computerScoreVal);
        turnScoreVal = findViewById(R.id.turnScoreVal);
        diceImage = findViewById(R.id.diceImage);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNum = (int)(Math.random()*6+1);
                int num = R.drawable.dice1;
                ArrayList<Integer> imageids = new ArrayList<Integer>();
                for (int i=0; i<6; i++, num++){
                    imageids.add(num);
                }
                diceImage.setBackgroundResource(imageids.get(randomNum-1));
            }
        });

        holdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn = changeTurn(turn);

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private int changeTurn(int turn){
        if (turn == USER_TURN){
            return COMPUTER_TURN;
        }
        return USER_TURN;
    }
}
