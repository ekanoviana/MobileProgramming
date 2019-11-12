package com.coba.resepmasakantradisional;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMakanan;
    private ArrayList<Makanan> list = new ArrayList<>();
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#053E77")));

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Makanan Tradisional");
        }

        rvMakanan = findViewById(R.id.rv_makanan);
        rvMakanan.setHasFixedSize(true);

        list.addAll(MakananData.getListData());
        showRecycleList();
    }

    private void showRecycleList(){
        rvMakanan.setLayoutManager(new LinearLayoutManager(this));
        CardMakananAdapter cardMakananAdapter = new CardMakananAdapter(this, list);
        rvMakanan.setAdapter(cardMakananAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.myProfile:
                Intent MoveProfil = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(MoveProfil);

                return true;
        }
        return false;
    }
}
