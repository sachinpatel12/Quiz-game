package com.example.quiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static MediaPlayer mediaPlayer;
    SharedPreferenceUtil sharedPreferenceUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.kbcm);
        mediaPlayer.start();
        sharedPreferenceUtil=new SharedPreferenceUtil(this);
    }
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
//        mediaPlayer.stop();
//        mediaPlayer.release();

    }

    @Override
    protected void onResume() {
        boolean a = sharedPreferenceUtil.getboolean("k");
        super.onResume();
        if (a) {
            mediaPlayer.start();
        }
        else{

            mediaPlayer.pause();
        }
    }

    public void startquiz(View view) {
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }
    public void settings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
    public void leaderboard(View view) {
        Intent intent = new Intent(this, Leaderboard.class);
        startActivity(intent);
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void exit(View view)
    {
        finishAffinity();
    }

}
