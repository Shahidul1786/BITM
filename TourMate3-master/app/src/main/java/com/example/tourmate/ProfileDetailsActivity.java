package com.example.tourmate;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tourmate.databinding.ActivityProfileDetailsBinding;

public class ProfileDetailsActivity extends AppCompatActivity {

    private ActivityProfileDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);
        binding = DataBindingUtil
                .setContentView(ProfileDetailsActivity.this,
                        R.layout.activity_profile_details);


    }
}
