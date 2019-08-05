package com.example.tourmate.LocationAndMap.NearbySearch;
import com.example.tourmate.LocationAndMap.NearbySearch.NearbyPojo.NearbyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NearbyService {
    @GET
    Call<NearbyResponse>getNearbyPlaces(@Url String endUrl);
}
