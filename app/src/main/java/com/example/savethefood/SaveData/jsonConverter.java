package com.example.savethefood.SaveData;

import android.util.Log;

import com.example.savethefood.Recipe.Model.Recipe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

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
    public ArrayList<Recipe> toRecipeObjects (String jsonString)
    {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Recipe>>(){}.getType();
        return gson.fromJson(jsonString, listType);
    }

    /*
    gebruik ervan
            String text = jsonConverter.toStringConverter(mRecipe);
        mRecipe = null;
        mRecipe = jsonConverter.toRecipeObject(text);
     */
}
