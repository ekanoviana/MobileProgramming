package com.coba.mylocalizationn;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false);
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_profile, null);

        TextView tvName = root.findViewById(R.id.tv_name);
        TextView tvAdd = root.findViewById(R.id.tv_alamat);
        TextView tvHobby = root.findViewById(R.id.tv_hobi);
        TextView tvQuote = root.findViewById(R.id.tv_quote);

        return root;
    }

}
