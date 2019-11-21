package com.raulfm.drinkit.api_request;

import com.raulfm.drinkit.model.Drinks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitController {
    @GET("lookup.php")
    Call<Drinks> getDrinkById(@Query("i") long id);

    @GET("random.php")
    Call<Drinks> getRandomDrink();
}