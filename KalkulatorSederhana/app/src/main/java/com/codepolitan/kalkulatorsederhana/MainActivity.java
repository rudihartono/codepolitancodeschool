package com.codepolitan.kalkulatorsederhana;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText etAngka1, etAngka2;
    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //perintah menampilkan ke layar
        setContentView(R.layout.activity_main);

        etAngka1 = (EditText) findViewById(R.id.editTextAngkaPertama);
        etAngka2 = (EditText)findViewById(R.id.editTextAngkaKedua);

        txtHasil = (TextView)findViewById(R.id.txtHasil);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void onClickedBtnKurang(View view){

        //body method

    }

    public void onClickedBtnTambah(View view) {

        // ini perintah untuk mengambil data dari form edit text
        String angka1 = etAngka1.getText().toString();
        String angka2 = etAngka2.getText().toString();

        if( TextUtils.isEmpty(angka1) || TextUtils.isEmpty(angka2) ){

            Toast.makeText(this, "Masukan kedua angka terlebih dahulu", Toast.LENGTH_LONG).show();

        }
        else{
            Double hasil = Double.valueOf(angka1) + Double.valueOf(angka2);

            //menampilkan hasil penjumlahan ke txtview hasil
            txtHasil.setText(String.valueOf(hasil));

            Intent intent = new Intent(this, SecondActivity.class);

            intent.putExtra("HASIL", hasil); //type data yang dikirim double
            intent.putExtra("ANGKA1", angka1); //type data yang dikirim string
            intent.putExtra("ANGKA2", angka2); //type data yang dikirim string

            //perintah untuk pindahnya
            startActivity(intent);
        }


    }

    public void onClickedBagi(View view) {
    }

    public void onClickedBtnKali(View view) {
    }
}
