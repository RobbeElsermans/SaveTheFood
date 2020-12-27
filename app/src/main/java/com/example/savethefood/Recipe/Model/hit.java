package com.example.savethefood.Recipe.Model;

import com.google.gson.annotations.SerializedName;

public class hit {
    @SerializedName("recipe")
    private Recipe recept;
    public Recipe getRecept() {
        return recept;
    }

    @SerializedName("bookmarked")
    private boolean bookmarked;

    public boolean getBookmarked() {
        return bookmarked;
    }

    @SerializedName("bought")
    private boolean bought;

    public boolean getBought() {
        return bought;
    }
}
