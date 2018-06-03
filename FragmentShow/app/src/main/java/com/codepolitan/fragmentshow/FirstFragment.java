package com.codepolitan.fragmentshow;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    //deklarasi
    TextView txtHasil;
    EditText lebar;
    EditText panjang;
    Button hitungBtn;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        lebar  = (EditText)v.findViewById(R.id.editTextLebar);
        panjang = (EditText)v.findViewById(R.id.editTextPanjang);
        txtHasil = (TextView)v.findViewById(R.id.txtHasilLuasPersegi);
        hitungBtn = (Button)v.findViewById(R.id.btnHitungLuas);

        hitungBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                hitungPersegiPanjang();
            }
        });

        hitungLuasPersegi(10, 10);

        return v;
    }


    public void hitungLuasPersegi(int sisi, int panjang){
        int hasil = sisi * sisi;
    }

    public int hitungLuasPersegi1(int sisi, int panjang){
        int hasil = sisi * sisi;

        return hasil;
    }


    public void hitungPersegiPanjang(){

        // ini perintah untuk mengambil data dari form edit text
        String angka1 = lebar.getText().toString();
        String angka2 = panjang.getText().toString();

        if( TextUtils.isEmpty(angka1) || TextUtils.isEmpty(angka2) ){

            Toast.makeText(this.getActivity(), "Masukan kedua angka terlebih dahulu", Toast.LENGTH_LONG).show();

        }
        else{
            Double hasil = Double.valueOf(angka1) * Double.valueOf(angka2);

            //menampilkan hasil penjumlahan ke txtview hasil
            txtHasil.setText(String.valueOf(hasil));
        }
    }

}
