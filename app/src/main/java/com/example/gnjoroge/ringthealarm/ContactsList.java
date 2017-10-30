package com.example.gnjoroge.ringthealarm;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContactsList extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private String mRecentAddress;

    @Bind(R.id.textView4) TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        ButterKnife.bind(this);

    }
}
