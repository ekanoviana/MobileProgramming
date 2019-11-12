package com.coba.myviewandviewstrue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnmove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Pesawat R80");
        }
        btnmove = findViewById(R.id.btndonasi);
        btnmove.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btndonasi:
                Intent moveActivity = new Intent(MainActivity.this, DonasiActivity.class);
                startActivity(moveActivity);
                break;
        }
    }
}

