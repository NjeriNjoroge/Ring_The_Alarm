package com.example.gnjoroge.ringthealarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.card_view1) CardView mAmbulance;
    @Bind(R.id.card_view2) CardView mIce;
    private Button mFireButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


//    mFireButton = (Button) findViewById(R.id.fireButton);
//
//    mFireButton.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        Intent intent = new Intent(MainActivity.this, FireActivity.class);
//        startActivity(intent);
//    }


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
            Intent intent = new Intent(MainActivity.this, NotifyActivity.class);
            startActivity(intent);
        }
    });

    }
//    });
//    }
}
