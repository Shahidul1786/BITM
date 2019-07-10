package com.shahid.dailyexpenseCorrection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddExpenseActivity extends AppCompatActivity {

    private TextView fromdate,todate;
    private ImageView fromdateImage,todateImage;
    private EditText amountET,dateET,timeET;
    private  String amount,time,date;

    private Button addDocBTN,addExBTN;
    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        init();
        addExBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                amount = amountET.getText().toString();
                date = dateET.getText().toString();
                time = timeET.getText().toString();


                long id = helper.insertData(amount,date,time);
                Toast.makeText(AddExpenseActivity.this, ""+id, Toast.LENGTH_SHORT).show();


            }
        });

    }




    private void init() {

        fromdate = findViewById(R.id.fromdateID);
        todate = findViewById(R.id.todateID);
        fromdateImage = findViewById(R.id.fromimageID);
        todateImage = findViewById(R.id.toimageID);
        amountET = findViewById(R.id.amountEtID);
        dateET = findViewById(R.id.dateEtID);
        timeET = findViewById(R.id.timeEtID);

        addDocBTN = findViewById(R.id.addDocBtnID);
        addExBTN = findViewById(R.id.addExBTNID);

        helper = new DatabaseHelper(this);


    }
}
