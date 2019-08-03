package com.shahid.boardcastreceivernetworkconnectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class CheckInternert extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (isConnected){
            Toast.makeText(context, "Internet Connected", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, " No Internet Connection", Toast.LENGTH_LONG).show();
        }

    }
}
