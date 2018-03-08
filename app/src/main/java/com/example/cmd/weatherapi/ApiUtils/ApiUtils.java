package com.example.cmd.weatherapi.ApiUtils;

import com.example.cmd.weatherapi.REST.RetrofitCLient;
import com.example.cmd.weatherapi.data.model.remote.RetrofitApiCall;

/**
 * Created by cmd on 8.03.18.
 */

public class ApiUtils {

    public static final String getBaseUrl = "https://api.stackexchange.com/2.2/";

    public static RetrofitApiCall getClient() {
        return RetrofitCLient.getClient(getBaseUrl).create(RetrofitApiCall.class);
    }
}
