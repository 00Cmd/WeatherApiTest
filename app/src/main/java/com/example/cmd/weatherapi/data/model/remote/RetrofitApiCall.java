package com.example.cmd.weatherapi.data.model.remote;

import com.example.cmd.weatherapi.data.model.SOAnwserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cmd on 8.03.18.
 */

public interface RetrofitApiCall {
    @GET("answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnwserResponse> getAnswer();

    @GET("answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnwserResponse> getAnwser(@Query("tagger") String tag);
}
