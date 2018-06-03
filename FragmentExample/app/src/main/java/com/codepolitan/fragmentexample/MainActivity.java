package com.codepolitan.fragmentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager().beginTransaction().add(R.id.container, new FirstFragment()).commit();
    }

    public void OnClickedThirdFragment(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ThirdFragment())
                .commit();
    }

    public void OnClickedSecondFragment(View view) {
        //getSupportFragmentManager().beginTransaction()
        //        .replace(R.id.container, new SecondFragment())
        //        .commit();

        Intent intent = new Intent(this, TabActivity.class);
        startActivity(intent);
    }

    public void OnClickedFirstFragment(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FirstFragment())
                .commit();
    }
}
