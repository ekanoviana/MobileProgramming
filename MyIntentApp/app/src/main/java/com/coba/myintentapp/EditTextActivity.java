package com.coba.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditTextActivity extends AppCompatActivity {

    EditText ET;
    Button btnKumpul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        ET = findViewById(R.id.ET_kumpul);
        btnKumpul = findViewById(R.id.btn_kumpul);

        btnKumpul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kumpul = ET.getText().toString();
                startActivity(new Intent(EditTextActivity.this, Tampilkan2Activity.class).putExtra("value", kumpul));
            }
        });
    }
}
