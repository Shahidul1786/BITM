package com.example.tourmate.Interface;

import com.example.tourmate.LocationAndMap.NearbySearch.NearbyPojo.Result;

import java.util.List;

public interface NearbyBottomSheetListiner {
    void getNearbyObject(List<Result> resultList);
}
