package com.example.bitmd11RecyclerViewuserInputitemClick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nameET,phoneNoET,emailET;
    private String aName,aPhoneNo,aEmail;
    private Button saveBTN;
    private RecyclerView userRecyclerView;
    private List<User> userList;
    private CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        initRecyclerView();

        setData();
    }

    private void setData() {

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aName = nameET.getText().toString();
                aPhoneNo = phoneNoET.getText().toString();
                aEmail = emailET.getText().toString();

                userList.add(new User(aName,aPhoneNo,aEmail));
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void initRecyclerView() {

        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        userRecyclerView.setAdapter(adapter);
    }

    private void init() {
        userList = new ArrayList<>();
        nameET = findViewById(R.id.nameETID);
        phoneNoET = findViewById(R.id.phoneETID);
        emailET = findViewById(R.id.emailETID);
        saveBTN = findViewById(R.id.saveBTNID);

        userRecyclerView = findViewById(R.id.userRecyclerViewID);


        adapter = new CustomAdapter(userList);

    }
}
