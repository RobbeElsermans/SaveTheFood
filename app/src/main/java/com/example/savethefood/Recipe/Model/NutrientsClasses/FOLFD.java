package com.example.savethefood.Recipe.Model.NutrientsClasses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FOLFD implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getLabel() {
        return label;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

     @Override
     public int describeContents() {
         return 0;
     }

     @Override
     public void writeToParcel(Parcel dest, int flags) {
         dest.writeString(this.label);
         dest.writeDouble(this.quantity);
         dest.writeString(this.unit);
     }

     public FOLFD() {
     }

     protected FOLFD(Parcel in) {
         this.label = in.readString();
         this.quantity = in.readDouble();
         this.unit = in.readString();
     }

     public static final Creator<FOLFD> CREATOR = new Creator<FOLFD>() {
         @Override
         public FOLFD createFromParcel(Parcel source) {
             return new FOLFD(source);
         }

         @Override
         public FOLFD[] newArray(int size) {
             return new FOLFD[size];
         }
     };
 }
