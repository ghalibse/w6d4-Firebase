package com.example.simplefirebase;

import android.app.Application;

import com.firebase.client.Firebase;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
