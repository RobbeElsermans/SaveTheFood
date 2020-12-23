package com.example.savethefood.Recipe.Model.NutrientsClasses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VITB6A implements Parcelable {

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

    public VITB6A() {
    }

    protected VITB6A(Parcel in) {
        this.label = in.readString();
        this.quantity = in.readDouble();
        this.unit = in.readString();
    }

    public static final Creator<VITB6A> CREATOR = new Creator<VITB6A>() {
        @Override
        public VITB6A createFromParcel(Parcel source) {
            return new VITB6A(source);
        }

        @Override
        public VITB6A[] newArray(int size) {
            return new VITB6A[size];
        }
    };
}
