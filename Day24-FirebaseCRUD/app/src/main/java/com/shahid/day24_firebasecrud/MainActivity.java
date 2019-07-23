package com.shahid.day24_firebasecrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    private EditText nameET,emailET,ageET,bloodGET;
    private Button addBTN;
    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private List<Student> students;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name = nameET.getText().toString().trim();
               String email = emailET.getText().toString().trim();
               String age = ageET.getText().toString().trim();
               String bloodGroup = bloodGET.getText().toString().trim();



               if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(age) || TextUtils.isEmpty(bloodGroup)){

                   Toast.makeText(MainActivity.this, "Fields are empty...", Toast.LENGTH_SHORT).show();

               }else {

                   addValueToDB(name,email,age,bloodGroup);

              }


            }
        });


        getStudents();


    }

    private void getStudents() {

        DatabaseReference studentRef = databaseReference.child("students");
        studentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                if (dataSnapshot.exists()){

                    students.clear();

                    for (DataSnapshot data : dataSnapshot.getChildren()){
                      Student student =  data.getValue(Student.class);
                      students.add(student);

                      adapter.notifyDataSetChanged();

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(MainActivity.this, ""+databaseError.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void addValueToDB(String name, String email, String age, String bloodGroup) {

        DatabaseReference studentsRef = databaseReference.child("students");

        Student student = new Student(name,email,bloodGroup,age);

        studentsRef.push().setValue(student).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Successfully added", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Failed added", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void init() {

        databaseReference = FirebaseDatabase.getInstance().getReference();

        nameET = findViewById(R.id.nameETID);
        emailET = findViewById(R.id.emailETID);
        ageET = findViewById(R.id.ageETID);
        bloodGET = findViewById(R.id.bloodETID);
        recyclerView = findViewById(R.id.recycleVID);

        addBTN = findViewById(R.id.addBTNID);

        students = new ArrayList<>();

       // students.add(new Student("shahid","st@gmail.com","O+","26"));
       // students.add(new Student("shahid","st@gmail.com","O+","26"));
        //students.add(new Student("shahid","st@gmail.com","O+","26"));
        //students.add(new Student("shahid","st@gmail.com","O+","26"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new StudentAdapter(students);
        recyclerView.setAdapter(adapter);

    }
}
