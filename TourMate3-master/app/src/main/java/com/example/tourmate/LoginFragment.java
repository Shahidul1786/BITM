package com.example.tourmate;


import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tourmate.Interface.AuthenticationListiner_;
import com.example.tourmate.databinding.FragmentLoginBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class LoginFragment extends Fragment {
    private static final int RC_SIGN_IN = 114;
    private AuthenticationListiner_ authenticationListiner;
    private FragmentLoginBinding binding;
   private EditText phoneET;
   private String phoneNo;
    private Button nextBtn;
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
        phoneET = binding.phoneLogET;
        nextBtn = binding.nextBtnID;
        auth = FirebaseAuth.getInstance();
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               phoneNo = phoneET.getText().toString().trim();

               if (phoneNo.length() == 11){

                   Intent intent = new Intent(getActivity(),VerifyActivity.class);
                   intent.putExtra("phone",phoneNo);
                   startActivity(intent);
               }
               else {
                   Toast.makeText(getActivity(), "Invalid Phone Number", Toast.LENGTH_SHORT).show();
               }
            }
        });

        binding.CreateAccountTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authenticationListiner.goToSignUp();
            }
        });


    }


    private void goToEditProfile() {
        authenticationListiner.goToPtofile();
    }





}
