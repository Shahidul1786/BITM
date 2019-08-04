package com.example.tourmate;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.tourmate.Interface.AuthenticationListiner_;
import com.example.tourmate.databinding.ActivityAuthenticateBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthenticationActivity extends AppCompatActivity implements AuthenticationListiner_ {

    private FirebaseAuth auth;
    private FirebaseUser user;
    private ActivityAuthenticateBinding binding;
    private FragmentManager fragmentManager;
    private LoginFragment loginFragment;
    private SignupFragment signupFragment;
    private ProfileEditFragment profileEditFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticate);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_authenticate);

        loginFragment = new LoginFragment();
        profileEditFragment = new ProfileEditFragment();
        signupFragment = new SignupFragment();
        auth = FirebaseAuth.getInstance();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.authContiners,loginFragment)
                .commit();
        user = auth.getCurrentUser();
        if(user !=null){
            goToPtofile();
        }else {

          goToLogin();
        }


    }
    @Override
    public void goToPtofile() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.authContiners,profileEditFragment)
                .commit();
    }

    @Override
    public void goToLogin() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.authContiners,loginFragment)
                .commit();
    }

    @Override
    public void goToSignUp() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.authContiners,signupFragment)
                .addToBackStack(null)
                .commit();
    }
}
