package com.example.savethefood.Recipe.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeInfo {
    @SerializedName("q")
    private String query;

    public String getQuery() {
        return query;
    }

    @SerializedName("from")
    private int from;

    public int getFrom() {
        return from;
    }

    @SerializedName("to")
    private int to;

    public int getTo() {
        return to;
    }

    @SerializedName("more")
    private boolean more;

    public boolean getMore() {
        return more;
    }

    @SerializedName("count")
    private int count;

    public int getCount() {
        return count;
    }

    @SerializedName("hits")
    private List<hit> hits;

    public List<hit> getHits() {
        return hits;
    }
}

