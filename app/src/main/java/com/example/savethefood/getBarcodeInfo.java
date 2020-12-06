package com.example.savethefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
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
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;


public class getBarcodeInfo extends AppCompatActivity {

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
        setContentView(R.layout.activity_get_barcode_info);


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
        nutriGrade = findViewById(R.id.imageView_nutri_grade);

        cameraScan = new Intent(this,Scanner.class);
        searchKey  = new Intent(this, getRecipeInfo.class);

        recieveBarcode = getIntent();

        barcodeText = recieveBarcode.getStringExtra(Scanner.EXTRA_RETURN_BARCODE);

        barcode.setText("barcode: " + barcodeText);

        retrieveInfo();

        //barInfoRetreiver = new APIBarcode(url, barcodeText);

        //data = barInfoRetreiver.getRequest();

        //dataBarcode.setText(data.toString());
    }

    public void retrieveInfo(){
        Call<BarcodeInfo> call = ApiBarcode.getPosts(barcodeText.toString());

        call.enqueue(new Callback<BarcodeInfo>() {
            @Override
            public void onResponse(Call<BarcodeInfo> call, Response<BarcodeInfo> response) {
                if (response.body().getProduct() != null)
                {
                    BarcodeInfo posten = response.body();
                    String nutriments = "";
                    nutriments += "energy: " + posten.getProduct().getNutriscore_data().getEnergy_value() + "kcal\n";
                    nutriments += "sugar: "+ posten.getProduct().getNutriscore_data().getSugars() + "g\n";
                    nutriments += "fat: " + posten.getProduct().getNutriscore_data().getSaturated_fat() + "g\n";

                    Glide.with(getBarcodeInfo.this).load(posten.getProduct().getImage_url()).into(urlProduct);
                    //Glide.tearDown();
                    String nutriGradePicture = "https://static.openfoodfacts.org/images/misc/nutriscore-" + posten.getProduct().getNutriscore_grade() + ".svg";
                    Glide.with(getBarcodeInfo.this).load(nutriGradePicture).into(nutriGrade);
                    productName.setText(posten.getProduct().getName());
                    nutriscore.setText(nutriments);
                    editTextProductName.setText(posten.getProduct().getName());
                }
                else
                {
                    Log.d("MainFail","Niet Succesfull" +response.code());
                    Toast.makeText(getBarcodeInfo.this, "not found in database!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getBarcodeInfo.this,Scanner.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<BarcodeInfo> call, Throwable t) {
                Log.d("MainFail","Niet gelukt" + t.getMessage());
                Toast.makeText(getBarcodeInfo.this, "not found in database!", Toast.LENGTH_SHORT).show();
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
            searchKey.putExtra(getRecipeInfo.EXTRA_Recieve_SearchKey, editTextProductName.getText().toString());
            startActivity(searchKey);
        }
        else{
            Toast.makeText(this, "please enter a search key!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
}