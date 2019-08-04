package com.example.tourmate;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tourmate.Adapters.MemberAdapter;
import com.example.tourmate.Interface.EventHandelActivityToFragmentListiner;
import com.example.tourmate.Interface.OnTestInterface;
import com.example.tourmate.PojoClass.StaticData;
import com.example.tourmate.databinding.FragmentMembersBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MembersFragment extends Fragment implements OnTestInterface, EventHandelActivityToFragmentListiner {

    private FragmentMembersBinding binding;
    private RecyclerView recyclerView;
    private MemberAdapter adapter;
    private DatabaseReference eventRef;
    private DatabaseReference memberListRef;
    private ArrayList<String> userIdList = new ArrayList<>();
    public MembersFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_members,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        eventRef = FirebaseDatabase.getInstance().getReference().child("Event");
        if(!StaticData.eventID.equals("NA")){
            memberListRef = eventRef.child(StaticData.eventID).child("MemberList");
            memberListRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    userIdList.clear();
                    for(DataSnapshot d:dataSnapshot.getChildren()){
                        HashMap<String,String> map = (HashMap<String, String>) d.getValue();
                        userIdList.add(map.get("UserID"));
                    }
                    recyclerView = binding.memberRecycler;
                   // Toast.makeText(getActivity(), userIdList.toString(), Toast.LENGTH_SHORT).show();
                    adapter = new MemberAdapter(getActivity(),userIdList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }

    @Override
    public void test() {

    }

    @Override
    public void getActivityStatus(String status) {
        if(!StaticData.eventID.equals("NA")) {
            BottomSheetSelectMember selectMember = new BottomSheetSelectMember();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("eventuserlist", userIdList);
            selectMember.setArguments(bundle);
            selectMember.show(getChildFragmentManager(), "selectmember");
        }else {
            Toast.makeText(getActivity(),"Event is not save", Toast.LENGTH_SHORT).show();
        }

    }
}
