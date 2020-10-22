package com.example.savethefood;

import com.google.gson.annotations.SerializedName;

public class BarcodeInfo {
    @SerializedName("status_verbose")
    private String mStatus_verbose;
    @SerializedName("code")
    private String mBarcode;
    @SerializedName("status")
    private int mStatus;

    public String getStatusVerbose() {
        return mStatus_verbose;
    }

    public String getBarCode() {
        return mBarcode;
    }

    public int getStatus() {
        return mStatus;
    }
}
