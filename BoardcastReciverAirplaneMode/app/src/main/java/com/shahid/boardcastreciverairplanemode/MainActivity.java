package com.shahid.boardcastreciverairplanemode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

import static android.content.Intent.ACTION_AIRPLANE_MODE_CHANGED;

public class MainActivity extends AppCompatActivity {

    private CheckAirplaneMode CheckAirplaneMode = new CheckAirplaneMode();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter = new IntentFilter(ACTION_AIRPLANE_MODE_CHANGED);

        registerReceiver(CheckAirplaneMode,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(CheckAirplaneMode);
    }
}
