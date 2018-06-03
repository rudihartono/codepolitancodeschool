package com.codepolitan.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //variable di java
    int x = 0;
    String name = "Rudi Hartono";
    GoodCat harimau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        harimau = new GoodCat();

        harimau.setSize(15);

        Button namaKucing = (Button)findViewById(R.id.namaKucing);
        Button ukuranCat = (Button)findViewById(R.id.ukuranCat);


        namaKucing.setText(harimau.getName());


        ukuranCat.setText(harimau.getSize());
    }

    public void method(){
        int x = 1; //internal variable

        this.x  = x;
    }
}
