package com.codepolitan.sqllitecontactexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TodoListAdapter todoListAdapter;
    ArrayList<Item> todoList = new ArrayList<Item>();

    MyDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        todoListAdapter = new TodoListAdapter(MainActivity.this, this.todoList);
        recyclerView.setAdapter(todoListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //setDummyData();

        //membaca semua data todo di database kemudian dimasukan ke todolist
        database = new MyDatabase(this);

        //database.onUpgrade(database.getDB(),1,1);

        //menambahkan data ke todolist (ArrayList<Item>)
        todoList.addAll(database.readAll());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AddUpdateTodoActivity.class);

                startActivity(intent);
            }
        });
    }

    private void setDummyData(){
        todoList.add(new Item("Buat model", 3));
        todoList.add(new Item("Buat layout item", 1));
        todoList.add(new Item("Buat adapter", 2));
        todoList.add(new Item("Inisialisasi recyclerview", 4));

        todoListAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
