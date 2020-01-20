package com.nop.rekapsurat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ProfilActivity extends AppCompatActivity {

    ViewPager viewPager;
    AdapterProfil adapterProfil;
    List<ModelProfil> modelProfils = new ArrayList<>();
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        modelProfils.add(new ModelProfil(R.drawable.ekanovi, "Eka Novi Ana Nur Anisa", "ekanoviana100@gmail.com"));
        modelProfils.add(new ModelProfil(R.drawable.royyan, "Royyan Mustawan", "royyanmustawan@gmail.com"));

        adapterProfil = new AdapterProfil(modelProfils, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapterProfil);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapterProfil.getCount() -1) && position < (colors.length -1)){
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position +1]
                            )
                    );
                }else {
                    viewPager.setBackgroundColor(colors[colors.length -1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
