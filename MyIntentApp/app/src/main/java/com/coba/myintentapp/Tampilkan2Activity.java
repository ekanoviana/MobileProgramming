package com.coba.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tampilkan2Activity extends AppCompatActivity {
    TextView Tampilkan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilkan2);

        Tampilkan = findViewById(R.id.TV_tampil);

        String value = getIntent().getStringExtra("value");
        Tampilkan.setText(value);
    }
}
