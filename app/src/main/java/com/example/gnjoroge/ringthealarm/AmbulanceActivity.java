package com.example.gnjoroge.ringthealarm;

import android.*;
import android.app.FragmentManager;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.R.attr.permission;


public class AmbulanceActivity extends AppCompatActivity {

    @Bind(R.id.selectAmb)
    Button mSelectAmb;
    @Bind(R.id.sendSms)
    Button mSendSms;

    static final Integer CALL = 0x2;

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

    public void call_onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:999"));

        startActivity(intent);
    }


}

