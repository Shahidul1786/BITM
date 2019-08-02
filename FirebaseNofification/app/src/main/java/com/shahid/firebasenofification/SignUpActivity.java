package com.shahid.firebasenofification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.iid.FirebaseInstanceId;
import com.shahid.firebasenofification.databinding.ActivitySignUpBinding;
import com.shahid.firebasenofification.pojoclass.User;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;


    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
            init();

            if (firebaseAuth.getCurrentUser()!= null){

                startActivity(new Intent(SignUpActivity.this,MainActivity.class));
            }


        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);

        binding.signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = binding.nameETID.getText().toString().trim();
                String email = binding.emailETID.getText().toString().trim();
                String password = binding.passwordETID.getText().toString().trim();

                if (name.equals("")|| email.equals("") || password.equals("")){
                    Toast.makeText(SignUpActivity.this, "please fill All the fields", Toast.LENGTH_SHORT).show();
                }else {
                    signUp(name,email,password);
                }

            }
        });
    }

    private void init() {

        firebaseAuth  = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseFirestore = FirebaseFirestore.getInstance();
    }


    private void signUp(final String name, final String email, String password) {

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    final String userID = firebaseAuth.getCurrentUser().getUid();
                    User user = new User(name,email);

                    DatabaseReference userRef = databaseReference.child("userInfo").child(userID);

                    userRef.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            String tokenId = FirebaseInstanceId.getInstance().getToken();
                            Map<String,Object> tokenMap = new HashMap<>();
                            tokenMap.put("tokenId",tokenId);


                            firebaseFirestore.collection("userInfo").document(userID).set(tokenMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){

                                        Toast.makeText(SignUpActivity.this, "Successfull", Toast.LENGTH_LONG).show();

                                        startActivity(new Intent(SignUpActivity.this,MainActivity.class));
                                    }
                                }
                            });


                        }
                    });
                }
                
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}