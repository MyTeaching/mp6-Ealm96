package com.example.andrew.mybroadcast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Onclick(android.view.View view){
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("com.example.andrew.I_AM_HOME");
        sendBroadcast(intent);
    }

}
