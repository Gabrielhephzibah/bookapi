package com.cherish.bookapi;

import android.app.Application;

import androidx.annotation.NonNull;

import com.androidnetworking.AndroidNetworking;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());

    }



}
