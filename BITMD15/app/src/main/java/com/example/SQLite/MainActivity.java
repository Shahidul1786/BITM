package com.example.SQLite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class    MainActivity extends AppCompatActivity {

    private EditText nameET,ageET;
    private Button insertBTN,showButton;
    private String aName,aAge;

    private DatabaseHelper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();






        insertBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aName = nameET.getText().toString();
                aAge = ageET.getText().toString();

                long id = helper.insertData(aName,aAge);

                Toast.makeText(MainActivity.this, "Serial number : "+id, Toast.LENGTH_SHORT).show();

            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,ShowDetailsActivity.class);
                startActivity(intent);


            }
        });




    }





    private void init() {

        nameET = findViewById(R.id.nameETID);
        ageET = findViewById(R.id.ageETID);
        insertBTN = findViewById(R.id.insertBTNID);
        showButton = findViewById(R.id.showBTNID);
        helper = new DatabaseHelper(this);

    }
}
