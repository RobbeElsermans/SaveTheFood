package com.example.savethefood.Food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.bumptech.glide.RequestBuilder;
import com.example.savethefood.Food.Model.FoodInfo;
import com.example.savethefood.Food.Model.Nutri;
import com.example.savethefood.Food.Model.NutriScoreData;
import com.example.savethefood.R;
import com.example.savethefood.Scanner.ScannerActivity;
import com.example.savethefood.Recipe.RecipeActivity;

import java.text.DecimalFormat;


public class FoodActivity extends AppCompatActivity {

    //private BarcodeInfo data;
    private Intent recieveBarcode;
    private Intent searchKey;

    private TextView barcode;
    private TextView nutriscore;
    private ImageView urlProduct;
    private ImageView nutriGrade;
    private TextView productName;
    private EditText editTextProductName;
    private RequestBuilder requestBuilder;

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

        cameraScan = new Intent(this, ScannerActivity.class);
        searchKey  = new Intent(this, RecipeActivity.class);

        recieveBarcode = getIntent();

        barcodeText = recieveBarcode.getStringExtra(ScannerActivity.EXTRA_RETURN_BARCODE);

        barcode.setText("barcode: " + barcodeText);

        retrieveInfo();

        //barInfoRetreiver = new APIBarcode(url, barcodeText);

        //data = barInfoRetreiver.getRequest();

        //dataBarcode.setText(data.toString());
    }

    public void retrieveInfo(){
        Call<FoodInfo> call = ApiBarcode.getPosts(barcodeText.toString());

        call.enqueue(new Callback<FoodInfo>() {
            @Override
            public void onResponse(Call<FoodInfo> call, Response<FoodInfo> response) {
                if (response.body().getProduct() != null)
                {
                    //Bron: https://stackoverflow.com/questions/9366280/android-round-to-2-decimal-places
                    DecimalFormat format = new DecimalFormat("#.##");
                    
                    FoodInfo posten = response.body();
                    String nutriments = "";

                    if (posten.getProduct().getNutriments() != null)
                    {
                        Nutri nutri = posten.getProduct().getNutriments();
                        if(nutri.getEnergyValue() != 0) nutriments += "energy: " + format.format(nutri.getEnergyValue()) + nutri.getEnergyKcalUnit()+"\n";
                        if(nutri.getSugarsValue() != 0) nutriments += "sugar: "+ format.format(nutri.getSugarsValue()) + nutri.getSugarsUnit() +"\n";
                        if(nutri.getSaturatedFatValue() != 0) nutriments += "fat: " + format.format(nutri.getSaturatedFatValue()) +nutri.getSaturatedFatUnit()+ "\n";
                        if(nutri.getFiberValue() != 0) nutriments += "fiber: " + format.format(nutri.getFiberValue()) +nutri.getFiberUnit()+ "\n";
                        if(nutri.getProteinsValue() != 0) nutriments += "proteins: " + format.format(nutri.getProteinsValue()) + nutri.getProteinsUnit() +"\n";
                        if(nutri.getSodiumValue() != 0) nutriments += "sodium: " + format.format(nutri.getSodiumValue()) + nutri.getSodiumUnit()+ "\n";
                        if(nutri.getIronValue() != 0) nutriments += "iron: " + format.format(nutri.getIronValue()) + nutri.getIronUnit()+ "\n";
                        if(nutri.getSaltValue() != 0) nutriments += "salt: " + format.format(nutri.getSaltValue()) + nutri.getSaltUnit()+ "\n";
                        if(nutri.getCalciumValue() != 0) nutriments += "calcium: " + format.format(nutri.getCalciumValue()) + nutri.getCalciumUnit()+ "\n";
                        if(nutri.getCarbohydratesValue() != 0) nutriments += "carbohydrate: " + format.format(nutri.getCarbohydratesValue()) + nutri.getCarbohydratesUnit()+ "\n";
                        if(nutri.getCholesterolValue() != 0) nutriments += "cholesterol: " + format.format(nutri.getCholesterolValue()) + nutri.getCholesterolUnit()+ "\n";
                    }
                    else if(posten.getProduct().getNutriscore_data() != null)
                    {
                        NutriScoreData nutriScoreData = posten.getProduct().getNutriscore_data();
                        if(nutriScoreData.getEnergy_value() != 0) nutriments += "energy: " + format.format(nutriScoreData.getEnergy_value()) + "kcal\n";
                        if(nutriScoreData.getSugars() != 0) nutriments += "sugar: "+ format.format(nutriScoreData.getSugars()) + "g\n";
                        if(nutriScoreData.getSaturated_fat() != 0) nutriments += "fat: " + format.format(nutriScoreData.getSaturated_fat()) + "g\n";
                        if(nutriScoreData.getFiber() != 0) nutriments += "fiber: " + format.format(nutriScoreData.getFiber()) + "g\n";
                        if(nutriScoreData.getProteins() != 0) nutriments += "proteins: " + format.format(nutriScoreData.getProteins()) + "g\n";
                        if(nutriScoreData.getSodium_value() != 0) nutriments += "sodium: " + format.format(nutriScoreData.getSodium_value()) + "g\n";
                    }
                    else
                    {
                        nutriments += R.string.not_in_database;
                    }

                    Glide.with(FoodActivity.this).load(posten.getProduct().getImage_url()).into(urlProduct);


                    productName.setText(posten.getProduct().getName());
                    nutriscore.setText(nutriments);
                    editTextProductName.setText(posten.getProduct().getName());
                }
                else
                {
                    Log.d("MainFail",R.string.not_in_database + String.valueOf(response.code()));
                    Toast.makeText(FoodActivity.this, R.string.not_in_database, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FoodActivity.this, ScannerActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<FoodInfo> call, Throwable t) {
                Log.d("MainFail",R.string.not_responding_database + t.getMessage());
                Toast.makeText(FoodActivity.this, R.string.not_in_database, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void Scan(View view) {
        startActivity(cameraScan);
    }

    public void searchRecipe(View view) {
        if (!isEmpty(editTextProductName))
        {
            searchKey.putExtra(RecipeActivity.EXTRA_Recieve_SearchKey, editTextProductName.getText().toString());
            startActivity(searchKey);
        }
        else{
            Toast.makeText(this, R.string.no_search_key, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
}