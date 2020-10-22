package com.example.savethefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TestFindBarcode extends AppCompatActivity {

    private Intent recieveBarcode;
    private TextView barcode;
    private Intent cameraScan;
    private APIBarcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_find_barcode);

        cameraScan = new Intent(this,Scanner.class);

        recieveBarcode = getIntent();
        barcode = findViewById(R.id.text_Barcode);

        barcode.setText(recieveBarcode.getStringExtra(Scanner.EXTRA_RETURN_BARCODE));


    }

    public void Scan(View view) {
        startActivity(cameraScan);
    }
}