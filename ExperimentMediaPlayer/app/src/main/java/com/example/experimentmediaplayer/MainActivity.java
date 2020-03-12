package com.example.experimentmediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.play_button);
        Button pauseButton = findViewById(R.id.pause_button);

        mediaplayer = MediaPlayer.create(this, R.raw.song);

        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                mediaplayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mediaplayer.pause();
            }
        });
    }
}
