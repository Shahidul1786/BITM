package com.shahid.bitmd22_firebase_authenticationotp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText phoneNoET;
    private Button nextBtn;
    private String phoneNo;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               phoneNo = phoneNoET.getText().toString().trim();

               if (phoneNo.length() == 11){
                   Intent intent = new Intent(LoginActivity.this,VerifyActivity.class);
                   intent.putExtra("phone",phoneNo);
                   startActivity(intent);
               }
               else {
                   Toast.makeText(LoginActivity.this, "phone no invalid", Toast.LENGTH_SHORT).show();
               }
            }
        });


    }

    private void init() {

        phoneNoET = findViewById(R.id.phoneET);
        nextBtn = findViewById(R.id.nextBTNID);
    }
}
