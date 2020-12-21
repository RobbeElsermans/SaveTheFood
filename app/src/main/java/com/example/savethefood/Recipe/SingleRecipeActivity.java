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

import org.w3c.dom.Text;

public class SingleRecipeActivity extends AppCompatActivity {
    public final static String EXTRA_Single_Recipe = "com.example.SingleRecipeActivity.SingleRecipe";

    private ImageView mRecipeImage;
    private TextView mSourceRecipe;
    private Toolbar mToolbar;

    private TextView mIngredientTitle;
    private TextView mIngredients;
    private TextView mNutritionTitle;
    private TextView mNutritions;

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
        mIngredients = findViewById(R.id.textView_ingredients);
        mIngredientTitle = findViewById(R.id.textView_ingredients_title);
        mNutritions = findViewById(R.id.textView_nutrition);
        mNutritionTitle = findViewById(R.id.textView_nutrition_title);

        Glide.with(this).load(mRecipe.getImage()).into(mRecipeImage);
        mSourceRecipe.setText(mRecipe.getSource());

        String text = "";
        text += mRecipe.getIngredientLines().length + R.string.heading_ingredients;
        mIngredientTitle.setText(text);

        text = "";
        for (int x = 0; x < mRecipe.getIngredientLines().length; x++)
        {
            text += x+1 +") " +mRecipe.getIngredientLines()[x] + ",\n";
        }
        mIngredients.setText(text);

        //getNutrients
        text = "";

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
            Toast.makeText(this, R.string.no_valid_browser, Toast.LENGTH_SHORT).show();
        }
    }

    public void addToFavorites() {
        //Sla de mRecipe op lokaal
    }

    public void share() {
        //Geef de url van de pagina mee
    }

    public void goToSite(View view) {
        goToWebsite();
    }
}