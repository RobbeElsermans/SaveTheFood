package com.example.savethefood.Recipe;

import android.Manifest;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.savethefood.Favorite.FavoriteActivity;
import com.example.savethefood.GlobalUse.Toaster;
import com.example.savethefood.MainActivity;
import com.example.savethefood.Permissions.Permission;
import com.example.savethefood.R;
import com.example.savethefood.Recipe.Model.Nutrients;
import com.example.savethefood.Recipe.Model.Recipe;
import com.example.savethefood.SaveData.FileStream;
import com.example.savethefood.SaveData.jsonConverter;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import pub.devrel.easypermissions.EasyPermissions;

public class SingleRecipeActivity extends AppCompatActivity {
    public final static String EXTRA_Single_Recipe = "com.example.SingleRecipeActivity.SingleRecipe";

    private ImageView mRecipeImage;
    private TextView mSourceRecipe;
    private Toolbar mToolbar;

    private TextView mIngredientTitle;
    private TextView mIngredients;
    private TextView mIngredientsNumber;
    private TextView mNutritionTitle;
    private TextView mNutritions;
    private TextView mNutrisionsName;
    private TextView mNutritionsUnits;

    private Toaster toaster;

    private Permission permission;

    private jsonConverter jsonConverter;
    private FileStream fileStream;

    private Recipe mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_recipe);

        toaster = new Toaster(this);
        permission = new Permission(this);

        receiveIntent();

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        createContent();
    }

    private void receiveIntent() {
        Bundle bundle = getIntent().getExtras();
        mRecipe = bundle.getParcelable(EXTRA_Single_Recipe);
    }

    private void createContent() {
        jsonConverter = new jsonConverter();
        fileStream = new FileStream(MainActivity.FAVORITE_FILE_NAME, this);

        DecimalFormat format = new DecimalFormat("#.##");

        this.setTitle(mRecipe.getLabel());

        mRecipeImage = findViewById(R.id.imageView_recipe_image);
        mSourceRecipe = findViewById(R.id.textView_source_of_recipe);
        mIngredients = findViewById(R.id.textView_ingredients);
        mIngredientsNumber = findViewById(R.id.textView_ingredients_number);
        mIngredientTitle = findViewById(R.id.textView_ingredients_title);
        mNutritions = findViewById(R.id.textView_nutrition_value);
        mNutrisionsName = findViewById(R.id.textView_nutrition_name);
        mNutritionsUnits = findViewById(R.id.textView_nutrition_unit);
        mNutritionTitle = findViewById(R.id.textView_nutrition_title);

        Glide.with(this).load(mRecipe.getImage()).into(mRecipeImage);
        mSourceRecipe.setText(mRecipe.getSource());

        String name = "";
        String value = "";
        String unit = "";
        StringBuilder number = new StringBuilder();
        StringBuilder instruction = new StringBuilder();
        name = String.valueOf(mRecipe.getIngredientLines().length) + "  " + getResources().getString(R.string.heading_ingredients);
        mIngredientTitle.setText(name);


        name = "";

        for (int x = 0; x < mRecipe.getIngredientLines().length; x++) {
            number.append(x + 1).append(") ").append(getResources().getString(R.string.line_ending));
            instruction.append(mRecipe.getIngredientLines()[x]).append(getResources().getString(R.string.line_ending));
        }
        mIngredientsNumber.setText(number.toString());
        mIngredients.setText(instruction.toString());


        //getNutrients
        Nutrients nutri = mRecipe.getNutrients();
        value = "value" + getResources().getString(R.string.line_ending);
        name = "name" + getResources().getString(R.string.line_ending);
        unit = "unit" + getResources().getString(R.string.line_ending);
        if (nutri.getENERCKCAL() != null && nutri.getENERCKCAL().getQuantity() != 0) {
            name += getResources().getString(R.string.energy_text) + "\n\n";
            value += format.format(nutri.getENERCKCAL().getQuantity()) + "\n\n";
            unit += nutri.getENERCKCAL().getUnit() + "\n\n";
        }
        if (nutri.getFAT() != null && nutri.getFAT().getQuantity() != 0) {
            name += getResources().getString(R.string.fat_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getFAT().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getFAT().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getFASAT() != null && nutri.getFASAT().getQuantity() != 0) {
            name += getResources().getString(R.string.fat_saturated_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getFASAT().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getFASAT().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getFATRN() != null && nutri.getFATRN().getQuantity() != 0) {
            name += getResources().getString(R.string.fat_trans_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getFATRN().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getFATRN().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getFAMS() != null && nutri.getFAMS().getQuantity() != 0) {
            name += getResources().getString(R.string.fat_monounsaturated_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getFAMS().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getFAMS().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getFAPU() != null && nutri.getFAPU().getQuantity() != 0) {
            name += getResources().getString(R.string.fat_Polyunsaturated_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getFAPU().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getFAPU().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getWATER() != null && nutri.getWATER().getQuantity() != 0) {
            name += getResources().getString(R.string.water_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getWATER().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getWATER().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getCHOCDF() != null && nutri.getCHOCDF().getQuantity() != 0) {
            name += getResources().getString(R.string.carbs_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getCHOCDF().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getCHOCDF().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getFIBTG() != null && nutri.getFIBTG().getQuantity() != 0) {
            name += getResources().getString(R.string.fiber_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getFIBTG().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getFIBTG().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getSUGAR() != null && nutri.getSUGAR().getQuantity() != 0) {
            name += getResources().getString(R.string.sugar_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getSUGAR().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getSUGAR().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getPROCNT() != null && nutri.getPROCNT().getQuantity() != 0) {
            name += getResources().getString(R.string.proteins_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getPROCNT().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getPROCNT().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getCHOLE() != null && nutri.getCHOLE().getQuantity() != 0) {
            name += getResources().getString(R.string.cholesterol_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getCHOLE().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getCHOLE().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getNA() != null && nutri.getNA().getQuantity() != 0) {
            name += getResources().getString(R.string.sodium_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getNA().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getNA().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getCA() != null && nutri.getCA().getQuantity() != 0) {
            name += getResources().getString(R.string.calcium_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getCA().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getCA().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getMG() != null && nutri.getMG().getQuantity() != 0) {
            name += getResources().getString(R.string.magnesium_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getMG().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getMG().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getK() != null && nutri.getK().getQuantity() != 0) {
            name += getResources().getString(R.string.potassium_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getK().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getK().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getFE() != null && nutri.getFE().getQuantity() != 0) {
            name += getResources().getString(R.string.iron_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getFE().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getFE().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getZN() != null && nutri.getZN().getQuantity() != 0) {
            name += getResources().getString(R.string.zinc_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getZN().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getZN().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getP() != null && nutri.getP().getQuantity() != 0) {
            name += getResources().getString(R.string.phosphorus_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getP().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getP().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getVITARAE() != null && nutri.getVITARAE().getQuantity() != 0) {
            name += getResources().getString(R.string.vitaminA_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getVITARAE().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getVITARAE().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getVITC() != null && nutri.getVITC().getQuantity() != 0) {
            name += getResources().getString(R.string.vitaminC_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getVITC().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getVITC().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getTHIA() != null && nutri.getTHIA().getQuantity() != 0) {
            name += getResources().getString(R.string.thiaminB1_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getTHIA().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getTHIA().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getRIBF() != null && nutri.getRIBF().getQuantity() != 0) {
            name += getResources().getString(R.string.riboflavinB2_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getRIBF().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getRIBF().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getNIA() != null && nutri.getNIA().getQuantity() != 0) {
            name += getResources().getString(R.string.niacidB3_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getNIA().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getNIA().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getVITB6A() != null && nutri.getVITB6A().getQuantity() != 0) {
            name += getResources().getString(R.string.vitaminB6_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getVITB6A().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getVITB6A().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getFOLFD() != null && nutri.getFOLFD().getQuantity() != 0) {
            name += getResources().getString(R.string.folate_food_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getFOLFD().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getFOLFD().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getFOLAC() != null && nutri.getFOLAC().getQuantity() != 0) {
            name += getResources().getString(R.string.folic_acid_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getFOLAC().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getFOLAC().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getVITB12() != null && nutri.getVITB12().getQuantity() != 0) {
            name += getResources().getString(R.string.vitaminB12_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getVITB12().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getVITB12().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getVITD() != null && nutri.getVITD().getQuantity() != 0) {
            name += getResources().getString(R.string.vitaminD_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getVITD().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getVITD().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getTOCPHA() != null && nutri.getTOCPHA().getQuantity() != 0) {
            name += getResources().getString(R.string.vitaminE_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getTOCPHA().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getTOCPHA().getUnit() + getResources().getString(R.string.line_ending);
        }
        if (nutri.getVITK1() != null && nutri.getVITK1().getQuantity() != 0) {
            name += getResources().getString(R.string.vitaminK_text) + getResources().getString(R.string.line_ending);
            value += format.format(nutri.getVITK1().getQuantity()) + getResources().getString(R.string.line_ending);
            unit += nutri.getVITK1().getUnit() + getResources().getString(R.string.line_ending);
        }

        mNutrisionsName.setText(name);
        mNutritions.setText(value);
        mNutritionsUnits.setText(unit);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
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
        if (send.resolveActivity(getPackageManager()) != null)
            startActivity(send);
        else
            toaster.shortToast(getString(R.string.no_valid_browser));
    }

    private void addToFavorites() {
        if (permission.hasPermissionWriteStorage())
        {
            if(!checkIfFavoriteExist(mRecipe))
            {
                String text = jsonConverter.toStringConverter(mRecipe);
                try {
                    fileStream.writeRecipeToFile(text);
                    toaster.shortToast(getString(R.string.add_to_favorites));
                }catch (IOException e)
                {
                    toaster.shortToast(getString(R.string.something_went_wrong) + e.toString());
                }
            }
            else toaster.shortToast(getString(R.string.already_add_to_favorites));
        }
        else permission.requestPermission(getString(R.string.storage_permission), MainActivity.WRITE_STORAGE_PERM, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    private boolean checkIfFavoriteExist(Recipe singleRecipe) {
        ArrayList<Recipe> recipes;
        try {
             recipes = jsonConverter.toRecipeObjects(fileStream.readFromFile());
            if (recipes != null && !recipes.isEmpty())
            {
                if(recipes.size() > 1)
                for (int x = 0; x < recipes.size() -1; x++)
                {
                    if (recipes.get(x).getLabel().equals(singleRecipe.getLabel()))
                        return true;
                }
                else
                {
                    if (recipes.get(0).getLabel().equals(singleRecipe.getLabel()))
                        return true;
                }
            }
        }
        catch (IOException e)
        {
            toaster.shortToast(getString(R.string.something_went_wrong) + e.toString());
        }
        return false;
    }

    private void share() {

        if (mRecipe.getWebsiteUrl() != null) {
            Intent send = new Intent();
            send.setAction(Intent.ACTION_SEND);
            send.putExtra(Intent.EXTRA_TEXT, mRecipe.getWebsiteUrl());
            send.setType("text/plain");

            Intent shareIntent = Intent.createChooser(send, "Share recipe");
            startActivity(shareIntent);
        }
    }

    public void goToSite(View view) {
        if (view.getId() == R.id.btn_search_recipe)
            goToWebsite();
    }
}