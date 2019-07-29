package com.shahid.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nameET,emailET;
    private Button loginBTN;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

       loginBTN.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               sharedPreferences = getSharedPreferences("name",MODE_PRIVATE);
               editor = sharedPreferences.edit();
               name = nameET.getText().toString();
               email = emailET.getText().toString();
               editor.putString("name",name);
               editor.putString("email",email);
               editor.apply();

               startActivity(new Intent(MainActivity.this,WelcomeActivity.class));

           }
       });


    }

    private void init() {
       nameET = findViewById(R.id.nameETID) ;
       emailET = findViewById(R.id.emailETID);
       loginBTN = findViewById(R.id.loginBTN);


    }


    public void welcome(View view) {

        startActivity(new Intent(MainActivity.this,WelcomeActivity.class));
    }
}
