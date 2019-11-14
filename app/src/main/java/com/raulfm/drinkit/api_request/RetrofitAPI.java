package com.raulfm.drinkit.api_request;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.raulfm.drinkit.api_request.ApiConstants.API_SERVER_URL;

public class RetrofitAPI {
    public Retrofit retrofit;
    public RetrofitController retrofitController;
    public RetrofitAPI(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(API_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.retrofitController = retrofit.create(RetrofitController.class);
    }
}
