package com.example.savethefood;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FoodAPI {
    @GET("{barcode}")
    Call<BarcodeInfo> getPosts(@Path("barcode") String barcode);
}
