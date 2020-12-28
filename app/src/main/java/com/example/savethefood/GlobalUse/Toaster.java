package com.example.savethefood.GlobalUse;

import android.content.Context;
import android.view.ContextMenu;
import android.widget.Toast;

public class Toaster {
    private Context mContect;

    public Toaster(Context contect) {
        this.mContect = contect;
    }

    public void longToast(String text)
    {
        if (!text.isEmpty() && mContect != null)
        Toast.makeText(mContect, text, Toast.LENGTH_LONG).show();
    }

    public void shortToast(String text){
        if (!text.isEmpty() && mContect != null)
            Toast.makeText(mContect, text, Toast.LENGTH_SHORT).show();
    }
}
