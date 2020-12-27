package com.example.savethefood.SaveData;

import android.util.Log;

import com.example.savethefood.Recipe.Model.Recipe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class jsonConverter {

    public String toStringConverter (Recipe singleRecipe)
    {
        Gson gson = new Gson();
        return gson.toJson(singleRecipe);
    }



    public Recipe toRecipeObject (String jsonString)
    {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Recipe.class);
    }
    public Recipe[] toRecipeObjects (String jsonString)
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return gson.fromJson(jsonString, Recipe[].class);
    }

    /*
    gebruik ervan
            String text = jsonConverter.toStringConverter(mRecipe);
        mRecipe = null;
        mRecipe = jsonConverter.toRecipeObject(text);
     */
}
