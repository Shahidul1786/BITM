package com.shahid.boardcastreceivernetworkconnectivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private CheckInternert CheckInternert = new CheckInternert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter  = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(CheckInternert,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(CheckInternert);
    }
}
