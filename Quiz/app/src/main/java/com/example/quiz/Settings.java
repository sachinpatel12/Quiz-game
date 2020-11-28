package com.example.quiz;

import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Settings extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Switch aSwitch;
    boolean switchstate;
    SharedPreferenceUtil s;
    private boolean isMusicOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setTitle("Settings");
//        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.kbcm);
//        mediaPlayer.start();

        aSwitch = findViewById(R.id.swi);
       // switchstate = aSwitch.isChecked();
        s = new SharedPreferenceUtil(this);
        isMusicOn = s.getboolean("k");
        aSwitch.setChecked(isMusicOn);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    MainActivity.mediaPlayer.start();
                } else {
                    MainActivity.mediaPlayer.pause();
                }
                s.saveboolean("k",b);
                switchstate=b;


            }
        });

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

    protected void onPause() {
        super.onPause();
//        mediaPlayer.stop();
//        mediaPlayer.release();

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        finish();
    }
}
