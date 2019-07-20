package com.shahid.day23firebaseauthemailpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText emailET,passwordET;
    private Button signinBTN;
    private TextView signupTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        init();

        signupTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });

    }

    private void init() {

        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        signinBTN = findViewById(R.id.signBTNID);
        signupTV = findViewById(R.id.signUpTV);
    }
}
