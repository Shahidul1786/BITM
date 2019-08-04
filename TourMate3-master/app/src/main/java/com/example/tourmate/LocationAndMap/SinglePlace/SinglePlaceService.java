package com.example.tourmate.LocationAndMap.SinglePlace;
import com.example.tourmate.LocationAndMap.NearbySearch.NearbyPojo.NearbyResponse;
import com.example.tourmate.LocationAndMap.SinglePlace.Pojo.SinglePlace;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface SinglePlaceService {
    @GET
    Call<SinglePlace>getsinglePlaces(@Url String endUrl);
}
