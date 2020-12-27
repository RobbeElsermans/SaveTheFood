package com.example.savethefood.Food.Model;

import com.google.gson.annotations.SerializedName;

public class ImageFont {
    @SerializedName("small")
    private ImageFrontItem imageFontSmall;

    public ImageFrontItem getImageFontSmall() {
        return imageFontSmall;
    }

    @SerializedName("thumb")
    private ImageFrontItem imageFontThumb;

    public ImageFrontItem getImageFontThumb() {
        return imageFontThumb;
    }

    @SerializedName("display")
    private ImageFrontItem imageFontDisplay;

    public ImageFrontItem getImageFontDisplay() {
        return imageFontDisplay;
    }
}
