package com.example.tourmate;


import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tourmate.Interface.AuthenticationListiner_;
import com.example.tourmate.databinding.FragmentLoginBinding;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginFragment extends Fragment {
    private static final int RC_SIGN_IN = 114;
    private AuthenticationListiner_ authenticationListiner;
    private FragmentLoginBinding binding;
    private EditText emailET;
    private EditText passwordET;
    private Button loginBtn;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private GoogleSignInClient googleSignInClient;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        authenticationListiner = (AuthenticationListiner_) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        emailET = binding.emailET;
        passwordET = binding.passwordET;
        loginBtn = binding.loginBtn;

        auth = FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleLogin();
            }
        });




        binding.CreateAccountTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authenticationListiner.goToSignUp();
            }
        });


    }
    private void simpleLogin(){
        if(emailET.getText().toString().isEmpty()){
            emailET.setError(getString(R.string.required_field));
        }
        if(passwordET.getText().toString().isEmpty()){
            passwordET.setError(getString(R.string.required_field));
        }
        if(!emailET.getText().toString().isEmpty() && !passwordET.getText().toString().isEmpty()) {
            auth.signInWithEmailAndPassword(emailET.getText().toString(), passwordET.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                user = auth.getCurrentUser();
                                if (user!=null){
                                    Intent intent = new Intent(getActivity(), MainActivity.class);
                                    startActivity(intent);
                                }else {
                                    goToEditProfile();
                                }
                                //Toast.makeText(getActivity(), auth.getCurrentUser().getUid(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getActivity(), "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private void goToEditProfile() {
        authenticationListiner.goToPtofile();
    }





}
