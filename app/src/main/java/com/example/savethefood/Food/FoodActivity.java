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

    //private BarcodeInfo data;
    private Intent recieveBarcode;
    private Intent searchKey;

    private TextView mNutriScore;
    private TextView mNovaGroup;
    private TextView barcode;
    private TextView nutriscore;
    private ImageView urlProduct;
    private ImageView nutriGrade;
    private TextView productName;
    private EditText editTextProductName;
    private RequestBuilder requestBuilder;

    private LinearLayout mNovaGroupPos;
    private LinearLayout mNutriScorePos;

    FoodAPI ApiBarcode;

    private Intent cameraScan;
    private String barcodeText;
    private String url = "https://world.openfoodfacts.org/api/v0/product/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://world.openfoodfacts.org/api/v0/product/")
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
        barcode = findViewById(R.id.textview_barcode);
        nutriscore = findViewById(R.id.textview_nutriscores);
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

        recieveBarcode = getIntent();

        barcodeText = recieveBarcode.getStringExtra(ScannerActivity.EXTRA_RETURN_BARCODE);

        barcode.setText("barcode: " + barcodeText);

        retrieveInfo();

        //barInfoRetreiver = new APIBarcode(url, barcodeText);

        //data = barInfoRetreiver.getRequest();

        //dataBarcode.setText(data.toString());
    }

    public void retrieveInfo() {
        Call<FoodInfo> call = ApiBarcode.getPosts(barcodeText.toString());

        call.enqueue(new Callback<FoodInfo>() {
            @Override
            public void onResponse(@NotNull Call<FoodInfo> call, @NotNull Response<FoodInfo> response) {
                assert response.body() != null;
                if (response.body().getProduct() != null) {
                    //Bron: https://stackoverflow.com/questions/9366280/android-round-to-2-decimal-places
                    DecimalFormat format = new DecimalFormat("#.##");

                    FoodInfo posten = response.body();
                    String nutriments = "";

                    if (posten.getProduct().getNutriments() != null) {
                        Nutri nutri = posten.getProduct().getNutriments();
                        if (isEmpty(nutri.getEnergyValue()))
                            nutriments += "energy: " + format.format(nutri.getEnergyValue()) + nutri.getEnergyKcalUnit() + "\n";
                        if (isEmpty(nutri.getSugarsValue()))
                            nutriments += "sugar: " + format.format(nutri.getSugarsValue()) + nutri.getSugarsUnit() + "\n";
                        if (isEmpty(nutri.getSaturatedFatValue()))
                            nutriments += "fat: " + format.format(nutri.getSaturatedFatValue()) + nutri.getSaturatedFatUnit() + "\n";
                        if (isEmpty(nutri.getFiberValue()))
                            nutriments += "fiber: " + format.format(nutri.getFiberValue()) + nutri.getFiberUnit() + "\n";
                        if (isEmpty(nutri.getProteinsValue()))
                            nutriments += "proteins: " + format.format(nutri.getProteinsValue()) + nutri.getProteinsUnit() + "\n";
                        if (isEmpty(nutri.getSodiumValue()))
                            nutriments += "sodium: " + format.format(nutri.getSodiumValue()) + nutri.getSodiumUnit() + "\n";
                        if (isEmpty(nutri.getIronValue()))
                            nutriments += "iron: " + format.format(nutri.getIronValue()) + nutri.getIronUnit() + "\n";
                        if (isEmpty(nutri.getSaltValue()))
                            nutriments += "salt: " + format.format(nutri.getSaltValue()) + nutri.getSaltUnit() + "\n";
                        if (isEmpty(nutri.getCalciumValue()))
                            nutriments += "calcium: " + format.format(nutri.getCalciumValue()) + nutri.getCalciumUnit() + "\n";
                        if (isEmpty(nutri.getCarbohydratesValue()))
                            nutriments += "carbohydrate: " + format.format(nutri.getCarbohydratesValue()) + nutri.getCarbohydratesUnit() + "\n";
                        if (isEmpty(nutri.getCholesterolValue()))
                            nutriments += "cholesterol: " + format.format(nutri.getCholesterolValue()) + nutri.getCholesterolUnit() + "\n";
                    } else if (posten.getProduct().getNutriscore_data() != null) {
                        NutriScoreData nutriScoreData = posten.getProduct().getNutriscore_data();
                        if (isEmpty(nutriScoreData.getEnergy_value()))
                            nutriments += "energy: " + format.format(nutriScoreData.getEnergy_value()) + "kcal\n";
                        if (isEmpty(nutriScoreData.getSugars()))
                            nutriments += "sugar: " + format.format(nutriScoreData.getSugars()) + "g\n";
                        if (isEmpty(nutriScoreData.getSaturated_fat()))
                            nutriments += "fat: " + format.format(nutriScoreData.getSaturated_fat()) + "g\n";
                        if (isEmpty(nutriScoreData.getFiber()))
                            nutriments += "fiber: " + format.format(nutriScoreData.getFiber()) + "g\n";
                        if (isEmpty(nutriScoreData.getProteins()))
                            nutriments += "proteins: " + format.format(nutriScoreData.getProteins()) + "g\n";
                        if (isEmpty(nutriScoreData.getSodium_value()))
                            nutriments += "sodium: " + format.format(nutriScoreData.getSodium_value()) + "g\n";
                    } else {
                        nutriments += R.string.not_in_database;
                    }

                    if (nutriments.isEmpty()) {
                        nutriments += "not nutriments available" + "\n";
                    }
                    Glide.with(FoodActivity.this).load(posten.getProduct().getImage_url()).into(urlProduct);


                    productName.setText(posten.getProduct().getName());
                    nutriscore.setText(nutriments);
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
                                mNovaGroup.setBackgroundColor(getResources().getColor(R.color.nova_1));
                                break;
                            case 2:
                                mNovaGroup.setBackgroundColor(getResources().getColor(R.color.nova_2));
                                break;
                            case 3:
                                mNovaGroup.setBackgroundColor(getResources().getColor(R.color.nova_3));
                                break;
                            case 4:
                                mNovaGroup.setBackgroundColor(getResources().getColor(R.color.nova_4));
                                break;
                            default:
                                mNovaGroup.setBackgroundColor(getResources().getColor(R.color.white_color));
                                break;
                        }
                    }

                } else {
                    Log.d("MainFail", R.string.not_in_database + String.valueOf(response.code()));
                    Toast.makeText(FoodActivity.this, R.string.not_in_database, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FoodActivity.this, ScannerActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<FoodInfo> call, Throwable t) {
                Log.d("MainFail", R.string.not_responding_database + t.getMessage());
                Toast.makeText(FoodActivity.this, R.string.not_in_database, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private boolean isEmpty(double value) {
        return value != 0;
    }

    public void Scan(View view) {
        startActivity(cameraScan);
    }

    public void searchRecipe(View view) {
        if (!isEmpty(editTextProductName)) {
            searchKey.putExtra(RecipeActivity.EXTRA_Recieve_SearchKey, editTextProductName.getText().toString());
            startActivity(searchKey);
        } else {
            Toast.makeText(this, R.string.no_search_key, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    public void goToSite(View view) {
        if (view.getId() == R.id.btn_product_nutri_score) {
            String url = "https://nl.wikipedia.org/wiki/Nutri-Score";
            Uri page = Uri.parse(url);
            Intent send = new Intent(Intent.ACTION_VIEW, page);
            if (send.resolveActivity(getPackageManager()) != null) {
                startActivity(send);
            } else {
                Toast.makeText(this, R.string.no_valid_browser, Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId() == R.id.btn_product_nova_score) {
            String url = "https://world.openfoodfacts.org/nova";
            Uri page = Uri.parse(url);
            Intent send = new Intent(Intent.ACTION_VIEW, page);
            if (send.resolveActivity(getPackageManager()) != null) {
                startActivity(send);
            } else {
                Toast.makeText(this, R.string.no_valid_browser, Toast.LENGTH_SHORT).show();
            }
        }
    }
}