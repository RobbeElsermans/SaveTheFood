package com.example.savethefood.Recipe.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Nutrients implements Parcelable {
    protected Nutrients(Parcel in) {
    }

    public static final Creator<Nutrients> CREATOR = new Creator<Nutrients>() {
        @Override
        public Nutrients createFromParcel(Parcel in) {
            return new Nutrients(in);
        }

        @Override
        public Nutrients[] newArray(int size) {
            return new Nutrients[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
