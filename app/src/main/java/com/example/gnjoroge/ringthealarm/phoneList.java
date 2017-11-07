package com.example.gnjoroge.ringthealarm;

import java.util.ArrayList;

/**
 * Created by gnjoroge on 11/7/17.
 */

public class phoneList {

    public ArrayList<Contact> contactArrayList;

    //contains all the contacts in the phone
    phoneList() {
        contactArrayList = new ArrayList<Contact>();
    }

    public int getCount() {

        return contactArrayList.size();
    }

    public void addContact(Contact contact) {
        contactArrayList.add(contact);
    }

    public void removeContact(Contact contact) {
        contactArrayList.remove(contact);
    }

    public Contact getContact(int id) {
        for (int i = 0; i < this.getCount(); i++) {
            if (Integer.parseInt(contactArrayList.get(i).id) == id)
                return contactArrayList.get(i);
        }

        return null;
    }
}