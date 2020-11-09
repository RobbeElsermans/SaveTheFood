package com.example.savethefood;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private Intent cameraScan;
    private Intent searchRecipe;

    private EditText searchKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraScan = new Intent(this,Scanner.class);
        searchRecipe = new Intent(this, getRecipeInfo.class);

        searchKey = findViewById(R.id.search_bar_item);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);
    }

    public void scan(View view)
    {
        startActivity(cameraScan);
    }

    public void searchRecipe(View view) {
        if (!isEmpty(searchKey))
        {
            searchRecipe.putExtra(getRecipeInfo.EXTRA_Recieve_SearchKey, searchKey.getText().toString());
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
}