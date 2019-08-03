package com.shahid.firebasenofification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shahid.firebasenofification.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseReference databaseReference;
    private List<String> userNameList;
    private List<String> userIds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        init();
        getUsers();


    }

    private void initListView() {

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,userNameList);
        binding.listViewID.setAdapter(adapter);
    }

    private void getUsers() {

        DatabaseReference userRef = databaseReference.child("userInfo");

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                if (dataSnapshot.exists()){

                    userNameList.clear();
                    userIds.clear();

                    for (DataSnapshot data : dataSnapshot.getChildren()){

                        String name  = data.child("name").getValue().toString();

                        userNameList.add(name);

                        String userId = data.getKey();

                        userIds.add(userId);

                    }
                    initListView();

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void init() {

        databaseReference = FirebaseDatabase.getInstance().getReference();
        userNameList  = new ArrayList<>();
        userIds = new ArrayList<>();
    }
}
