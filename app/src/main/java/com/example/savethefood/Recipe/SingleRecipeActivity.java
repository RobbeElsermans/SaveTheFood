package com.example.savethefood.Recipe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import com.example.savethefood.R;
import com.example.savethefood.Recipe.Model.Nutrients;
import com.example.savethefood.Recipe.Model.Recipe;

import java.text.DecimalFormat;

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

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        createContent();
    }

    private void receiveIntent() {
        Bundle bundle = getIntent().getExtras();
        mRecipe = bundle.getParcelable(EXTRA_Single_Recipe);
    }

    private void createContent() {

        DecimalFormat format = new DecimalFormat("#.##");

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
        text = String.valueOf(mRecipe.getIngredientLines().length) + " " + getResources().getString(R.string.heading_ingredients);
        mIngredientTitle.setText(text);

        text = "";
        for (int x = 0; x < mRecipe.getIngredientLines().length; x++) {
            text += (x + 1) + ") " + mRecipe.getIngredientLines()[x] + ",\n";
        }
        mIngredients.setText(text);

        //getNutrients
        Nutrients nutri = mRecipe.getNutrients();
        text = "";
        if (nutri.getENERCKCAL() != null && nutri.getENERCKCAL().getQuantity() != 0)
            text += nutri.getENERCKCAL().getLabel() + "  " + format.format(nutri.getENERCKCAL().getQuantity()) + "  " + nutri.getENERCKCAL().getUnit() + "\n\n";
        if (nutri.getFAT() != null && nutri.getFAT().getQuantity() != 0)
            text += nutri.getFAT().getLabel() + "  " + format.format(nutri.getFAT().getQuantity()) + "  " + nutri.getFAT().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getFASAT() != null && nutri.getFASAT().getQuantity() != 0)
            text += "  " + nutri.getFASAT().getLabel() + "  " + format.format(nutri.getFASAT().getQuantity()) + "  " + nutri.getFASAT().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getFATRN() != null && nutri.getFATRN().getQuantity() != 0)
            text += "  " + nutri.getFATRN().getLabel() + "  " + format.format(nutri.getFATRN().getQuantity()) + "  " + nutri.getFATRN().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getFAMS() != null && nutri.getFAMS().getQuantity() != 0)
            text += "  " + nutri.getFAMS().getLabel() + "  " + format.format(nutri.getFAMS().getQuantity()) + "  " + nutri.getFAMS().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getFAPU() != null && nutri.getFAPU().getQuantity() != 0)
            text += "  " + nutri.getFAPU().getLabel() + "  " + format.format(nutri.getFAPU().getQuantity()) + "  " + nutri.getFAPU().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getWATER() != null && nutri.getWATER().getQuantity() != 0)
            text += nutri.getWATER().getLabel() + "  " + format.format(nutri.getWATER().getQuantity()) + "  " + nutri.getWATER().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getCHOCDF() != null && nutri.getCHOCDF().getQuantity() != 0)
            text += nutri.getCHOCDF().getLabel() + "  " + format.format(nutri.getCHOCDF().getQuantity()) + "  " + nutri.getCHOCDF().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getFIBTG() != null && nutri.getFIBTG().getQuantity() != 0)
            text += "  " + nutri.getFIBTG().getLabel() + "  " + format.format(nutri.getFIBTG().getQuantity()) + "  " + nutri.getFIBTG().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getSUGAR() != null && nutri.getSUGAR().getQuantity() != 0)
            text += "  " + nutri.getSUGAR().getLabel() + "  " + format.format(nutri.getSUGAR().getQuantity()) + "  " + nutri.getSUGAR().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getPROCNT() != null && nutri.getPROCNT().getQuantity() != 0)
            text += nutri.getPROCNT().getLabel() + "  " + format.format(nutri.getPROCNT().getQuantity()) + "  " + nutri.getPROCNT().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getCHOLE() != null && nutri.getCHOLE().getQuantity() != 0)
            text += nutri.getCHOLE().getLabel() + "  " + format.format(nutri.getCHOLE().getQuantity()) + "  " + nutri.getCHOLE().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getNA() != null && nutri.getNA().getQuantity() != 0)
            text += nutri.getNA().getLabel() + "  " + format.format(nutri.getNA().getQuantity()) + "  " + nutri.getNA().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getCA() != null && nutri.getCA().getQuantity() != 0)
            text += nutri.getCA().getLabel() + "  " + format.format(nutri.getCA().getQuantity()) + "  " + nutri.getCA().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getMG() != null && nutri.getMG().getQuantity() != 0)
            text += nutri.getMG().getLabel() + "  " + format.format(nutri.getMG().getQuantity()) + "  " + nutri.getMG().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getK() != null && nutri.getK().getQuantity() != 0)
            text += nutri.getK().getLabel() + "  " + format.format(nutri.getK().getQuantity()) + "  " + nutri.getK().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getFE() != null && nutri.getFE().getQuantity() != 0)
            text += nutri.getFE().getLabel() + "  " + format.format(nutri.getFE().getQuantity()) + "  " + nutri.getFE().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getZN() != null && nutri.getZN().getQuantity() != 0)
            text += nutri.getZN().getLabel() + "  " + format.format(nutri.getZN().getQuantity()) + "  " + nutri.getZN().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getP() != null && nutri.getP().getQuantity() != 0)
            text += nutri.getP().getLabel() + "  " + format.format(nutri.getP().getQuantity()) + "  " + nutri.getP().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getVITARAE() != null && nutri.getVITARAE().getQuantity() != 0)
            text += nutri.getVITARAE().getLabel() + "  " + format.format(nutri.getVITARAE().getQuantity()) + "  " + nutri.getVITARAE().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getVITC() != null && nutri.getVITC().getQuantity() != 0)
            text += nutri.getVITC().getLabel() + "  " + format.format(nutri.getVITC().getQuantity()) + "  " + nutri.getVITC().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getTHIA() != null && nutri.getTHIA().getQuantity() != 0)
            text += nutri.getTHIA().getLabel() + "  " + format.format(nutri.getTHIA().getQuantity()) + "  " + nutri.getTHIA().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getRIBF() != null && nutri.getRIBF().getQuantity() != 0)
            text += nutri.getRIBF().getLabel() + "  " + format.format(nutri.getRIBF().getQuantity()) + "  " + nutri.getRIBF().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getNIA() != null && nutri.getNIA().getQuantity() != 0)
            text += nutri.getNIA().getLabel() + "  " + format.format(nutri.getNIA().getQuantity()) + "  " + nutri.getNIA().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getVITB6A() != null && nutri.getVITB6A().getQuantity() != 0)
            text += nutri.getVITB6A().getLabel() + "  " + format.format(nutri.getVITB6A().getQuantity()) + "  " + nutri.getVITB6A().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getFOLFD() != null && nutri.getFOLFD().getQuantity() != 0)
            text += nutri.getFOLFD().getLabel() + "  " + format.format(nutri.getFOLFD().getQuantity()) + "  " + nutri.getFOLFD().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getFOLAC() != null && nutri.getFOLAC().getQuantity() != 0)
            text += nutri.getFOLAC().getLabel() + "  " + format.format(nutri.getFOLAC().getQuantity()) + "  " + nutri.getFOLAC().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getVITB12() != null && nutri.getVITB12().getQuantity() != 0)
            text += nutri.getVITB12().getLabel() + "  " + format.format(nutri.getVITB12().getQuantity()) + "  " + nutri.getVITB12().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getVITD() != null && nutri.getVITD().getQuantity() != 0)
            text += nutri.getVITD().getLabel() + "  " + format.format(nutri.getVITD().getQuantity()) + "  " + nutri.getVITD().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getTOCPHA() != null && nutri.getTOCPHA().getQuantity() != 0)
            text += nutri.getTOCPHA().getLabel() + "  " + format.format(nutri.getTOCPHA().getQuantity()) + "  " + nutri.getTOCPHA().getUnit() + getResources().getString(R.string.line_ending);
        if (nutri.getVITK1() != null && nutri.getVITK1().getQuantity() != 0)
            text += nutri.getVITK1().getLabel() + "  " + format.format(nutri.getVITK1().getQuantity()) + "  " + nutri.getVITK1().getUnit() + getResources().getString(R.string.line_ending);
        mNutritions.setText(text);
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
            Toast.makeText(this, R.string.no_valid_browser, Toast.LENGTH_SHORT).show();
    }

    public void addToFavorites() {
        //Sla de mRecipe op lokaal
    }

    public void share() {
        //Geef de url van de pagina mee
    }

    public void goToSite(View view) {
        if (view.getId() == R.id.btn_search_recipe)
            goToWebsite();
    }
}