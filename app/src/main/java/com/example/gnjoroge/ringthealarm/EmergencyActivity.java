//package com.example.gnjoroge.ringthealarm;
//
//import android.annotation.TargetApi;
//import android.app.ProgressDialog;
//import android.content.ContentResolver;
//import android.content.Intent;
//import android.database.Cursor;
//import android.net.Uri;
//import android.os.Build;
//import android.os.Handler;
//import android.os.Looper;
//import android.provider.ContactsContract;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//
//public class EmergencyActivity extends AppCompatActivity {
//
//    @Bind(R.id.list) ListView mListView;
//    @Bind(R.id.pickContact) Button mPickContact;
//
//    ArrayList<String> contactList;
//    Cursor cursor;
//    int counter;
//
//    private ProgressDialog pDialog;
//    private Handler updateBarHandler;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_emergency);
//        ButterKnife.bind(this);
//
//        pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Reading contacts...");
//        pDialog.setCancelable(false);
//
//
//
//
//        updateBarHandler = new Handler();
//
//        //putting read contacts on a separate thread
//
////        mPickContact.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                pDialog.show();
//                getContacts();
//            }
//
//        }).start();
//
////            }
//
////        });
//
//
//
//        //setting onClickListener to the list item
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "item clicked : \n" +contactList.get(0), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    //    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    public void getContacts() {
//        contactList = new ArrayList<String>();
//        String phoneNumber = null;
//        String email = null;
//        Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
//        String _ID = ContactsContract.Contacts._ID;
//        String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
//        String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;
//        Uri PhoneCONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
//        String Phone_CONTACT_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
//        String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
//        Uri EmailCONTENT_URI =  ContactsContract.CommonDataKinds.Email.CONTENT_URI;
//        String EmailCONTACT_ID = ContactsContract.CommonDataKinds.Email.CONTACT_ID;
//        String DATA = ContactsContract.CommonDataKinds.Email.DATA;
//        StringBuffer output;
//        ContentResolver contentResolver = getContentResolver();
//        cursor = contentResolver.query(CONTENT_URI, null,null, null, null);
//        //iterate every contact in the phone
//        if (cursor.getCount() > 0) {
//            counter = 0;
//            while (cursor.moveToNext()) {
//                output = new StringBuffer();
//                //update the progress message
//                updateBarHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        pDialog.setMessage("Reading contacts : "+ counter++ +"/"+cursor.getCount());
//                    }
//                });
//
//                String contact_id = cursor.getString(cursor.getColumnIndex(_ID));
//                String name = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));
//                //String num = cursor.getString(cursor.getColumnIndex(NUMBER));
//                int hasPhoneNumber = Integer.parseInt(cursor.getColumnName(cursor.getColumnIndex( HAS_PHONE_NUMBER )));
//
//                if (hasPhoneNumber > 0) {
//                    output.append("\n First Name;" + name);
//                    //This is to read multiple phone numbers associated with the same contact
//                    Cursor phoneCursor = contentResolver.query(PhoneCONTENT_URI, null, Phone_CONTACT_ID + " = ?", new String[] { contact_id }, null);
//                    while (phoneCursor.moveToNext()) {
//                        phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER));
//                        output.append("\n Phone number:" + phoneNumber);
//                    }
//                    phoneCursor.close();
//                    // Read every email id associated with the contact
//                    Cursor emailCursor = contentResolver.query(EmailCONTENT_URI,    null, EmailCONTACT_ID+ " = ?", new String[] { contact_id }, null);
//                    while (emailCursor.moveToNext()) {
//                        email = emailCursor.getString(emailCursor.getColumnIndex(DATA));
//                        output.append("\n Email:" + email);
//                    }
//                    emailCursor.close();
//                }
//
//                //adding to the array list
//                contactList.add(output.toString());
//            }
//
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_item, R.id.text1, contactList);
//                    mListView.setAdapter(adapter);
//                }
//            });
//            //dismissing the progress bar after 500ms
//            updateBarHandler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    pDialog.cancel();
//                }
//            }, 500);
//        }
//
//    }
//
//
//}