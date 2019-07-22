package com.shahid.day24_firebasecrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nameET,emailET,ageET,bloodGET;
    private Button addBTN;
    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }

    private void init() {

        students = new ArrayList<>();

        nameET = findViewById(R.id.nameETID);
        emailET = findViewById(R.id.emailETID);
        ageET = findViewById(R.id.ageETID);
        bloodGET = findViewById(R.id.bloodETID);
        recyclerView = findViewById(R.id.recycleVID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new StudentAdapter(students);
        recyclerView.setAdapter(adapter);


    }
}
