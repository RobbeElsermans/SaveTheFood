package com.example.savethefood;

import com.google.gson.annotations.SerializedName;

public class BarcodeInfo {
    @SerializedName("status_verbose")
    private String mStatus_verbose;
    @SerializedName("code")
    private String mBarcode;
    @SerializedName("status")
    private int mStatus;
    @SerializedName("product")
    private Product product;


    public String getStatusVerbose() {
        return mStatus_verbose;
    }

    public String getBarCode() {
        return mBarcode;
    }

    public int getStatus() {
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
    private int nova_group;

    public int getNova_group() {
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

    private int nutritionScoreFr100g;
    @SerializedName("fat_serving")

    private int fatServing;
    @SerializedName("iron_serving")

    private double ironServing;
    @SerializedName("saturated-fat")

    private double saturatedFat;
    @SerializedName("calcium_value")

    private int calciumValue;
    @SerializedName("salt_serving")

    private double saltServing;
    @SerializedName("energy-kcal_value")

    private int energyKcalValue;
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

    private int sodiumValue;
    @SerializedName("carbohydrates")

    private double carbohydrates;
    @SerializedName("trans-fat")

    private int transFat;
    @SerializedName("vitamin-a")

    private double vitaminA;
    @SerializedName("salt")

    private double salt;
    @SerializedName("proteins_unit")

    private String proteinsUnit;
    @SerializedName("iron")

    private double iron;
    @SerializedName("carbohydrates_serving")

    private int carbohydratesServing;
    @SerializedName("vitamin-a_unit")

    private String vitaminAUnit;
    @SerializedName("proteins_serving")

    private int proteinsServing;
    @SerializedName("saturated-fat_unit")

    private String saturatedFatUnit;
    @SerializedName("sugars_serving")

    private int sugarsServing;
    @SerializedName("vitamin-a_serving")

    private double vitaminAServing;
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_100g")

    private int fruitsVegetablesNutsEstimateFromIngredients100g;
    @SerializedName("energy-kcal_unit")

    private String energyKcalUnit;
    @SerializedName("calcium_unit")

    private String calciumUnit;
    @SerializedName("sugars_value")

    private double sugarsValue;
    @SerializedName("nova-group_100g")

    private int novaGroup100g;
    @SerializedName("sodium_unit")

    private String sodiumUnit;
    @SerializedName("carbohydrates_100g")

    private double carbohydrates100g;
    @SerializedName("cholesterol_serving")

    private int cholesterolServing;
    @SerializedName("vitamin-c_serving")

    private int vitaminCServing;
    @SerializedName("iron_unit")

    private String ironUnit;
    @SerializedName("proteins_value")

    private double proteinsValue;
    @SerializedName("nutrition-score-fr")

    private int nutritionScoreFr;
    @SerializedName("trans-fat_serving")

    private int transFatServing;
    @SerializedName("carbohydrates_unit")

    private String carbohydratesUnit;
    @SerializedName("trans-fat_unit")

    private String transFatUnit;
    @SerializedName("iron_100g")

    private double iron100g;
    @SerializedName("trans-fat_100g")

    private int transFat100g;
    @SerializedName("sugars")

    private double sugars;
    @SerializedName("salt_value")

    private int saltValue;
    @SerializedName("proteins")

    private double proteins;
    @SerializedName("energy-kcal_serving")

    private int energyKcalServing;
    @SerializedName("nova-group")

    private int novaGroup;
    @SerializedName("vitamin-a_100g")

    private double vitaminA100g;
    @SerializedName("fat_unit")

    private String fatUnit;
    @SerializedName("salt_unit")

    private String saltUnit;
    @SerializedName("saturated-fat_value")

    private double saturatedFatValue;
    @SerializedName("cholesterol_value")

    private int cholesterolValue;
    @SerializedName("carbohydrates_value")

    private double carbohydratesValue;
    @SerializedName("energy-kcal")

    private int energyKcal;
    @SerializedName("fiber_serving")

    private double fiberServing;
    @SerializedName("energy_value")

    private int energyValue;
    @SerializedName("salt_100g")

    private double salt100g;
    @SerializedName("nova-group_serving")

    private int novaGroupServing;
    @SerializedName("vitamin-c")

    private int vitaminC;
    @SerializedName("cholesterol_unit")

    private String cholesterolUnit;
    @SerializedName("calcium_100g")

    private double calcium100g;
    @SerializedName("energy")

    private int energy;
    @SerializedName("cholesterol")

    private int cholesterol;
    @SerializedName("iron_value")

    private double ironValue;
    @SerializedName("vitamin-c_unit")

    private String vitaminCUnit;
    @SerializedName("sugars_100g")

    private double sugars100g;
    @SerializedName("energy_100g")

    private int energy100g;
    @SerializedName("energy_serving")

    private int energyServing;
    @SerializedName("vitamin-a_value")

    private int vitaminAValue;
    @SerializedName("saturated-fat_serving")

    private double saturatedFatServing;
    @SerializedName("vitamin-c_value")

    private int vitaminCValue;
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

    private int energyKcal100g;
    @SerializedName("trans-fat_value")

    private int transFatValue;
    @SerializedName("sodium_serving")

    private double sodiumServing;
    @SerializedName("nutrition-score-fr_serving")

    private int nutritionScoreFrServing;
    @SerializedName("sodium")

    private double sodium;
    @SerializedName("energy_unit")

    private String energyUnit;
    @SerializedName("cholesterol_100g")

    private int cholesterol100g;
    @SerializedName("sodium_100g")

    private double sodium100g;
    @SerializedName("proteins_100g")

    private double proteins100g;
    @SerializedName("vitamin-c_100g")

    private int vitaminC100g;

    public int getNutritionScoreFr100g() {
        return nutritionScoreFr100g;
    }

    public int getFatServing() {
        return fatServing;
    }

    public double getIronServing() {
        return ironServing;
    }


    public double getSaturatedFat() {
        return saturatedFat;
    }


    public int getCalciumValue() {
        return calciumValue;
    }


    public double getSaltServing() {
        return saltServing;
    }

    public int getEnergyKcalValue() {
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

    public int getSodiumValue() {
        return sodiumValue;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }


    public int getTransFat() {
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


    public int getCarbohydratesServing() {
        return carbohydratesServing;
    }


    public String getVitaminAUnit() {
        return vitaminAUnit;
    }


    public int getProteinsServing() {
        return proteinsServing;
    }

    public String getSaturatedFatUnit() {
        return saturatedFatUnit;
    }

    public int getSugarsServing() {
        return sugarsServing;
    }

    public double getVitaminAServing() {
        return vitaminAServing;
    }

    public int getFruitsVegetablesNutsEstimateFromIngredients100g() {
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

    public int getNovaGroup100g() {
        return novaGroup100g;
    }


    public String getSodiumUnit() {
        return sodiumUnit;
    }

    public double getCarbohydrates100g() {
        return carbohydrates100g;
    }

    public int getCholesterolServing() {
        return cholesterolServing;
    }

    public int getVitaminCServing() {
        return vitaminCServing;
    }

    public String getIronUnit() {
        return ironUnit;
    }

    public double getProteinsValue() {
        return proteinsValue;
    }


    public int getNutritionScoreFr() {
        return nutritionScoreFr;
    }


    public int getTransFatServing() {
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


    public int getTransFat100g() {
        return transFat100g;
    }


    public double getSugars() {
        return sugars;
    }


    public int getSaltValue() {
        return saltValue;
    }

    public double getProteins() {
        return proteins;
    }

    public int getEnergyKcalServing() {
        return energyKcalServing;
    }


    public int getNovaGroup() {
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

    public int getCholesterolValue() {
        return cholesterolValue;
    }


    public double getCarbohydratesValue() {
        return carbohydratesValue;
    }

    public int getEnergyKcal() {
        return energyKcal;
    }


    public double getFiberServing() {
        return fiberServing;
    }

    public int getEnergyValue() {
        return energyValue;
    }


    public double getSalt100g() {
        return salt100g;
    }

    public int getNovaGroupServing() {
        return novaGroupServing;
    }


    public int getVitaminC() {
        return vitaminC;
    }

    public String getCholesterolUnit() {
        return cholesterolUnit;
    }

    public double getCalcium100g() {
        return calcium100g;
    }

    public int getEnergy() {
        return energy;
    }

    public int getCholesterol() {
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

    public int getEnergy100g() {
        return energy100g;
    }

    public int getEnergyServing() {
        return energyServing;
    }

    public int getVitaminAValue() {
        return vitaminAValue;
    }

    public double getSaturatedFatServing() {
        return saturatedFatServing;
    }


    public int getVitaminCValue() {
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

    public int getEnergyKcal100g() {
        return energyKcal100g;
    }

    public int getTransFatValue() {
        return transFatValue;
    }


    public double getSodiumServing() {
        return sodiumServing;
    }


    public int getNutritionScoreFrServing() {
        return nutritionScoreFrServing;
    }


    public double getSodium() {
        return sodium;
    }


    public String getEnergyUnit() {
        return energyUnit;
    }

    public int getCholesterol100g() {
        return cholesterol100g;
    }

    public double getSodium100g() {
        return sodium100g;
    }

    public double getProteins100g() {
        return proteins100g;
    }

    public int getVitaminC100g() {
        return vitaminC100g;
    }
}

class NutriScoreData {
    @SerializedName("grade")
    private int grade;

    public int getGrade() {
        return grade;
    }

    //Al de nutri waardes
    @SerializedName("proteins_value")
    private int proteins;
    @SerializedName("fiber_value")
    private int fiber;
    @SerializedName("sugars_value")
    private int sugars;
    @SerializedName("saturated_fat_value")
    private int saturated_fat;
    @SerializedName("saturated_fat_ratio_value")
    private int saturated_fat_ratio_value;
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils_value")
    private int fruits_vegetables_nuts_colza_walnut_olive_oils_value;
    @SerializedName("energy_value")
    private int energy_value;
    @SerializedName("sodium_value")
    private int sodium_value;

    public int getSodium_value() {
        return sodium_value;
    }

    public int getEnergy_value() {
        return energy_value;
    }

    public int getFruits_vegetables_nuts_colza_walnut_olive_oils_value() {
        return fruits_vegetables_nuts_colza_walnut_olive_oils_value;
    }

    public int getSaturated_fat_ratio_value() {
        return saturated_fat_ratio_value;
    }

    public int getSaturated_fat() {
        return saturated_fat;
    }

    public int getSugars() {
        return sugars;
    }

    public int getFiber() {
        return fiber;
    }

    public int getProteins() {
        return proteins;
    }

    //Al de booleans
    @SerializedName("is_cheese")
    private boolean is_cheese;
    @SerializedName("is_beverage")
    private boolean is_beverage;
    @SerializedName("is_fat")
    private boolean is_fat;
    @SerializedName("is_water")
    private boolean is_water;

    public boolean isIs_water() {
        return is_water;
    }

    public boolean isIs_fat() {
        return is_fat;
    }

    public boolean getIs_beverage() {
        return is_beverage;
    }

    public boolean getIs_cheese() {
        return is_cheese;
    }


    //Al de punten
    @SerializedName("score")
    private int score;
    @SerializedName("saturated_fat_ratio_points")
    private int saturated_fat_ratio_points;
    @SerializedName("positive_points")
    private int positive_points;
    @SerializedName("sodium_points")
    private int sodium_points;
    @SerializedName("proteins_points")
    private int proteins_points;
    @SerializedName("fiber_points")
    private int fiber_points;
    @SerializedName("energy_points")
    private int energy_points;
    @SerializedName("negative_points")
    private int negative_points;
    @SerializedName("sugars_points")
    private int sugars_points;
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils_points")
    private int fruits_vegetables_nuts_colza_walnut_olive_oils_points;
    @SerializedName("saturated_fat_points")
    private int saturated_fat_points;

    public int getSaturated_fat_points() {
        return saturated_fat_points;
    }

    public int getFruits_vegetables_nuts_colza_walnut_olive_oils_points() {
        return fruits_vegetables_nuts_colza_walnut_olive_oils_points;
    }

    public int getSugars_points() {
        return sugars_points;
    }

    public int getNegative_points() {
        return negative_points;
    }

    public int getEnergy_points() {
        return energy_points;
    }

    public int getFiber_points() {
        return fiber_points;
    }

    public int getProteins_points() {
        return proteins_points;
    }

    public int getSodium_points() {
        return sodium_points;
    }

    public int getPositive_points() {
        return positive_points;
    }

    public int getSaturated_fat_ratio_points() {
        return saturated_fat_ratio_points;
    }

    public int getScore() {
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
