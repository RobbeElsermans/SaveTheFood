package com.example.savethefood;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    Intent retrieveBarcode = new Intent(this, Scanner.class);
    private Intent sendBarcode = new Intent();

    private String barcode = " ";

    public static final int BARCODE_REQUEST_FIND = 10;
    public static final int BARCODE_REQUEST_ADD = 11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);
    }

    public void favorite(View view) {
    }

    public void scan(View view) {

        startActivityForResult(new Intent(this,Scanner.class), BARCODE_REQUEST_FIND);
    }

    public void add(View view) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == BARCODE_REQUEST_FIND) {
            if (resultCode == RESULT_OK) {
                barcode = data.getStringExtra(Scanner.EXTRA_RETURN_BARCODE);
                    
                    sendBarcode.putExtra("Barcode", barcode);
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
}