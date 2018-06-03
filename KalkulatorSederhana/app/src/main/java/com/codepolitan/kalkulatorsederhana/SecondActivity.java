package com.codepolitan.kalkulatorsederhana;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtHasil;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Double hasil = getIntent().getDoubleExtra("HASIL", 0); //disesuaikan dengan apa yang dikirim dari activity sumber (sebelumnya)
        String angka1 = getIntent().getStringExtra("ANGKA1");
        String angka2 = getIntent().getStringExtra("ANGKA2");

        Log.d("SecondActiviry", "hasil tambah dari "+ angka1 + " + " + angka2 + " = " + hasil);

        txtHasil = (TextView)findViewById(R.id.txtHasilPage2);

        //tampilkan di layar/text view yang sudah dibikin "Hasil tambah 10 + 0 = 10"

        String sample = "saya " + "makan"; // saya makan
        sample = "saya + makan"; // saya + makan

        String message = "hasil tambah dari "+ angka1 + " + " + angka2 + " = " + (hasil + 1000);

        txtHasil.setText(message);
    }

    //implementasi implicit intent
    public void BukaGoogle(View view) {
        Uri webpage = Uri.parse("http://google.com");
        Uri tel = Uri.parse("tel:082129290963");

        //keyword untuk mengekplorasi jenis actionnya ketika saya ACTION
        // https://developer.android.com/guide/components/intents-common
        Intent intent = new Intent(Intent.ACTION_VIEW, tel);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        intent = new Intent(Intent.ACTION_VIEW, webpage);

        startActivity(intent);
    }
}
