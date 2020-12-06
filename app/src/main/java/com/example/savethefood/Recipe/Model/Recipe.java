package com.example.savethefood.Recipe.Model;

import com.google.gson.annotations.SerializedName;

public class Recipe {
    @SerializedName("image")
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
