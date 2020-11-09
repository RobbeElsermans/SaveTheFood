package com.example.savethefood;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

/*  Bronnen
https://github.com/yuriy-budiyev/code-scanner
https://androiddvlpr.com/zxing-android-example/
https://androidhiro.com/source/android/example/code-scanner/5610
https://androiddvlpr.com/zxing-android-example/

 */

public class Scanner extends AppCompatActivity {

    public final static String EXTRA_RETURN_BARCODE = "com.example.Scanner.RETURN_BARCODE";
    Intent returnBarcode;

    private CodeScanner codeScanner;
    private CodeScannerView scannerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent ReceiveIntent = getIntent();

        setContentView(R.layout.activity_scanner);
        scannerview = findViewById(R.id.scanner_view);
        codeScanner = new CodeScanner(this, scannerview);

        returnBarcode = new Intent(this, getBarcodeInfo.class);


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