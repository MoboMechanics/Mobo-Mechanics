package com.example.saddam.myapplication;
import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by DELL on 3/28/2017.
 */

public class User {
    public String name;
    public String expertise;
    public String phone;
    public String shopname;
    public String address;
    public double logitude;
    public double latitude;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User()
    {
    }

    public User(User U)
    {
            this.name=U.name;
            this.shopname=U.shopname;
            this.latitude=U.latitude;
            this.logitude=U.logitude;
            this.expertise=U.expertise;
            this.address=U.address;
            this.phone=U.phone;
    }

    public User(String name, String expertise,String phone,String shopname,String address,double logitude,double latitude)
    {
        this.name = name;
        this.expertise=expertise;
        this.phone=phone;
        this.shopname=shopname;
        this.address=address;
        this.logitude=logitude;
        this.latitude=latitude;

    }

    public void setuser(User U)
    {
        this.name=U.name;
        this.shopname=U.shopname;
        this.latitude=U.latitude;
        this.logitude=U.logitude;
        this.expertise=U.expertise;
        this.address=U.address;
        this.phone=U.phone;
    }
}
