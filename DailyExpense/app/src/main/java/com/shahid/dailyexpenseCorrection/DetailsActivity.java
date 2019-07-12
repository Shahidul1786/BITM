package com.shahid.dailyexpenseCorrection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView amount,date;
    private Button update;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        //init();


        //String eAmount = amount.getText().toString();
        //String eDate = date.getText().toString();


       // eAmount = getIntent().getStringExtra("amount");
        //eDate = getIntent().getStringExtra("date");


        //amount.setText(eAmount);
       // date.setText(eDate);



    }

    private void init() {

        amount = findViewById(R.id.amountTV);
        date = findViewById(R.id.dateTV);
        update = findViewById(R.id.updateBTNID);

    }
}
