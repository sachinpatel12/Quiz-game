package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Leaderboard extends AppCompatActivity {
    private boolean isMusicOn;
    SharedPreferenceUtil s;
    TextView t ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        s = new SharedPreferenceUtil(this);
        getSupportActionBar().setTitle("Leaderboard");
        t=findViewById(R.id.highscore);
     //   setContentView(R.layout.activity_leaderboard);
        isMusicOn = s.getboolean("k");
        setHighscore();
    }
    public void onBackPressed() {
        finish();
    }
        @Override
        protected void onResume() {
            super.onResume();
            if (isMusicOn) {
                MainActivity.mediaPlayer.start();
            }
            else {
                MainActivity.mediaPlayer.pause();
            }
            // mediaPlayer.start();
        }
        public void setHighscore()
    {
            int h= new SharedPreferenceUtil(this).getno("high");
            String a=Integer.toString(h);
            t.setText(a);
    }
    }

