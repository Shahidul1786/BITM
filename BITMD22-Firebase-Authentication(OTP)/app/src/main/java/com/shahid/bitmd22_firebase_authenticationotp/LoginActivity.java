package com.shahid.bitmd22_firebase_authenticationotp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText phoneNoET;
    private Button nextBtn;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();





    }

    private void init() {

        phoneNoET = findViewById(R.id.phoneET);
        nextBtn = findViewById(R.id.nextBTNID);
    }
}
