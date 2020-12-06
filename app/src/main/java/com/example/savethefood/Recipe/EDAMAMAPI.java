package com.example.savethefood.Recipe;

import com.example.savethefood.Recipe.Model.RecipeInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface EDAMAMAPI {

    @GET
    Call<RecipeInfo> getPosts(@Url String url);
}
