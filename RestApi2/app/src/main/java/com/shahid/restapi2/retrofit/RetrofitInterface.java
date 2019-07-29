package com.shahid.restapi2.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("comments")
    Call<List<User>> getUser(@Query("postId") int postId);


}
