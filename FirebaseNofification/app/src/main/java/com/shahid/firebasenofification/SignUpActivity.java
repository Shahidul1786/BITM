package com.shahid.firebasenofification;

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

    private EditText nameET,emailET,passwordET;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private Button signup;
    private TextView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        init();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameET.getText().toString().trim();
                String email = emailET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();

                if (name.isEmpty()&& email.isEmpty() && password.isEmpty()){

                    Toast.makeText(SignUpActivity.this, "fields are empty", Toast.LENGTH_SHORT).show();


                }else {
                    signUP(name,email,password);
                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
            }
        });


    }

    private void signUP(final String name, final String email, String password) {

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            if (task.isSuccessful()){

                String userId =firebaseAuth.getCurrentUser().getUid();

                DatabaseReference userRef = databaseReference.child("userInfo").child(userId);

                HashMap<String,Object> userMap = new HashMap<>();
                userMap.put("name",name);
                userMap.put("email",email);

                userRef.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()){
                            startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
                        }

                    }
                });

            }
            else {
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
        passwordET =findViewById(R.id.passwordETID);
        signup = findViewById(R.id.signUpBTN);
        signin = findViewById(R.id.signinTVID);

    }
}
