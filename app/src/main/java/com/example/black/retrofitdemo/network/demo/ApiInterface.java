package com.example.black.retrofitdemo.network.demo;

import com.example.black.retrofitdemo.Model.HeadlineResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by BLACK on 14/06/2017.
 */

public interface ApiInterface {
    @GET("v1/articles")
    Call<HeadlineResponse> getData(

    @Query("source") String source,
        @Query("sortBy") String sortBy,
        @Query("apiKey") String apiKey
    );

}

