package com.example.savethefood.Food;

import android.util.Log;

import com.example.savethefood.Food.Model.FoodInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class getFoodInfo {
    private FoodAPI ApiBarcode;
    private Retrofit retrofit;
    private String barcode;
    private FoodInfo request;

    public getFoodInfo(String baseUrl, String barcode)
    {
        retrofit = new Retrofit.Builder()
                .baseUrl("baseUrl")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBarcode = retrofit.create(FoodAPI.class);
        this.barcode = barcode;
    }

    public FoodInfo getRequest()
    {
        retrieveInfo();
        return request;
    }

    public void retrieveInfo(){
        Call<FoodInfo> call = ApiBarcode.getPosts(barcode.toString());

        call.enqueue(new Callback<FoodInfo>() {
            @Override
            public void onResponse(Call<FoodInfo> call, Response<FoodInfo> response) {
                if (response.isSuccessful())
                {
                    request = response.body();
                }
                else
                {
                    Log.d("MainFail","Niet Succesfull" +response.code());
                }
            }

            @Override
            public void onFailure(Call<FoodInfo> call, Throwable t) {
                Log.d("MainFail","Niet gelukt" + t.getMessage());
            }
        });
    }
}
