package com.example.gnjoroge.ringthealarm;

import android.*;
import android.app.FragmentManager;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;




import static android.R.attr.permission;


public class AmbulanceActivity extends AppCompatActivity {

    private ImageView mSelectAmb;

       static final Integer CALL = 0x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);

        mSelectAmb = (ImageView) findViewById(R.id.selectAmb);


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

