package com.example.savethefood;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.savethefood.Recipe.RecipeActivity;
import com.example.savethefood.Scanner.ScannerActivity;

public class MainActivity extends AppCompatActivity {

    private Intent cameraScan;
    private Intent searchRecipe;

    private EditText searchKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraScan = new Intent(this, ScannerActivity.class);
        searchRecipe = new Intent(this, RecipeActivity.class);

        searchKey = findViewById(R.id.search_bar_item);

        //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);

        if (!NetworkCheck.getInstance(this).isOnline())
        {
            Toast.makeText(this,"Please enable internet connectivity for best experience",Toast.LENGTH_LONG).show();
        }
    }

    public void scan(View view)
    {
        startActivity(cameraScan);
    }

    public void searchRecipe(View view) {
        if (!isEmpty(searchKey))
        {
            searchRecipe.putExtra(RecipeActivity.EXTRA_Recieve_SearchKey, searchKey.getText().toString());
            startActivity(searchRecipe);
        }
        else{
            Toast.makeText(this, "please enter a search key!", Toast.LENGTH_SHORT).show();
        }
    }

    public void favorite(View view) {
    }

    //bron: https://stackoverflow.com/questions/6290531/check-if-edittext-is-empty
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    public void goToSite(View view) {
        switch (view.getId())
        {
            case R.id.imgview_edamam:
                //Toast.makeText(this, "url naar EDAMAN", Toast.LENGTH_SHORT).show();

                String url = "https://www.edamam.com/";
                Uri pagina = Uri.parse(url);
                Intent send = new Intent(Intent.ACTION_VIEW, pagina);
                if (send.resolveActivity(getPackageManager()) != null) {
                    startActivity(send);
                }
                else
                {
                    Toast.makeText(this, "No valid browser found!", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.imgview_openFoodFacts:
                //Toast.makeText(this, "url naar openFoodfacts", Toast.LENGTH_SHORT).show();

                String url1 = "https://be-en.openfoodfacts.org/";
                Uri pagina1 = Uri.parse(url1);
                Intent send1 = new Intent(Intent.ACTION_VIEW, pagina1);
                if (send1.resolveActivity(getPackageManager()) != null) {
                    startActivity(send1);
                }
                else
                {
                    Toast.makeText(this, "No valid browser found!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == BARCODE_REQUEST_FIND) {
            if (resultCode == RESULT_OK) {
                barcode = data.getStringExtra(Scanner.EXTRA_RETURN_BARCODE);

                    //sendBarcode.putExtra("Barcode", barcode);
                    Toast toast = Toast.makeText(this, barcode, Toast.LENGTH_SHORT);
                    toast.show();
            }
            if (resultCode == RESULT_CANCELED) {
                Toast toast = Toast.makeText(this, "Canceled",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        } else if (requestCode == BARCODE_REQUEST_ADD) {
            if (resultCode == RESULT_OK) {
                //send intent to Add Activity
            }
            if (resultCode == RESULT_CANCELED) {
                Toast toast = Toast.makeText(this, "Canceled",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
    */
    public boolean isNetworkAvailable() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}