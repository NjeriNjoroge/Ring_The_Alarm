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

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.topLeftOuter) Button mAmbulance;
    @Bind(R.id.bottomRightOuter) Button mIce;
    @Bind(R.id.bottomLeftOuter) Button mFireButton;
    @Bind(R.id.topRightOuter) Button mRing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //actual alarm rings
        final MediaPlayer mp = new MediaPlayer();
        mRing.setOnClickListener(new View.OnClickListener() {
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
        mFireButton.setOnClickListener(new View.OnClickListener() {
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
    @Override
    public void onClick(View view){
        if(view == mFireButton){
            Intent intent = new Intent(MainActivity.this, FireActivity.class);
            startActivity(intent);
        }
//        else if(view == mFireButton){
//            Intent intent = new Intent(MainActivity.this, FireActivity.class);
//            startActivity(intent);
//        }
    }


}


