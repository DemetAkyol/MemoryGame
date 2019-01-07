package com.example.user.hafizaoyunu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        TextView tv=(TextView)findViewById(R.id.textView2);
        Intent i=getIntent();
        String name=i.getStringExtra("name");
        int  score=i.getIntExtra("score",0);
        tv.setText("Congratulations "+" \n"+name+score+" .");
    }
}
