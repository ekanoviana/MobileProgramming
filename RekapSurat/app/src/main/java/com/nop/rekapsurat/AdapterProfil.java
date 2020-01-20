package com.nop.rekapsurat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class AdapterProfil extends PagerAdapter {

    private List<ModelProfil> modelProfils;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterProfil(List<ModelProfil> modelProfils, Context context) {
        this.modelProfils = modelProfils;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modelProfils.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView;
        TextView tvName, tvEmail;

        imageView = view.findViewById(R.id.img_profil);
        tvName = view.findViewById(R.id.tv_name);
        tvEmail = view.findViewById(R.id.tv_email);

        imageView.setImageResource(modelProfils.get(position).getImage());
        tvName.setText(modelProfils.get(position).getName());
        tvEmail.setText(modelProfils.get(position).getEmail());

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
