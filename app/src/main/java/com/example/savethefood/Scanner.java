package com.example.savethefood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class Scanner extends AppCompatActivity {

    public final static String EXTRA_RETURN_BARCODE = "com.example.Scanner.RETURN_BARCODE";
    Intent returnBarcode;

    CodeScanner codeScanner;
    CodeScannerView scannerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        scannerview = findViewById(R.id.scanner_view);
        codeScanner = new CodeScanner(this, scannerview);

        returnBarcode = new Intent(this, getBarcodeInfo.class);

        Intent ReceiveIntent = getIntent();

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

    public void newScan(View view) {
        codeScanner.startPreview();
    }
}