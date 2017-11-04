package com.example.saddam.myapplication;


public class Config {

    private Config() {
    }

    public static final String DEVELOPER_KEY = "AIzaSyCBLOpgsTxVwoUCNfhYK448-MjGZM2UdcA";
    // YouTube video id
    public static String YOUTUBE_VIDEO_CODE = "g2lPAUBk2ek";

    public void set(String code)
    {
        YOUTUBE_VIDEO_CODE=code;
    }

}
