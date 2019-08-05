package com.example.tourmate;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tourmate.Interface.NearbyBottomSheetListiner;
import com.example.tourmate.LocationAndMap.NearbySearch.NearbyPojo.Result;
import com.example.tourmate.databinding.BottomSheetFagmentNearbyBinding;

import java.util.List;

public class BottomSheetNearbyFragment  extends BottomSheetDialogFragment implements NearbyBottomSheetListiner {

    private BottomSheetFagmentNearbyBinding binding;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil
                .inflate(inflater,R.layout.bottom_sheet_fagment_nearby,container,false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void getNearbyObject(List<Result> resultList) {
        Toast.makeText(getActivity(), "ok work", Toast.LENGTH_SHORT).show();
    }
}
