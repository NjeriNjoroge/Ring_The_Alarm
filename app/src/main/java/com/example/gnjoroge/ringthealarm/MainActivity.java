package com.example.gnjoroge.ringthealarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mFireButton;
    private Button mEmergencyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFireButton = (Button) findViewById(R.id.fireButton);
        mEmergencyButton = (Button)findViewById(R.id.emergencyContacts);

        mEmergencyButton.setOnClickListener(this);
        mFireButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View view){
        if(view == mEmergencyButton){
            Intent intent = new Intent(MainActivity.this, EmergencyActivity.class);
            startActivity(intent);
        }
        else if(view == mFireButton){
            Intent intent = new Intent(MainActivity.this, FireActivity.class);
            startActivity(intent);
        }
    }

}
