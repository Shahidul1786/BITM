package com.shahid.d25firebasecruddeatails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nameET,classET,secET,rollET;
    private Button addBTN;
    private RecyclerView recyclerView;
    private List<Student> students;
    private CustomAdapter  adapter;
    private DatabaseReference databaseReference;
    private CardView cardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =nameET.getText().toString().trim();
                String classN = classET.getText().toString().trim();
                String sec = secET.getText().toString().trim();
                String roll = rollET.getText().toString().trim();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(classN)|| TextUtils.isEmpty(sec)|| TextUtils.isEmpty(roll)){

                    Toast.makeText(MainActivity.this, "fields are empty", Toast.LENGTH_SHORT).show();

                }else {

                    addToDB(name,classN,sec,roll);
                }
            }
        });

        getStudents();


        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(MainActivity.this,DetilsActivity.class));
            }
        });




    }

    private void getStudents() {

        DatabaseReference studentRef = databaseReference.child("studentdetails");

        studentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){

                    students.clear();

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                        Student student = dataSnapshot1.getValue(Student.class);
                        students.add(student);

                        adapter.notifyDataSetChanged();

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void addToDB(String name, String classN, String sec, String roll) {

        DatabaseReference studentRef = databaseReference.child("studentdetails");

        Student student = new Student(name,classN,sec,roll);

        studentRef.push().setValue(student).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "successfully added", Toast.LENGTH_SHORT).show();
                }else {

                    Toast.makeText(MainActivity.this, "added failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void init() {

        databaseReference = FirebaseDatabase.getInstance().getReference();

        nameET =findViewById(R.id.nameETID);
        classET =findViewById(R.id.classETID);
        secET =findViewById(R.id.sectionETID);
        rollET =findViewById(R.id.rollETID);
        addBTN = findViewById(R.id.addBTNID);
        cardView = findViewById(R.id.cardviewID);

        recyclerView = findViewById(R.id.recycleVID);

        students = new ArrayList<>();

        adapter = new CustomAdapter(students);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }


}
