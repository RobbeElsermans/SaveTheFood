package com.example.savethefood.Food.Model;

import com.google.gson.annotations.SerializedName;

public class NutriScoreData {

    @SerializedName("grade")
    private String grade;

    public String getGrade() {
        return grade;
    }

    //Al de nutri waardes
    @SerializedName("proteins_value")
    private double proteins;
    @SerializedName("fiber_value")
    private double fiber;
    @SerializedName("sugars_value")
    private double sugars;
    @SerializedName("saturated_fat_value")
    private double saturated_fat;
    @SerializedName("saturated_fat_ratio_value")
    private double saturated_fat_ratio_value;
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils_value")
    private double fruits_vegetables_nuts_colza_walnut_olive_oils_value;
    @SerializedName("energy_value")
    private double energy_value;
    @SerializedName("sodium_value")
    private double sodium_value;

    public double getSodium_value() {
        return sodium_value;
    }

    public double getEnergy_value() {
        return energy_value;
    }

    public double getFruits_vegetables_nuts_colza_walnut_olive_oils_value() {
        return fruits_vegetables_nuts_colza_walnut_olive_oils_value;
    }

    public double getSaturated_fat_ratio_value() {
        return saturated_fat_ratio_value;
    }

    public double getSaturated_fat() {
        return saturated_fat;
    }

    public double getSugars() {
        return sugars;
    }

    public double getFiber() {
        return fiber;
    }

    public double getProteins() {
        return proteins;
    }

    //Al de booleans
    @SerializedName("is_cheese")
    private int is_cheese;
    @SerializedName("is_beverage")
    private int is_beverage;
    @SerializedName("is_fat")
    private int is_fat;
    @SerializedName("is_water")
    private String is_water;

    public String isIs_water() {
        return is_water;
    }

    public int isIs_fat() {
        return is_fat;
    }

    public int getIs_beverage() {
        return is_beverage;
    }

    public int getIs_cheese() {
        return is_cheese;
    }


    //Al de punten
    @SerializedName("score")
    private double score;
    @SerializedName("saturated_fat_ratio_points")
    private double saturated_fat_ratio_points;
    @SerializedName("positive_points")
    private double positive_points;
    @SerializedName("sodium_points")
    private double sodium_points;
    @SerializedName("proteins_points")
    private double proteins_points;
    @SerializedName("fiber_points")
    private double fiber_points;
    @SerializedName("energy_points")
    private double energy_points;
    @SerializedName("negative_points")
    private double negative_points;
    @SerializedName("sugars_points")
    private double sugars_points;
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils_points")
    private double fruits_vegetables_nuts_colza_walnut_olive_oils_points;
    @SerializedName("saturated_fat_points")
    private double saturated_fat_points;

    public double getSaturated_fat_points() {
        return saturated_fat_points;
    }

    public double getFruits_vegetables_nuts_colza_walnut_olive_oils_points() {
        return fruits_vegetables_nuts_colza_walnut_olive_oils_points;
    }

    public double getSugars_points() {
        return sugars_points;
    }

    public double getNegative_points() {
        return negative_points;
    }

    public double getEnergy_points() {
        return energy_points;
    }

    public double getFiber_points() {
        return fiber_points;
    }

    public double getProteins_points() {
        return proteins_points;
    }

    public double getSodium_points() {
        return sodium_points;
    }

    public double getPositive_points() {
        return positive_points;
    }

    public double getSaturated_fat_ratio_points() {
        return saturated_fat_ratio_points;
    }

    public double getScore() {
        return score;
    }
}
