package com.example.savethefood.Food.Model;

import com.google.gson.annotations.SerializedName;

public class ImageFrontItem {
    @SerializedName("fr")
    private String url;

    public String getUrl() {
        return url;
    }
}
