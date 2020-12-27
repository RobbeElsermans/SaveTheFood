package com.example.savethefood.Food.Model;

import com.google.gson.annotations.SerializedName;

public class NutriLevels{
    @SerializedName("saturated-fat")
    private String saturated_fat;
    @SerializedName("sugars")
    private String sugars;
    @SerializedName("salt")
    private String salt;
    @SerializedName("fat")
    private String fat;

    public String getFat() {
        return fat;
    }

    public String getSalt() {
        return salt;
    }

    public String getSugars() {
        return sugars;
    }

    public String getSaturated_fat() {
        return saturated_fat;
    }
}
