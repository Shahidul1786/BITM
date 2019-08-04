package com.example.tourmate;


import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tourmate.Adapters.EventAdapter;
import com.example.tourmate.DatabaseUtils.EventDataStaice;
import com.example.tourmate.DatabaseUtils.EventLoader;
import com.example.tourmate.Interface.EventObjectListiner;
import com.example.tourmate.Interface.LoadEventListiner;
import com.example.tourmate.PojoClass.Event;
import com.example.tourmate.PojoClass.EventMember;
import com.example.tourmate.PojoClass.StaticData;
import com.example.tourmate.databinding.FragmentEventBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventFragment extends Fragment  {
    private DatabaseReference databaseReference;
    private DatabaseReference eventRef;

    private FragmentEventBinding binding;
    private RecyclerView recyclerView;
    private EventAdapter adapter;
    private List<Event> eventList = new ArrayList<>();
    private List<EventMember> memberList = new ArrayList<>();
    private ProgressDialog dialog;
    private FirebaseAuth auth;
    private FirebaseUser user;
    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil
                .inflate(inflater,R.layout.fragment_event,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        eventRef = databaseReference.child("Event");
        dialog = new ProgressDialog(getActivity());
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        recyclerView = binding.eventRecycler;
        firebaseEventget();
        binding.addEvaentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),EventActivity.class);

               StaticData.eventID ="NA";
               startActivity(intent);
            }
        });




    }
    private void firebaseEventget(){
        dialog.setMessage("Loading..");
       // dialog.show();
        binding.progressBarloading.setVisibility(View.VISIBLE);
        eventRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                eventList.clear();
                for(DataSnapshot d :dataSnapshot.getChildren()){
                    Event eventDetailsObj = d.getValue(Event.class);

                    memberList.clear();
                    for(DataSnapshot dd :d.child("MemberList").getChildren()){
                        EventMember member = dd.getValue(EventMember.class);
                        memberList.add(member);
                    }

                    if(memberList.toString().contains(user.getUid().toString())){
                        eventList.add(eventDetailsObj);
                    }

                }


                binding.progressBarloading.setVisibility(View.GONE);
                //dialog.dismiss();
                if(eventList.size()==0){
                    binding.addeventstatusLayout.setVisibility(View.VISIBLE);
                }else {
                    binding.addeventstatusLayout.setVisibility(View.GONE);
                    recyclerView.setAdapter(new EventAdapter(getActivity(),eventList));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
            //    Toast.makeText(getActivity(), String.valueOf(eventList.size()), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                binding.progressBarloading.setVisibility(View.GONE);
               // dialog.dismiss();
            }
        });

    }
}
