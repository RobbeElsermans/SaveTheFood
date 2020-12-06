package com.example.savethefood.Food;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIFood {
    private FoodAPI ApiBarcode;
    private Retrofit retrofit;
    private String barcode;
    private BarcodeInfo request;

    public APIFood(String baseUrl, String barcode)
    {
        retrofit = new Retrofit.Builder()
                .baseUrl("baseUrl")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBarcode = retrofit.create(FoodAPI.class);
        this.barcode = barcode;
    }

    public BarcodeInfo getRequest()
    {
        retrieveInfo();
        return request;
    }

    public void retrieveInfo(){
        Call<BarcodeInfo> call = ApiBarcode.getPosts(barcode.toString());

        call.enqueue(new Callback<BarcodeInfo>() {
            @Override
            public void onResponse(Call<BarcodeInfo> call, Response<BarcodeInfo> response) {
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
            public void onFailure(Call<BarcodeInfo> call, Throwable t) {
                Log.d("MainFail","Niet gelukt" + t.getMessage());
            }
        });
    }
}
