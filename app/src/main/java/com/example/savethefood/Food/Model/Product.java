package com.example.savethefood.Food.Model;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("product_name")
    private String name;

    public String getName() {
        return name;
    }

    @SerializedName("image_url")
    private String image_url;

    public String getImage_url() {
        return image_url;
    }

    @SerializedName("image_front_small_url")
    private String image_url_small;

    public String getImage_url_small() {
        return image_url_small;
    }

    @SerializedName("selected_images")
    private Images image_selection;

    public Images getImage_selection() {
        return image_selection;
    }

    @SerializedName("nutriscore_data")
    private NutriScoreData nutriscore_data;

    public NutriScoreData getNutriscore_data() {
        return nutriscore_data;
    }

    @SerializedName("nutriments")
    private Nutri nutriments;

    public Nutri getNutriments() {
        return nutriments;
    }

    @SerializedName("categories_tags")
    private String[] categories_tasg;

    public String[] getCategories_tasg() {
        return categories_tasg;
    }

    @SerializedName("nutrient_levels")
    private NutriLevels nutrient_levels;

    public NutriLevels getNutrient_levels() {
        return nutrient_levels;
    }

    @SerializedName("nutriscore_grade")
    private String nutriscore_grade;

    public String getNutriscore_grade() {
        return nutriscore_grade;
    }

    @SerializedName("nova_group")
    private double nova_group;

    public double getNova_group() {
        return nova_group;
    }
}
