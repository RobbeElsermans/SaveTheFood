package com.example.savethefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TestFindBarcode extends AppCompatActivity {

    Intent recieveBarcode;
    TextView barcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_find_barcode);

        recieveBarcode = getIntent();
        barcode = findViewById(R.id.text_Barcode);

        barcode.setText(recieveBarcode.getStringExtra(Scanner.EXTRA_RETURN_BARCODE));


    }
}