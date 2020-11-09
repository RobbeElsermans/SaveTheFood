package com.example.savethefood;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;


public class Scanner extends AppCompatActivity {

    public final static String EXTRA_RETURN_BARCODE = "com.example.Scanner.RETURN_BARCODE";
    Intent returnBarcode;

    private CodeScanner codeScanner;
    private CodeScannerView scannerview;
    private CameraManager camManager;

    //Bron: https://ssaurel.medium.com/create-a-torch-flashlight-application-for-android-c0b6951855c
    Button flashButton;
    private boolean flashLightStatus = false;
    boolean hasCameraFlash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent ReceiveIntent = getIntent();
        flashButton = findViewById(R.id.btn_flash);

        hasCameraFlash = getPackageManager().
                hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        boolean isEnabled = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED;


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

                        flashOff();

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

    public void flash(View view) {
        if (hasCameraFlash)
        {
            if (flashLightStatus)
                flashOff();
            else
                flashOn();
        }
    }

    private void flashOn(){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            flashLightStatus = true;
        } catch (CameraAccessException e) {
        }
    }
    private void flashOff(){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
            flashLightStatus = false;
        } catch (CameraAccessException e) {
        }
    }
}