package com.example.savethefood.Food.Model;

import com.google.gson.annotations.SerializedName;

public class FoodInfo {
    @SerializedName("status_verbose")
    private String mStatus_verbose;
    @SerializedName("code")
    private String mBarcode;
    @SerializedName("status")
    private double mStatus;
    @SerializedName("product")
    private Product product;


    public String getStatusVerbose() {
        return mStatus_verbose;
    }

    public String getBarCode() {
        return mBarcode;
    }

    public double getStatus() {
        return mStatus;
    }
    public Product getProduct() {
        return product;
    }
}

