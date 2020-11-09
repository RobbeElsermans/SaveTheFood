package com.example.savethefood;

import com.google.gson.annotations.SerializedName;

public class Recipe {
    @SerializedName("uri")
    private String uri;

    public String getUri() {
        return uri;
    }

    @SerializedName("label")
    private String label;

    public String getLabel() {
        return label;
    }
}
