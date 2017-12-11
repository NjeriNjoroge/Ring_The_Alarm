package com.example.gnjoroge.ringthealarm;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class PrivateAmbList extends AppCompatActivity {

    String[] ambulances = {"AAR Insurance Kenya Ltd",
    "AMREF Flying Doctors",
    "Avenue Rescue Services",
    "Emergency Response Services",
    "Emergency Rescue",
    "Rescue Med",
    "St John Ambulance Kenya",
    "West Ambulance Services",
    "Kenya Red Cross Society Ambulance",
    "The Karen Hospital",
    "Intensive Care Air Ambulance Ltd"};

     String[] phone = {"020-2717374, 254703063000",
            "+254-722314239, +254-733639088",
            "+254203745750",
            "+254770111090",
            "+254721775699",
            "+254722805645",
            "+254720736591",
            "+254723445526",
            "(020)3950000",
            "+254206613000",
            "+254-206004945"};

    String[] address = {"4th Ngong Ave, Williamson House, 2nd Flr, Nairobi",
    "AMREF Flying Doctors House, Inside Wilson Airport, Nairobi",
    "1st parklands Avenue, Nairobi",
    "South C (Bellevue), Red Cross Road, Nairobi",
    "Narshi House, Morkah daddah Street, Nairobi",
    "Taveta Road, Nairobi",
    "St John`s house, County Lane, Nairobi",
    "Nairobi West, Nairobi",
    "Haile Selassie Ave, Nairobi, Kenya",
    " Langata Rd, Nairobi City, Kenya",
    "Wilson Grounds, Nairobi, Kenya"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_amb_list);

        final ListView listView = (ListView) findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ambulances.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_layout, null);

            TextView textView = (TextView) view.findViewById(R.id.hospName);
            TextView textView_add = (TextView) view.findViewById(R.id.hospAdd);
            TextView textView_tel = (TextView) view.findViewById(R.id.hospNum);

            textView.setText(ambulances[i]);
            textView_tel.setText(phone[i]);
            textView_add.setText(address[i]);

            return view;


        }

    }

}
