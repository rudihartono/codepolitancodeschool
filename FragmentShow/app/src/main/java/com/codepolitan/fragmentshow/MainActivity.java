package com.codepolitan.fragmentshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Dengan line code ini maka activity main akan menampilkan pertama kali adalah first fragment
        getSupportFragmentManager().beginTransaction().add(R.id.container, new SecondFragment())
                .commit();

    }

    public void OpenFragment1(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FirstFragment())
                .commit();
    }

    public void OpenFragment2(View view) {
        getSupportFragmentManager().beginTransaction().add(R.id.container, new SecondFragment())
                .commit();
    }

    public void OpenFragment3(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ThirdFragment())
                .commit();
    }

    public void OpenTabActivity(View view) {

        Intent i = new Intent(this, TabActivity.class);

        startActivity(i);
    }
}
