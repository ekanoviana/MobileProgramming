package com.coba.resepmasakantradisional;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailListMakanan extends AppCompatActivity {

    private int makanan_id;
    ImageView imgDetail;
    TextView tvName, tvDesc;
    private ArrayList<Makanan> listmakanan = new ArrayList<>();
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_makanan);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#053E77")));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        makanan_id = getIntent().getIntExtra("makanan_id", 0);
        tvName = findViewById(R.id.nama_makanan);
        tvDesc = findViewById(R.id.desc_detail);
        imgDetail = findViewById(R.id.img_detail);

        listmakanan.addAll(MakananData.getListData());
        setLayou();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String title = getIntent().getStringExtra("makanan_id2");
        getSupportActionBar().setTitle(title);
    }

        void setLayou() {
            tvName.setText(listmakanan.get(makanan_id).getName());
            tvDesc.setText(listmakanan.get(makanan_id).getDescription());
            Glide.with(this)
                    .load(listmakanan.get(makanan_id).getPhoto())
                    .apply(new RequestOptions().fitCenter())
                    .into(imgDetail);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.myProfile:
                Intent MoveProfil = new Intent(DetailListMakanan.this, ProfilActivity.class);
                startActivity(MoveProfil);

                return true;
        }
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}
