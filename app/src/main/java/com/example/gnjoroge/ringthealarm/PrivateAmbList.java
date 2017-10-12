package com.example.gnjoroge.ringthealarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PrivateAmbList extends AppCompatActivity {

    private String[] ambulances = new String[] {"AAR Insurance Kenya Ltd",
    "AMREF Flying Doctors",
    "Avenue Rescue Services",
    "Emergency Response Services",
    "Emergency Rescue",
    "Rescue Med",
    "St John Ambulance Kenya",
    "West Ambulance Services",
    "Kenya Red Cros Society Ambulance in Kenya",
    "Road Safety Network Ambulance Service in Kenya",
    "The Karen Hospital",
    "Intensive Care Air Ambulance Ltd"};

    private String[] phone = new String[] {"020-2717374, 254703063000",
            "+254-722314239, +254-733639088",
            "+254203745750",
            "+254770111090",
            "+254721775699",
            "+254722805645",
            "+254720736591",
            "+254723445526",
            "(020)3950000",
            "2212699",
            "+254206613000",
            "+254-206004945"};

    private ListView mlistView;

//    private TextView mName;
//    private CardView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_amb_list);

        mlistView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ambulances);
        mlistView.setAdapter(adapter);


    }
}
