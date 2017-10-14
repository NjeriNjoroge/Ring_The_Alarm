package com.example.gnjoroge.ringthealarm;

/**
 * Created by moringa on 10/14/17.
 */

public class Fire {
    private String name;
    private String location;
    private int contacts;

    public Fire(){
    }
    public Fire(String name, String location, int contacts){
        this.name=name;
        this.location= location;
        this.contacts = contacts;
    }
    public String getName(){ return name;}
    public String getLocation(){ return location;}
    public int getContacts(){ return contacts;}
}
