package com.example.bitmd10RecyclerViewInput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Student> studentList;
    private RecyclerView studentRV;
    private StudentsAdapter studentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getData();

        initRecyclerView();
    }

    private void initRecyclerView() {
        studentRV.setLayoutManager(new LinearLayoutManager(this));
        studentRV.setAdapter(studentsAdapter);
    }


    private void init() {

        studentList = new ArrayList<>();
        studentRV = findViewById(R.id.studentRVID);
        studentsAdapter =  new StudentsAdapter(studentList);
    }


    private void getData() {

        Student student1 = new Student("shahidul","s100","java","Male","shahid@gmail.com","017000000");
        Student student2 = new Student("taj","s101","C#","Male","taj@gmail.com","016000000");
        Student student3 = new Student("naz","s102","PHP","Female","naj@gmail.com","018000000");

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        studentsAdapter.notifyDataSetChanged();
    }
}
