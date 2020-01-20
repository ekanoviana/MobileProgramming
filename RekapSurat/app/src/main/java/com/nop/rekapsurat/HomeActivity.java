package com.nop.rekapsurat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nop.rekapsurat.model.Data;

import java.text.DateFormat;
import java.util.Date;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_plus;
    private FloatingActionButton btn_main, btn_lang, btn_profil;

    float translationY = 100f;
    Boolean isMenuOpen = false;

    OvershootInterpolator interpolator = new OvershootInterpolator();

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    private RecyclerView recyclerView;

    //private TextView totalResult;

    //Global Variable
    private String nosurat;
    //private int amount;
    private String pengirim;
    private String perihal;
    private String note;
    private String post_key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Firebase code
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uId = mUser.getUid();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Daftar Belanja").child(uId);
        mDatabase.keepSynced(true);

        //floating button setting and profile
        floatingMenu();

        //button tambah data
        btn_plus = findViewById(R.id.btn_input);
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
            }
        });

        //deklarasi layout
        recyclerView = findViewById(R.id.recycler_home);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

    }


//floating button settings and profil
    private void floatingMenu(){
        btn_main = findViewById(R.id.fab_main);
        btn_lang = findViewById(R.id.fab_language);
        btn_profil = findViewById(R.id.fab_profil);

        btn_lang.setTranslationY(translationY);
        btn_profil.setTranslationY(translationY);

        btn_lang.setAlpha(0f);
        btn_profil.setAlpha(0f);

        btn_main.setOnClickListener(this);
        btn_profil.setOnClickListener(this);
        btn_lang.setOnClickListener(this);
    }

    private void openMenu(){
        isMenuOpen = !isMenuOpen;

        btn_main.animate().setInterpolator(interpolator).rotation(45f).setDuration(300).start();

        btn_lang.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        btn_profil.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
    }

    private void closeMenu(){
        isMenuOpen = !isMenuOpen;

        btn_main.animate().setInterpolator(interpolator).rotation(0f).setDuration(300).start();

        btn_lang.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        btn_profil.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
    }

//dialog input surat
    private void customDialog(){
        AlertDialog.Builder mydialog = new AlertDialog.Builder(HomeActivity.this);

        LayoutInflater inflater = LayoutInflater.from(HomeActivity.this);
        View myview = inflater.inflate(R.layout.input_data, null);
        final AlertDialog dialog = mydialog.create();
        dialog.setView(myview);
        dialog.show();

        final EditText nosurat = myview.findViewById(R.id.edt_nomor);
        //final EditText amount = myview.findViewById(R.id.edt_amount);
        final EditText pengirim = myview.findViewById(R.id.edt_amount);
        final EditText perihal = myview.findViewById(R.id.edt_perihal);
        final EditText note = myview.findViewById(R.id.edt_note);
        Button btnSave = myview.findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mNosurat = nosurat.getText().toString().trim();
                //String mAmount = amount.getText().toString().trim();
                String mPengirim = pengirim.getText().toString().trim();
                String mPerihal = perihal.getText().toString().trim();
                String mNote = note.getText().toString().trim();

               // int ammint = Integer.parseInt(mAmount);

                if(TextUtils.isEmpty(mNosurat)){
                    nosurat.setError("Require Field...");
                    return;
                }

                if(TextUtils.isEmpty(mPengirim)){
                    pengirim.setError("Require Field...");
                    return;
                }

                if(TextUtils.isEmpty(mPerihal)){
                    perihal.setError("Require Field...");
                    return;
                }

                if (TextUtils.isEmpty(mNote)){
                    note.setError("Require Field...");
                    return;
                }

                String id = mDatabase.push().getKey();
                //String date = DateFormat.getDateInstance().format(new Date());
                Data data = new Data(mNosurat, mPengirim, mPerihal , mNote, id);
                mDatabase.child(id).setValue(data);

                Toast.makeText(getApplicationContext(), "Data Add", Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    protected void onStart(){
        super.onStart();

        FirebaseRecyclerAdapter<Data, MyViewHolder> adapter = new FirebaseRecyclerAdapter<Data, MyViewHolder>
                (
                        Data.class,
                        R.layout.item_data,
                        MyViewHolder.class,
                        mDatabase
                )
        {
            @Override
            protected void populateViewHolder(MyViewHolder viewHolder, final Data model, final int position) {
                //viewHolder.setDate(model.getDate());
                viewHolder.setNosurat(model.getNosurat());
                //viewHolder.setAmount(model.getAmount());
                viewHolder.setPengirim(model.getPengirim());
                viewHolder.setPerihal(model.getPerihal());
                viewHolder.setNote(model.getNote());

                viewHolder.myview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        post_key = getRef(position).getKey();
                        nosurat=model.getNosurat();
                        //amount=model.getAmount();
                        pengirim=model.getPengirim();
                        perihal=model.getPerihal();
                        note=model.getNote();


                        updateData();
                    }
                });
            }
        };

        recyclerView.setAdapter(adapter);
    }

    public void updateData(){
        AlertDialog.Builder mydialog = new AlertDialog.Builder(HomeActivity.this);
        LayoutInflater inflater = LayoutInflater.from(HomeActivity.this);
        View mView = inflater.inflate(R.layout.update_input, null);

        final AlertDialog dialog = mydialog.create();
        dialog.setView(mView);

        final EditText edt_nosurat = mView.findViewById(R.id.edt_nosurat_upd);
        final EditText edt_pengirim = mView.findViewById(R.id.edt_pengirim_upd);
        final EditText edt_perihal = mView.findViewById(R.id.edt_perihal_upd);
        final EditText edt_note = mView.findViewById(R.id.edt_note_upd);

        edt_nosurat.setText(nosurat);
        edt_nosurat.setSelection(nosurat.length());

        edt_pengirim.setText(pengirim);
        edt_pengirim.setSelection(pengirim.length());

        edt_perihal.setText(perihal);
        edt_perihal.setSelection(perihal.length());

//        edt_amount.setText(String.valueOf(amount));
//        edt_amount.setSelection(String.valueOf(amount).length());

        edt_note.setText(note);
        edt_note.setSelection(note.length());

        Button btnUpdate = mView.findViewById(R.id.btn_save_upd);
        Button btnDelete = mView.findViewById(R.id.btn_delete_upd);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nosurat = edt_nosurat.getText().toString().trim();
                pengirim = edt_pengirim.getText().toString().trim();
                perihal = edt_perihal.getText().toString().trim();
                //String mAmount = String.valueOf(amount);
                //mAmount = edt_amount.getText().toString().trim();
                note = edt_note.getText().toString().trim();

                //int intAmount = Integer.parseInt(mAmount);
                //String date = DateFormat.getDateInstance().format(new Date());

                Data data = new Data(nosurat, pengirim, perihal, note, post_key);
                //nosurat, pengirim, perihal, note, post_key;
                mDatabase.child(post_key).setValue(data);
                dialog.dismiss();

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.child(post_key).removeValue();

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.log_out:
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_main:
                if (isMenuOpen){
                    closeMenu();
                }else {
                    openMenu();
                }
                break;
            case R.id.fab_language:
                if (isMenuOpen){
                    closeMenu();
                    Intent languageIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                    startActivity(languageIntent);
                }else {
                    openMenu();
                }
                break;
            case R.id.fab_profil:
                if (isMenuOpen){
                    closeMenu();
                    startActivity(new Intent(getApplicationContext(), ProfilActivity.class));
                }else {
                    openMenu();
                }
                break;
        }
    }
}

