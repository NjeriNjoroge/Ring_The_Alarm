package com.example.gnjoroge.ringthealarm;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NotifyActivity extends AppCompatActivity {

    ArrayList<String> contactList;

    private static final int RESULT_PICK_CONTACT = 50;

    @Bind(R.id.button) Button mSelect;
    @Bind(R.id.contactName) TextView mName;
    @Bind(R.id.contactNum) TextView mNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        ButterKnife.bind(this);
    }

    public void pickContact(View v) {


        Intent contactPickerIntent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        startActivityForResult(contactPickerIntent, RESULT_PICK_CONTACT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //check whether result is ok
        if (resultCode == RESULT_OK) {
            //check for the request code, startActivityForResult
            switch (requestCode) {
                case RESULT_PICK_CONTACT:
                    contactPicked(data);
                    break;
            }

        } else {
            Log.e("NotifyActivity", "Failed to pick contacts");
        }
    }

    private void contactPicked(Intent data) {
        contactList = new ArrayList<String>();

        Cursor cursor = null;

        try {

            String phoneNo = null;
            String name = null;
            // getData() method will have the Content Uri of the selected contact
            Uri uri = data.getData();
            //Query the content uri
            cursor = getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();
            //column index of the phone number
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            //column index of the contact name
            int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            phoneNo = cursor.getString(phoneIndex);
            name = cursor.getString(nameIndex);
            //setting values to the text views
            mName.setText(name);
            mNum.setText(phoneNo);
        } catch (Exception e){
            e.printStackTrace();
        }
        contactList.add(mName.toString());
    }



}
