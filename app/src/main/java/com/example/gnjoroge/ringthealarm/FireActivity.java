package com.example.gnjoroge.ringthealarm;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.jar.Manifest;

public class FireActivity extends AppCompatActivity {
    private CardView mCardView;
    private TextView mTextViewName;
    private TextView mTextViewLocation;
    private TextView mTextViewContacts;

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Fire> data;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);
        button = (Button) findViewById(R.id.fireEmergencyButton);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:911"));

                startActivity(callIntent);
            }
        });

        mCardView=(CardView) findViewById(R.id.card_view);
        //mCardView.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data=new ArrayList<Fire>();
        for(int i=0; i<3; i++){
            data.add(new Fire(MyData.names[i],MyData.locations[i], MyData.contacts[i],MyData.images[i]));
        }

        adapter=new FireAdapter(getApplicationContext(),data);
        recyclerView.setAdapter(adapter);




    }

}
