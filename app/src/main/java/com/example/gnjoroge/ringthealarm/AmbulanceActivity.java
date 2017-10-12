package com.example.gnjoroge.ringthealarm;

import android.app.FragmentManager;
import android.content.Intent;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;


public class AmbulanceActivity extends AppCompatActivity {

    @Bind(R.id.selectAmb) Button mSelectAmb;
    @Bind(R.id.sendSms) Button mSendSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);
        ButterKnife.bind(this);

        mSelectAmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AmbulanceActivity.this, PrivateAmbList.class);
                startActivity(intent);
            }
        });

    }

}

