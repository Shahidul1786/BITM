package com.example.tourmate;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.tourmate.Adapters.MomentAdapter;
import com.example.tourmate.Interface.EventHandelActivityToFragmentListiner;
import com.example.tourmate.PojoClass.Moment;
import com.example.tourmate.PojoClass.StaticData;
import com.example.tourmate.databinding.FragmentMomentBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MomentFragment extends Fragment implements EventHandelActivityToFragmentListiner {

    private FragmentMomentBinding binding;
    private RecyclerView recyclerView;
    private MomentAdapter adapter;
    private DatabaseReference momentRef;
    private List<Moment> momentList =new ArrayList<>();
    public MomentFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil
                .inflate(inflater,R.layout.fragment_moment,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        momentRef = FirebaseDatabase.getInstance()
                .getReference()
                .child("Event")
                .child(StaticData.eventID)
                .child("Moments");
        momentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                momentList.clear();
                for(DataSnapshot d:dataSnapshot.getChildren()){
                    Moment moment = d.getValue(Moment.class);
                    momentList.add(moment);
                }
                recyclerView = binding.momentRecycler;
                adapter = new MomentAdapter(getActivity(), momentList);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void getActivityStatus(String status) {
        if(!StaticData.eventID.equals("NA")) {
            BottomSheetMomentFragment momentFragment = new BottomSheetMomentFragment();
            momentFragment.show(getChildFragmentManager(), "moment");
        }else {
            Toast.makeText(getActivity(), "Event is not save", Toast.LENGTH_SHORT).show();
        }
    }
}
