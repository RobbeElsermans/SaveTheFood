package com.example.savethefood.Recipe.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Recipe implements Parcelable {
    protected Recipe(Parcel in) {
        Image = in.readString();
        label = in.readString();
        sharelink = in.readString();
        websiteUrl = in.readString();
        source = in.readString();
        length = in.readInt();
        ingredients = new String[length];
        in.readStringArray(ingredients);
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    private int length;
    public int getLength(){return length;}

    @SerializedName("source")
    private String source;
    public String getSource() {
        return source;
    }


    @SerializedName("image")
    private String Image;
    public String getImage() {
        return Image;
    }

    @SerializedName("label")
    private String label;
    public String getLabel() {
        return label;
    }

    @SerializedName("shareAs")
    private String sharelink;
    public String getSharelink() {
        return sharelink;
    }

    @SerializedName("url")
    private String websiteUrl;
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    @SerializedName("ingredientLines")
    private String[] ingredients;
    public String[] getIngredients() {
        return ingredients;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Image);
        dest.writeString(label);
        dest.writeString(sharelink);
        dest.writeString(websiteUrl);
        dest.writeString(source);
        //dest.writeStringArray(ingredients);
        length = ingredients.length;
        dest.writeInt(length);
        dest.writeInt(length);

        for(int x = 0; x < ingredients.length; x++)
        {
            dest.writeString(ingredients[x]);
        }
    }
}
