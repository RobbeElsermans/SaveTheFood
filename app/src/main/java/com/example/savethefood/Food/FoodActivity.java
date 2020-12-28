package com.example.savethefood.Food;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.example.savethefood.Food.Model.FoodInfo;
import com.example.savethefood.Food.Model.Nutri;
import com.example.savethefood.Food.Model.NutriScoreData;
import com.example.savethefood.GlobalUse.Toaster;
import com.example.savethefood.R;
import com.example.savethefood.Recipe.RecipeActivity;
import com.example.savethefood.Scanner.ScannerActivity;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FoodActivity extends AppCompatActivity {

    private Intent searchKey;

    private Toaster mToaster;

    private TextView mNutriScore;
    private TextView mNutriName;
    private TextView mNutriUnit;
    private TextView mNovaGroup;
    private TextView nutriscore;
    private ImageView urlProduct;
    private ImageView nutriGrade;
    private TextView productName;
    private EditText editTextProductName;

    private LinearLayout mNovaGroupPos;
    private LinearLayout mNutriScorePos;

    FoodAPI ApiBarcode;

    private Intent cameraScan;
    private String barcodeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        mToaster = new Toaster(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.url_api_openfoodfacts))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiBarcode = retrofit.create(FoodAPI.class);
/*
        requestBuilder = Glide.with(this)
                .from(Uri.class)
                .as(SVG.class)
                .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder<SVG>(new SvgDecoder()))
                .decoder(new SvgDecoder())
                .placeholder(R.drawable.ic_facebook)
                .error(R.drawable.ic_web)
                .animate(android.R.anim.fade_in)
                .listener(new SvgSoftwareLayerSetter<Uri>());
*/
        TextView barcode = findViewById(R.id.textview_barcode);
        nutriscore = findViewById(R.id.textview_nutriscore);
        mNutriName = findViewById(R.id.textview_nutri_name);
        mNutriUnit = findViewById(R.id.textview_nutri_unit);

        urlProduct = findViewById(R.id.imageView_picture_food);
        productName = findViewById(R.id.textview_product_name);
        editTextProductName = findViewById(R.id.editText_product_name);
        mNutriScore = findViewById(R.id.btn_product_nutri_score);
        mNovaGroup = findViewById(R.id.btn_product_nova_score);

        mNovaGroupPos = findViewById(R.id.linearLayout_nova_group);
        mNutriScorePos = findViewById(R.id.linearLayout_nutri_score);

        mNutriScorePos.setVisibility(View.INVISIBLE);
        mNovaGroupPos.setVisibility(View.INVISIBLE);

        cameraScan = new Intent(this, ScannerActivity.class);
        searchKey = new Intent(this, RecipeActivity.class);

        //private BarcodeInfo data;
        Intent recieveBarcode = getIntent();

        barcodeText = recieveBarcode.getStringExtra(ScannerActivity.EXTRA_RETURN_BARCODE);

        barcode.append(barcodeText);

        retrieveInfo();
    }

    public void retrieveInfo() {
        Call<FoodInfo> call = ApiBarcode.getPosts(barcodeText);

        call.enqueue(new Callback<FoodInfo>() {
            @Override
            public void onResponse(@NotNull Call<FoodInfo> call, @NotNull Response<FoodInfo> response) {
                assert response.body() != null;
                if (response.body().getProduct() != null)
                    setContent(response);
                else {
                    Log.d(this.toString(), R.string.not_in_database + String.valueOf(response.code()));
                    mToaster.shortToast(getString(R.string.not_in_database));
                    startActivity(new Intent(FoodActivity.this, ScannerActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<FoodInfo> call, Throwable t) {
                Log.d(this.toString(), R.string.not_responding_database + t.getMessage());
                mToaster.shortToast(getString(R.string.not_in_database));
                finish();
            }
        });
    }

    private void setContent(Response<FoodInfo> response)
    {
            //Bron: https://stackoverflow.com/questions/9366280/android-round-to-2-decimal-places
            DecimalFormat format = new DecimalFormat("#.##");

            FoodInfo posten = response.body();
            String nutriments = "";
            String names = "";
            String units = "";

            if (posten.getProduct().getNutriments() != null) {
                Nutri nutri = posten.getProduct().getNutriments();
                if (isEmpty(nutri.getEnergyValue())) {
                    names += getResources().getString(R.string.energy_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutri.getEnergyValue()) + getResources().getString(R.string.line_ending);
                    units += nutri.getEnergyKcalUnit() + getResources().getString(R.string.line_ending);

                }
                if (isEmpty(nutri.getSugarsValue())) {
                    names += getResources().getString(R.string.sugar_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutri.getSugarsValue()) + getResources().getString(R.string.line_ending);
                    units += nutri.getSugarsUnit() + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutri.getSaturatedFatValue())) {
                    names += getResources().getString(R.string.fat_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutri.getSaturatedFatValue()) + getResources().getString(R.string.line_ending);
                    units += nutri.getSaturatedFatUnit() + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutri.getFiberValue())) {
                    names += getResources().getString(R.string.fiber_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutri.getFiberValue()) + getResources().getString(R.string.line_ending);
                    units += nutri.getFiberUnit() + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutri.getProteinsValue())) {
                    names += getResources().getString(R.string.proteins_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutri.getProteinsValue()) + getResources().getString(R.string.line_ending);
                    units += nutri.getProteinsUnit() + getResources().getString(R.string.line_ending);
                }

                if (isEmpty(nutri.getSodiumValue())) {
                    names += getResources().getString(R.string.sodium_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutri.getSodiumValue()) + getResources().getString(R.string.line_ending);
                    units += nutri.getSodiumUnit() + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutri.getIronValue())) {
                    names += getResources().getString(R.string.iron_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutri.getIronValue()) + getResources().getString(R.string.line_ending);
                    units += nutri.getIronUnit() + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutri.getSaltValue())) {
                    names += getResources().getString(R.string.salt_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutri.getSaltValue()) + getResources().getString(R.string.line_ending);
                    units += nutri.getSaltUnit() + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutri.getCalciumValue())) {
                    names += getResources().getString(R.string.calcium_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutri.getCalciumValue()) + getResources().getString(R.string.line_ending);
                    units += nutri.getCalciumUnit() + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutri.getCarbohydratesValue())) {
                    names += getResources().getString(R.string.carbohydrate_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutri.getCarbohydratesValue()) + getResources().getString(R.string.line_ending);
                    units += nutri.getCarbohydratesUnit() + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutri.getCholesterolValue())) {
                    names += getResources().getString(R.string.cholesterol_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutri.getCholesterolValue()) + getResources().getString(R.string.line_ending);
                    units += nutri.getCholesterolUnit() + getResources().getString(R.string.line_ending);
                }
            } else if (posten.getProduct().getNutriscore_data() != null) {
                NutriScoreData nutriScoreData = posten.getProduct().getNutriscore_data();
                if (isEmpty(nutriScoreData.getEnergy_value())) {
                    names += getResources().getString(R.string.energy_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutriScoreData.getEnergy_value()) + getResources().getString(R.string.line_ending);
                    units += "kcal" + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutriScoreData.getSugars())) {
                    names += getResources().getString(R.string.sugar_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutriScoreData.getSugars()) + getResources().getString(R.string.line_ending);
                    units += "g" + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutriScoreData.getSaturated_fat())) {
                    names += getResources().getString(R.string.fat_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutriScoreData.getSaturated_fat()) + getResources().getString(R.string.line_ending);
                    units += "g" + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutriScoreData.getFiber())) {
                    names += getResources().getString(R.string.fiber_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutriScoreData.getFiber()) + getResources().getString(R.string.line_ending);
                    units += "g" + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutriScoreData.getProteins())) {
                    names += getResources().getString(R.string.proteins_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutriScoreData.getProteins()) + getResources().getString(R.string.line_ending);
                    units += "g" + getResources().getString(R.string.line_ending);
                }
                if (isEmpty(nutriScoreData.getSodium_value())) {
                    names += getResources().getString(R.string.sodium_text) + getResources().getString(R.string.line_ending);
                    nutriments += format.format(nutriScoreData.getSodium_value()) + getResources().getString(R.string.line_ending);
                    units += "g" + getResources().getString(R.string.line_ending);
                }
            } else nutriments += R.string.not_in_database;

            if (nutriments.isEmpty())
                names += "not nutriments available" + getResources().getString(R.string.line_ending);
            Glide.with(FoodActivity.this).load(posten.getProduct().getImage_url()).into(urlProduct);


            productName.setText(posten.getProduct().getName());
            mNutriName.setText(names);
            nutriscore.setText(nutriments);
            mNutriUnit.setText(units);
            editTextProductName.setText(posten.getProduct().getName());
            if (posten.getProduct().getNutriscore_grade() != null) {
                if (!posten.getProduct().getNutriscore_grade().equals("")) {
                    mNutriScorePos.setVisibility(View.VISIBLE);
                    mNutriScore.setText(posten.getProduct().getNutriscore_grade().toUpperCase());
                    switch (posten.getProduct().getNutriscore_grade().toUpperCase()) {
                        case "A":
                            mNutriScore.setBackgroundColor(getResources().getColor(R.color.score_a, null));
                            break;
                        case "B":
                            mNutriScore.setBackgroundColor(getResources().getColor(R.color.score_b, null));
                            break;
                        case "C":
                            mNutriScore.setBackgroundColor(getResources().getColor(R.color.score_c, null));
                            break;
                        case "D":
                            mNutriScore.setBackgroundColor(getResources().getColor(R.color.score_d, null));
                            break;
                        case "E":
                            mNutriScore.setBackgroundColor(getResources().getColor(R.color.score_e, null));
                            break;
                        default:
                            mNutriScore.setBackgroundColor(getResources().getColor(R.color.white_color, null));
                            break;
                    }
                }
            }

            if (posten.getProduct().getNova_group() != 0.0) {
                mNovaGroupPos.setVisibility(View.VISIBLE);
                mNovaGroup.setText(String.valueOf((int) posten.getProduct().getNova_group()));
                switch ((int) posten.getProduct().getNova_group()) {
                    case 1:
                        mNovaGroup.setBackgroundColor(getResources().getColor(R.color.nova_1, null));
                        break;
                    case 2:
                        mNovaGroup.setBackgroundColor(getResources().getColor(R.color.nova_2, null));
                        break;
                    case 3:
                        mNovaGroup.setBackgroundColor(getResources().getColor(R.color.nova_3, null));
                        break;
                    case 4:
                        mNovaGroup.setBackgroundColor(getResources().getColor(R.color.nova_4, null));
                        break;
                    default:
                        mNovaGroup.setBackgroundColor(getResources().getColor(R.color.white_color, null));
                        break;
                }
            }


    }

    private boolean isEmpty(double value) {
        return value != 0;
    }

    public void Scan(View view) {
        finish();
        startActivity(cameraScan);
    }

    public void searchRecipe(View view) {
        if (!isEmpty(editTextProductName)) {
            searchKey.putExtra(RecipeActivity.EXTRA_Recieve_SearchKey, editTextProductName.getText().toString());
            startActivity(searchKey);
        } else mToaster.shortToast(getString(R.string.no_search_key));
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) return false;
        return true;
    }

    public void goToSite(View view) {
        Uri page = null;
        if (view.getId() == R.id.btn_product_nutri_score)
            page = Uri.parse(getResources().getString(R.string.url_wikipedia_nutri_info));
        if (view.getId() == R.id.btn_product_nova_score)
            page = Uri.parse(getResources().getString(R.string.url_openfoodfacts_nova_info));
        if (page != null) {
            Intent send = new Intent(Intent.ACTION_VIEW, page);
            if (send.resolveActivity(getPackageManager()) != null) startActivity(send);
            else mToaster.shortToast(getString(R.string.no_valid_browser));
        }
    }
}