package com.shahid.firebasenofification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.shahid.firebasenofification.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseReference databaseReference;
    private List<String> userNameList;
    private List<String> userIds;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        init();
        getUsers();


        binding.listViewID.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               // Toast.makeText(MainActivity.this, userIds.get(i), Toast.LENGTH_SHORT).show();

                Map<String,Object> notificationMap = new HashMap<>();
                notificationMap.put("message","this is for test notification");
                notificationMap.put("senderId",userId);

                firebaseFirestore.collection("userInfo").document(userIds.get(i)).collection("notifications").add(notificationMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "notification sent", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

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
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        userId = firebaseAuth.getCurrentUser().getUid();
    }
}
