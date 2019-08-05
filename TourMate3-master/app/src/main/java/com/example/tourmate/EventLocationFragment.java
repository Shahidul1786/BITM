package com.example.tourmate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tourmate.Interface.EventHandelActivityToFragmentListiner;

public class EventLocationFragment extends Fragment implements EventHandelActivityToFragmentListiner {



    public EventLocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_location, container, false);
    }

    @Override
    public void getActivityStatus(String status) {

    }
}
