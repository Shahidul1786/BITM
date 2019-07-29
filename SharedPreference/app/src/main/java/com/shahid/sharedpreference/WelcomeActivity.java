package com.shahid.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private TextView nameTV,emailTV;
    private SharedPreferences sharedPreferences;
    private String name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();

        sharedPreferences  =getSharedPreferences("name",MODE_PRIVATE);

        name  = sharedPreferences.getString("name",null);
        email = sharedPreferences.getString("email",null);

        if (name != null && email != null){
            nameTV.setText(name);
            emailTV.setText(email);

        }


    }

    private void init() {

        nameTV = findViewById(R.id.nameTV);
        emailTV = findViewById(R.id.emailTV);
    }


    public void clear(View view) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        startActivity(new Intent(WelcomeActivity.this,WelcomeActivity.class));
    }
}
