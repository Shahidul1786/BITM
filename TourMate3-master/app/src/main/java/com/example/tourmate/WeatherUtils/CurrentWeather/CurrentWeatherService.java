package com.example.tourmate.WeatherUtils.CurrentWeather;

import com.example.tourmate.WeatherUtils.CurrentWeather.CurrentWeatherPojo.CurrentWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CurrentWeatherService {
    @GET
    Call<CurrentWeather> getCurrentWeather(@Url String endUrl);
}
