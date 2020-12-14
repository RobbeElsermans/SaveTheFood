package com.example.savethefood.Recipe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.savethefood.R;
import com.example.savethefood.Recipe.Model.Recipe;

public class SingleRecipeActivity extends AppCompatActivity {
    public final static String EXTRA_Single_Recipe = "com.example.SingleRecipeActivity.SingleRecipe";

    private ImageView mRecipeImage;
    private TextView mSourceRecipe;
    private Toolbar mToolbar;

    private Recipe mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_recipe);

        receiveIntent();

        Log.d(String.valueOf(this), mRecipe.getLabel());

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        createContent();
    }

    private void receiveIntent() {
        Bundle bundle = getIntent().getExtras();
        mRecipe = bundle.getParcelable(EXTRA_Single_Recipe);
    }

    private void createContent() {
        this.setTitle(mRecipe.getLabel());

        mRecipeImage = findViewById(R.id.imageView_recipe_image);
        mSourceRecipe = findViewById(R.id.textView_source_of_recipe);

        Glide.with(this).load(mRecipe.getImage()).into(mRecipeImage);
        mSourceRecipe.setText(mRecipe.getSource());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_go_to_website:
                goToWebsite();
                return true;

            case R.id.action_favorite:
                addToFavorites();
                return true;

            case R.id.action_share:
                share();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_single_recipe, menu);
        return true;
    }

    private void goToWebsite() {
        String url = mRecipe.getWebsiteUrl();
        Uri page = Uri.parse(url);
        Intent send = new Intent(Intent.ACTION_VIEW, page);
        if (send.resolveActivity(getPackageManager()) != null) {
            startActivity(send);
        } else {
            Toast.makeText(this, "No valid browser found!", Toast.LENGTH_SHORT).show();
        }
    }

    public void addToFavorites() {
    }

    public void share() {
    }
}