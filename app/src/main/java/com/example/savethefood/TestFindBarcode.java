package com.example.savethefood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestFindBarcode extends AppCompatActivity {

    private TextView nameProduct;

    FoodAPI ApiBarcode;

    private Intent cameraScan;
    private String barcodeText;
    private String url = "https://world.openfoodfacts.org/api/v0/product/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_info);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://world.openfoodfacts.org/api/v0/product/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiBarcode = retrofit.create(FoodAPI.class);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);


        TextView barcode = findViewById(R.id.text_Barcode);


        cameraScan = new Intent(this,Scanner.class);

        //private BarcodeInfo data;
        Intent recieveBarcode = getIntent();

        barcodeText = recieveBarcode.getStringExtra(Scanner.EXTRA_RETURN_BARCODE);

        barcode.setText(barcodeText);

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
                if (response.isSuccessful())
                {
                    BarcodeInfo posten = response.body();

                    String message = "";
                    message += "Barcode: " + posten.getBarCode() + "\n";
                    message += "Naam: " + posten.getProduct().getName() + "\n";
                    message += "Status: " + posten.getStatus() + "\n";

                    nameProduct.append(message);
                    url = posten.getProduct().getImage_url();

                }
                else
                {
                    Log.d("MainFail","Niet Succesfull" +response.code());
                }
            }

            @Override
            public void onFailure(Call<BarcodeInfo> call, Throwable t) {
                Log.d("MainFail","Niet gelukt" + t.getMessage());
            }
        });
    }

    public void Scan(View view) {
        startActivity(cameraScan);
    }
}