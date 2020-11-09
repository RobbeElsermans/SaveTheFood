package com.example.savethefood;

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
class hit {
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

