package com.example.gnjoroge.ringthealarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FireActivity extends AppCompatActivity {
    private ListView mSavedFireStationsListView;
    private String [] fireStations = new String[]{
            "Fire Rescue and Disaster Management Department Training School","Fire Station Nairobi","Jolemac Fire Protection Ltd","Airport Fire Station","KK Security Karen",
            "KAA Fire Station"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        mSavedFireStationsListView = (ListView)findViewById(R.id.savedFireStationsListView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fireStations );
        mSavedFireStationsListView.setAdapter(adapter);

    }
}
