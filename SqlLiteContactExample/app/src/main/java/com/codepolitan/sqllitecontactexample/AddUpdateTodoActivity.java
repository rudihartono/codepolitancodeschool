package com.codepolitan.sqllitecontactexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddUpdateTodoActivity extends AppCompatActivity {

    EditText editTextTodoName;
    EditText editTextTodoPriority;

    MyDatabase database;
    Boolean isEdit = false;
    int todoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update_todo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        editTextTodoName = (EditText)findViewById(R.id.etTodoName);
        editTextTodoPriority = (EditText)findViewById(R.id.etTodoPriority);

        if(getIntent() != null){
            int id = getIntent().getIntExtra("ID", 0);
            String name = getIntent().getStringExtra("NAMA");
            int priority = getIntent().getIntExtra("PRIO", 0);

            if(id != 0){
                isEdit = true;
            }

            todoId = id;
            editTextTodoName.setText(name);
            editTextTodoPriority.setText(String.valueOf(priority));
        }

        database = new MyDatabase(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(editTextTodoName.getText()) || TextUtils.isEmpty(editTextTodoPriority.getText())){

                    Toast.makeText(getApplicationContext(),
                            "nama todo dan priority tidak boleh kosong",
                            Toast.LENGTH_SHORT)
                            .show();

                }else{

                    String name = editTextTodoName.getText().toString();

                    int priority = Integer.parseInt(editTextTodoPriority.getText().toString());


                    if(isEdit == true){
                        Item item = new Item(todoId, name, priority);
                        database.updateItem(item);
                    }else {

                        Item item = new Item(name, priority);
                        database.add(item);
                    }

                    Intent intent = new Intent(AddUpdateTodoActivity.this, MainActivity.class);

                    startActivity(intent);
                    finish();
                }

            }
        });
    }

}
