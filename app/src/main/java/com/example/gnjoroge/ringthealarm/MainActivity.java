package com.example.gnjoroge.ringthealarm;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;


import java.io.IOException;





public class MainActivity extends AppCompatActivity {

    private Button mAmbulance;
    private Button mIce;
    private Button mFire;
    private Button mAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAmbulance = (Button) findViewById(R.id.topLeftOuter);
        mIce = (Button) findViewById(R.id.bottomRightOuter);
        mFire = (Button) findViewById(R.id.bottomLeftOuter);
        mAlarm = (Button) findViewById(R.id.topRightOuter);


        //actual alarm rings
        final MediaPlayer mp = new MediaPlayer();
        mAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()) {
                    mp.stop();
                }
                try {
                    mp.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("Warning.mp3");
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mp.prepare();
                    mp.start();
                } catch(IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

//intents to the various activities in the app
        mFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FireActivity.class);
                startActivity(intent);
            }
        });


        mAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AmbulanceActivity.class);

                startActivity(intent);
            }
        });


        mIce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactsList.class);
                startActivity(intent);
            }
        });


    }



}


