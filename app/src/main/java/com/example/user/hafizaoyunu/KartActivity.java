package com.example.user.hafizaoyunu;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.TextView;

public class KartActivity extends AppCompatActivity {
    int lastCard = -1;
    int score = 0;
    int mistake = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kart);
        Intent i = getIntent();
        final String s = i.getStringExtra("name");
        final String message = "Welcome to the memory game" + " " + i.getStringExtra("name");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(message);
        Card Cards[] = new Card[16];
        GridLayout gd = (GridLayout) findViewById(R.id.cards);

        for (int j = 1; j <= 16; j++) {
            Cards[j - 1] = new Card(this, j);
            Cards[j - 1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Card card = (Card) v;
                    card.turnButton();
                    final Card card2 = (Card) findViewById(lastCard);
                    if (lastCard > 0) {


                        if (card2.frontId == card.frontId && card.getId() != card2.getId()) {
                            card.translatable = false;
                            card2.translatable = false;
                            score++;
                            TextView tv = (TextView) findViewById(R.id.textView3);
                            tv.setText("Your Score: " + score);
                            if (score == 8) {
                                Intent i1 = new Intent(KartActivity.this, ScoreActivity.class);
                                i1.putExtra("score", mistake);
                                i1.putExtra("name", s);
                                startActivity(i1);

                            }


                        } else {
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    card.turnButton();
                                    card2.turnButton();
                                }
                            }, 700);
                            mistake++;
                            TextView tv = (TextView) findViewById(R.id.textView4);
                            tv.setText("Total mistake: " + mistake);

                            lastCard = 0;

                        }
                    } else {
                        lastCard = card.getId();

                    }

                }
            });

        }
        for (int j = 0; j < 16; j++) {
            int rnd = (int) (Math.random() * 10);
            Card k = Cards[rnd];
            Cards[rnd] = Cards[j];
            Cards[j] = k;
        }

        for (int j = 0; j < 16; j++) {

            gd.addView(Cards[j]);

        }

    }
}
