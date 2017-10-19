package com.example.gnjoroge.ringthealarm;

/**
 * Created by moringa on 10/14/17.
 */

public class Fire {
    private int image;
    private String name;
    private String location;
//    private String contact;

    public Fire(){
    }
    public Fire(String name, String location,  int image){
        this.image = image;
        this.name=name;
        this.location= location;
//        this.contact = contact;
    }
    public int getImage(){ return image;}
    public String getName(){ return name;}
    public String getLocation(){ return location;}
//    public String getContact(){ return contact;}
}
