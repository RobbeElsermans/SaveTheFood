package com.example.savethefood;

import com.google.gson.annotations.SerializedName;

public class BarcodeInfo {
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

class Product {

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

class NutriLevels{
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

class Nutri {


    @SerializedName("nutrition-score-fr_100g")

    private double nutritionScoreFr100g;
    @SerializedName("fat_serving")

    private double fatServing;
    @SerializedName("iron_serving")

    private double ironServing;
    @SerializedName("saturated-fat")

    private double saturatedFat;
    @SerializedName("calcium_value")

    private double calciumValue;
    @SerializedName("salt_serving")

    private double saltServing;
    @SerializedName("energy-kcal_value")

    private double energyKcalValue;
    @SerializedName("fiber_value")

    private double fiberValue;
    @SerializedName("fiber_unit")

    private String fiberUnit;
    @SerializedName("sugars_unit")

    private String sugarsUnit;
    @SerializedName("fiber")

    private double fiber;
    @SerializedName("fat_value")

    private double fatValue;
    @SerializedName("sodium_value")

    private double sodiumValue;
    @SerializedName("carbohydrates")

    private double carbohydrates;
    @SerializedName("trans-fat")

    private double transFat;
    @SerializedName("vitamin-a")

    private double vitaminA;
    @SerializedName("salt")

    private double salt;
    @SerializedName("proteins_unit")

    private String proteinsUnit;
    @SerializedName("iron")

    private double iron;
    @SerializedName("carbohydrates_serving")

    private double carbohydratesServing;
    @SerializedName("vitamin-a_unit")

    private String vitaminAUnit;
    @SerializedName("proteins_serving")

    private double proteinsServing;
    @SerializedName("saturated-fat_unit")

    private String saturatedFatUnit;
    @SerializedName("sugars_serving")

    private double sugarsServing;
    @SerializedName("vitamin-a_serving")

    private double vitaminAServing;
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_100g")

    private double fruitsVegetablesNutsEstimateFromIngredients100g;
    @SerializedName("energy-kcal_unit")

    private String energyKcalUnit;
    @SerializedName("calcium_unit")

    private String calciumUnit;
    @SerializedName("sugars_value")

    private double sugarsValue;
    @SerializedName("nova-group_100g")

    private double novaGroup100g;
    @SerializedName("sodium_unit")

    private String sodiumUnit;
    @SerializedName("carbohydrates_100g")

    private double carbohydrates100g;
    @SerializedName("cholesterol_serving")

    private double cholesterolServing;
    @SerializedName("vitamin-c_serving")

    private double vitaminCServing;
    @SerializedName("iron_unit")

    private String ironUnit;
    @SerializedName("proteins_value")

    private double proteinsValue;
    @SerializedName("nutrition-score-fr")

    private double nutritionScoreFr;
    @SerializedName("trans-fat_serving")

    private double transFatServing;
    @SerializedName("carbohydrates_unit")

    private String carbohydratesUnit;
    @SerializedName("trans-fat_unit")

    private String transFatUnit;
    @SerializedName("iron_100g")

    private double iron100g;
    @SerializedName("trans-fat_100g")

    private double transFat100g;
    @SerializedName("sugars")

    private double sugars;
    @SerializedName("salt_value")

    private double saltValue;
    @SerializedName("proteins")

    private double proteins;
    @SerializedName("energy-kcal_serving")

    private double energyKcalServing;
    @SerializedName("nova-group")

    private double novaGroup;
    @SerializedName("vitamin-a_100g")

    private double vitaminA100g;
    @SerializedName("fat_unit")

    private String fatUnit;
    @SerializedName("salt_unit")

    private String saltUnit;
    @SerializedName("saturated-fat_value")

    private double saturatedFatValue;
    @SerializedName("cholesterol_value")

    private double cholesterolValue;
    @SerializedName("carbohydrates_value")

    private double carbohydratesValue;
    @SerializedName("energy-kcal")

    private double energyKcal;
    @SerializedName("fiber_serving")

    private double fiberServing;
    @SerializedName("energy_value")

    private double energyValue;
    @SerializedName("salt_100g")

    private double salt100g;
    @SerializedName("nova-group_serving")

    private double novaGroupServing;
    @SerializedName("vitamin-c")

    private double vitaminC;
    @SerializedName("cholesterol_unit")

    private String cholesterolUnit;
    @SerializedName("calcium_100g")

    private double calcium100g;
    @SerializedName("energy")

    private double energy;
    @SerializedName("cholesterol")

    private double cholesterol;
    @SerializedName("iron_value")

    private double ironValue;
    @SerializedName("vitamin-c_unit")

    private String vitaminCUnit;
    @SerializedName("sugars_100g")

    private double sugars100g;
    @SerializedName("energy_100g")

    private double energy100g;
    @SerializedName("energy_serving")

    private double energyServing;
    @SerializedName("vitamin-a_value")

    private double vitaminAValue;
    @SerializedName("saturated-fat_serving")

    private double saturatedFatServing;
    @SerializedName("vitamin-c_value")

    private double vitaminCValue;
    @SerializedName("fat")

    private double fat;
    @SerializedName("calcium_serving")

    private double calciumServing;
    @SerializedName("calcium")

    private double calcium;
    @SerializedName("fat_100g")

    private double fat100g;
    @SerializedName("fiber_100g")

    private double fiber100g;
    @SerializedName("saturated-fat_100g")

    private double saturatedFat100g;
    @SerializedName("energy-kcal_100g")

    private double energyKcal100g;
    @SerializedName("trans-fat_value")

    private double transFatValue;
    @SerializedName("sodium_serving")

    private double sodiumServing;
    @SerializedName("nutrition-score-fr_serving")

    private double nutritionScoreFrServing;
    @SerializedName("sodium")

    private double sodium;
    @SerializedName("energy_unit")

    private String energyUnit;
    @SerializedName("cholesterol_100g")

    private double cholesterol100g;
    @SerializedName("sodium_100g")

    private double sodium100g;
    @SerializedName("proteins_100g")

    private double proteins100g;
    @SerializedName("vitamin-c_100g")

    private double vitaminC100g;

    public double getNutritionScoreFr100g() {
        return nutritionScoreFr100g;
    }

    public double getFatServing() {
        return fatServing;
    }

    public double getIronServing() {
        return ironServing;
    }


    public double getSaturatedFat() {
        return saturatedFat;
    }


    public double getCalciumValue() {
        return calciumValue;
    }


    public double getSaltServing() {
        return saltServing;
    }

    public double getEnergyKcalValue() {
        return energyKcalValue;
    }


    public double getFiberValue() {
        return fiberValue;
    }

    public String getFiberUnit() {
        return fiberUnit;
    }


    public String getSugarsUnit() {
        return sugarsUnit;
    }


    public double getFiber() {
        return fiber;
    }


    public double getFatValue() {
        return fatValue;
    }

    public double getSodiumValue() {
        return sodiumValue;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }


    public double getTransFat() {
        return transFat;
    }

    public double getVitaminA() {
        return vitaminA;
    }


    public double getSalt() {
        return salt;
    }


    public String getProteinsUnit() {
        return proteinsUnit;
    }


    public double getIron() {
        return iron;
    }


    public double getCarbohydratesServing() {
        return carbohydratesServing;
    }


    public String getVitaminAUnit() {
        return vitaminAUnit;
    }


    public double getProteinsServing() {
        return proteinsServing;
    }

    public String getSaturatedFatUnit() {
        return saturatedFatUnit;
    }

    public double getSugarsServing() {
        return sugarsServing;
    }

    public double getVitaminAServing() {
        return vitaminAServing;
    }

    public double getFruitsVegetablesNutsEstimateFromIngredients100g() {
        return fruitsVegetablesNutsEstimateFromIngredients100g;
    }

    public String getEnergyKcalUnit() {
        return energyKcalUnit;
    }

    public String getCalciumUnit() {
        return calciumUnit;
    }

    public double getSugarsValue() {
        return sugarsValue;
    }

    public double getNovaGroup100g() {
        return novaGroup100g;
    }


    public String getSodiumUnit() {
        return sodiumUnit;
    }

    public double getCarbohydrates100g() {
        return carbohydrates100g;
    }

    public double getCholesterolServing() {
        return cholesterolServing;
    }

    public double getVitaminCServing() {
        return vitaminCServing;
    }

    public String getIronUnit() {
        return ironUnit;
    }

    public double getProteinsValue() {
        return proteinsValue;
    }


    public double getNutritionScoreFr() {
        return nutritionScoreFr;
    }


    public double getTransFatServing() {
        return transFatServing;
    }

    public String getCarbohydratesUnit() {
        return carbohydratesUnit;
    }


    public String getTransFatUnit() {
        return transFatUnit;
    }


    public double getIron100g() {
        return iron100g;
    }


    public double getTransFat100g() {
        return transFat100g;
    }


    public double getSugars() {
        return sugars;
    }


    public double getSaltValue() {
        return saltValue;
    }

    public double getProteins() {
        return proteins;
    }

    public double getEnergyKcalServing() {
        return energyKcalServing;
    }


    public double getNovaGroup() {
        return novaGroup;
    }

    public double getVitaminA100g() {
        return vitaminA100g;
    }


    public String getFatUnit() {
        return fatUnit;
    }

    public String getSaltUnit() {
        return saltUnit;
    }


    public double getSaturatedFatValue() {
        return saturatedFatValue;
    }

    public double getCholesterolValue() {
        return cholesterolValue;
    }


    public double getCarbohydratesValue() {
        return carbohydratesValue;
    }

    public double getEnergyKcal() {
        return energyKcal;
    }


    public double getFiberServing() {
        return fiberServing;
    }

    public double getEnergyValue() {
        return energyValue;
    }


    public double getSalt100g() {
        return salt100g;
    }

    public double getNovaGroupServing() {
        return novaGroupServing;
    }


    public double getVitaminC() {
        return vitaminC;
    }

    public String getCholesterolUnit() {
        return cholesterolUnit;
    }

    public double getCalcium100g() {
        return calcium100g;
    }

    public double getEnergy() {
        return energy;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public double getIronValue() {
        return ironValue;
    }

    public String getVitaminCUnit() {
        return vitaminCUnit;
    }

    public double getSugars100g() {
        return sugars100g;
    }

    public double getEnergy100g() {
        return energy100g;
    }

    public double getEnergyServing() {
        return energyServing;
    }

    public double getVitaminAValue() {
        return vitaminAValue;
    }

    public double getSaturatedFatServing() {
        return saturatedFatServing;
    }


    public double getVitaminCValue() {
        return vitaminCValue;
    }


    public double getFat() {
        return fat;
    }


    public double getCalciumServing() {
        return calciumServing;
    }


    public double getCalcium() {
        return calcium;
    }

    public double getFat100g() {
        return fat100g;
    }

    public double getFiber100g() {
        return fiber100g;
    }

    public double getSaturatedFat100g() {
        return saturatedFat100g;
    }

    public double getEnergyKcal100g() {
        return energyKcal100g;
    }

    public double getTransFatValue() {
        return transFatValue;
    }


    public double getSodiumServing() {
        return sodiumServing;
    }


    public double getNutritionScoreFrServing() {
        return nutritionScoreFrServing;
    }


    public double getSodium() {
        return sodium;
    }


    public String getEnergyUnit() {
        return energyUnit;
    }

    public double getCholesterol100g() {
        return cholesterol100g;
    }

    public double getSodium100g() {
        return sodium100g;
    }

    public double getProteins100g() {
        return proteins100g;
    }

    public double getVitaminC100g() {
        return vitaminC100g;
    }
}

class NutriScoreData {

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

class Images {
    @SerializedName("front")
    private ImageFont imageFonts;

    public ImageFont getImageFonts() {
        return imageFonts;
    }
}

class ImageFont {
    @SerializedName("small")
    private ImageFrontItem imageFontSmall;

    public ImageFrontItem getImageFontSmall() {
        return imageFontSmall;
    }

    @SerializedName("thumb")
    private ImageFrontItem imageFontThumb;

    public ImageFrontItem getImageFontThumb() {
        return imageFontThumb;
    }

    @SerializedName("display")
    private ImageFrontItem imageFontDisplay;

    public ImageFrontItem getImageFontDisplay() {
        return imageFontDisplay;
    }
}

class ImageFrontItem {
    @SerializedName("fr")
    private String url;

    public String getUrl() {
        return url;
    }
}
