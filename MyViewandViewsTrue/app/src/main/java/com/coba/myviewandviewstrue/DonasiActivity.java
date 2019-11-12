package com.coba.myviewandviewstrue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;



public class DonasiActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi);

        Toolbar toolbarq = (Toolbar) findViewById(R.id.toolbarku);
        setSupportActionBar(toolbarq);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView title = (TextView) toolbarq.findViewById(R.id.titlebar);
    }
}
