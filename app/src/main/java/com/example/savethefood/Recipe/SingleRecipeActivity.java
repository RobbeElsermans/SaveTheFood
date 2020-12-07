package com.example.savethefood.Recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.savethefood.R;
import com.example.savethefood.Recipe.Model.Recipe;

public class SingleRecipeActivity extends AppCompatActivity {
    public final static String EXTRA_Single_Recipe = "com.example.SingleRecipeActivity.SingleRecipe";

    private ImageView mRecipeImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_recipe);

        Bundle bundle = getIntent().getExtras();
        Recipe  recipe = bundle.getParcelable(EXTRA_Single_Recipe);

        Log.d(String.valueOf(this), recipe.getLabel());

        this.setTitle(recipe.getLabel());

        mRecipeImage = findViewById(R.id.imageView_recipe_image);


        Glide.with(this).load(recipe.getImage()).into(mRecipeImage);




    }

    public void goToWebsite(View view) {

    }

    public void addToFavorites(View view) {
    }
}