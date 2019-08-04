package com.example.tourmate;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tourmate.databinding.ActivityVerifyBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class VerifyActivity extends AppCompatActivity {


    private String phoneNo;
    private String verificationId;
    private FirebaseAuth mAuth;

    private ActivityVerifyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_verify);

        mAuth = FirebaseAuth.getInstance();
        phoneNo = getIntent().getStringExtra("phone");

        sendOTP();

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String code = binding.phoneVerifyET.getText().toString();

                if (code.length() == 6){
                    verify(code);
                }
            }
        });
    }

    private void sendOTP() {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
               "+88"+ phoneNo,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacksPhoneAuthActivity.java


    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            String code = phoneAuthCredential.getSmsCode();

            if (code != null){

                binding.phoneVerifyET.setText(code);
                verify(code);

            }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

            Toast.makeText(VerifyActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verificationId = s;
        }
    };

    private void verify(String code) {

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId,code);

        signInWithPhoneAuthCredential(credential);


    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {

        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Intent intent = new Intent(VerifyActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(VerifyActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
