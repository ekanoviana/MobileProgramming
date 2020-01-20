package com.nop.rekapsurat;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class MyViewHolder extends RecyclerView.ViewHolder {
    View myview;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        myview=itemView;
    }

    public void setNosurat(String nosurat){
        TextView mNosurat = myview.findViewById(R.id.noSurat);
        mNosurat.setText(nosurat);
    }

    public void setNote(String note){
        TextView mNote = myview.findViewById(R.id.note);
        mNote.setText(note);
    }


    public void setPerihal(String perihal){
        TextView mPerihal = myview.findViewById(R.id.perihal);
        mPerihal.setText(perihal);
    }

    public void setPengirim(String pengirim) {
        TextView mPengirim = myview.findViewById(R.id.amount);
        mPengirim.setText(pengirim);
    }
}
