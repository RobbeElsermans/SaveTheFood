package com.example.savethefood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{ Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);
    }

    public void Favorite(View view) {
    }

    public void Scan(View view) {
        startActivity(new Intent(getApplicationContext(),Scanner.class));
    }

    public void Add(View view) {
    }
}