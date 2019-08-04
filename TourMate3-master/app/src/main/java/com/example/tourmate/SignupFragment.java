package com.example.tourmate;


import android.app.ProgressDialog;
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
import android.widget.Toast;

import com.example.tourmate.Interface.AuthenticationListiner_;
import com.example.tourmate.databinding.FragmentSignipBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignupFragment extends Fragment {

    private FragmentSignipBinding binding;
    private FirebaseAuth auth;
    private AuthenticationListiner_ authenticationListiner;
    private ProgressDialog dialog;
    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =
                DataBindingUtil.inflate(inflater,R.layout.fragment_signip, container, false);
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
        dialog = new ProgressDialog(getActivity());
        auth = FirebaseAuth.getInstance();
        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setMessage("Please Wait");
                dialog.show();
                String name = binding.nameET.getText().toString();
                String phone = binding.phoneET.getText().toString();


                if(name.isEmpty()){
                    binding.nameET.setError(getString(R.string.required_field));
                }
                if(phone.isEmpty()){
                    binding.phoneET.setError(getString(R.string.required_field));
                }

                if(!name.isEmpty() && !phone.isEmpty()){
                    Intent intent = new Intent(getActivity(),LoginFragment.class);
                }
            }
        });
    }
}
