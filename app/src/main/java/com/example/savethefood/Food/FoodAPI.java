package com.example.savethefood.Food;

import com.example.savethefood.Food.Model.FoodInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FoodAPI {
    @GET("{barcode}")
    Call<FoodInfo> getPosts(@Path("barcode") String barcode);
}
