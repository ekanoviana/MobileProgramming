package com.coba.resepmasakantradisional;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardMakananAdapter extends RecyclerView.Adapter<CardMakananAdapter.ListViewHolder>{
    private ArrayList<Makanan> listmakanan;
    private Context context;

    public CardMakananAdapter(Context context, ArrayList<Makanan> listmakanan){
        this.listmakanan = listmakanan;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_makanan, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final Makanan makanan = listmakanan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(makanan.getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(holder.imgPhoto);
        holder.tvName.setText(makanan.getName());
        holder.tvDesc.setText(makanan.getDescription());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailmakanan = new Intent(context, DetailListMakanan.class);
                detailmakanan.putExtra("makanan_id2", makanan.getName());
                detailmakanan.putExtra("makanan_id", makanan.getId());
                context.startActivity(detailmakanan);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listmakanan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        CardView cv;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_makanan_list);
            tvName = itemView.findViewById(R.id.name_makanan_list);
            tvDesc = itemView.findViewById(R.id.desc_makanan_list);
            cv = itemView.findViewById(R.id.cardview_item);
        }
    }
}
