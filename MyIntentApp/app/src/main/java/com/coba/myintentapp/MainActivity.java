package com.coba.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMoveActivity;
    Button btnMoveActivityWithData;
    Button btnDial;
    Button btnWebsite;
    Button btnKumpulkan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveActivityWithData = findViewById(R.id.btn_move_data);
        btnMoveActivityWithData.setOnClickListener(this);

        btnDial = findViewById(R.id.btn_dial);
        btnDial.setOnClickListener(this);

        btnWebsite = findViewById(R.id.btn_website);
        btnWebsite.setOnClickListener(this);

        btnKumpulkan = findViewById(R.id.btn_input);
        btnKumpulkan.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_move_activity:
                Intent moveActivity = new Intent(MainActivity.this, NewActivity.class);
                startActivity(moveActivity);
                break;

            case R.id.btn_move_data:
                Intent moveActivityWithData = new Intent(MainActivity.this, MoveActivityWithData.class);
                moveActivityWithData.putExtra(MoveActivityWithData.EXTRA_NAME, "Ekanoviana");
                moveActivityWithData.putExtra(MoveActivityWithData.EXTRA_AGE, 17);
                startActivity(moveActivityWithData);
                break;

            case R.id.btn_dial:
                String phoneNumber = "085602290504";
                Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhone);
                break;

            case R.id.btn_website:
                String AlamatWeb = "http://polines.ac.id";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(AlamatWeb)));
                break;

            case R.id.btn_input:
                Intent ActivityKumpulkan = new Intent(MainActivity.this, EditTextActivity.class);
                startActivity(ActivityKumpulkan);

        }

    }
}
