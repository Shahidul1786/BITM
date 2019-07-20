package com.shahid.day23firebaseauthemailpassword;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    private EditText nameET,emailET,passwordET,confirmPasswordET;
    private Button signUpBTN;
    private TextView signInTV;
   // private String name,email,password,cPassword;

    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        init();

        signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String  name = nameET.getText().toString().trim();
                String  email = emailET.getText().toString().trim();
                String  password = passwordET.getText().toString().trim();
                String  cPassword = confirmPasswordET.getText().toString().trim();

                if (password.equals(cPassword)){

                    signUp(name,email,password);

                }else {

                }


            }
        });

        signInTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });


    }

    private void signUp(final String name, final String email, String password) {

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    String userId =firebaseAuth.getCurrentUser().getUid();

                    DatabaseReference userRef = databaseReference.child("users").child(userId);

                    HashMap<String,Object> userMap = new HashMap<>();
                    userMap.put("name",name);
                    userMap.put("email",email);

                    userRef.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()){
                                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                            }
                        }
                    });


                }else {
                    Toast.makeText(SignUpActivity.this, "something is wrong", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void init() {

        databaseReference = FirebaseDatabase.getInstance().getReference();

        firebaseAuth = FirebaseAuth.getInstance();

        nameET = findViewById(R.id.nameETID);

        emailET = findViewById(R.id.emailETID);
        passwordET = findViewById(R.id.passwordETID);
        signUpBTN = findViewById(R.id.signUpBTNID);
        signInTV = findViewById(R.id.signInTVID);
        confirmPasswordET = findViewById(R.id.confirmPasswordETID);

    }
}
