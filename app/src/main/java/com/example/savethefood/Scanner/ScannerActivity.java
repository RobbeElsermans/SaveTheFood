package com.example.savethefood.Scanner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.savethefood.Food.FoodActivity;
import com.example.savethefood.NetworkCheck;
import com.example.savethefood.R;
import com.google.zxing.Result;

/*  Bronnen
https://github.com/yuriy-budiyev/code-scanner
https://androiddvlpr.com/zxing-android-example/
https://androidhiro.com/source/android/example/code-scanner/5610
https://androiddvlpr.com/zxing-android-example/

 */

public class ScannerActivity extends AppCompatActivity {

    public final static String EXTRA_RETURN_BARCODE = "com.example.Scanner.RETURN_BARCODE";
    Intent returnBarcode;

    private CodeScanner codeScanner;
    private CodeScannerView scannerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!NetworkCheck.getInstance(this).isOnline())
        {
            Toast.makeText(this,"Please enable internet connectivity for best experience",Toast.LENGTH_LONG).show();
            finish();
        }

        Intent ReceiveIntent = getIntent();

        setContentView(R.layout.activity_scanner);
        scannerview = findViewById(R.id.scanner_view);
        codeScanner = new CodeScanner(this, scannerview);

        returnBarcode = new Intent(this, FoodActivity.class);


        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        returnBarcode.putExtra(EXTRA_RETURN_BARCODE, result.getText());
                        startActivity(returnBarcode);
                        finish();
                    }
                });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        codeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        super.onPause();
        codeScanner.releaseResources();
    }
}