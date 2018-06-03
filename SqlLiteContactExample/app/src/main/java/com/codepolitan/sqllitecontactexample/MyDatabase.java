package com.codepolitan.sqllitecontactexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudihartono on 6/2/18.
 */

public class MyDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "todo_db";
    private static final String TABLE_TODO = "todo_table";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TODO_NAME = "name";
    private static final String COLUMN_TODO_PRIORITY = "priority";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TODO_TABLE  = "CREATE TABLE " + TABLE_TODO +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_TODO_NAME + " TEXT, " +
                COLUMN_TODO_PRIORITY + " INTEGER" +
                ")";


        Log.d("QUERY_INSERT", CREATE_TODO_TABLE);

        //peritah untuk mengeksekusi script sql di database
        db.execSQL(CREATE_TODO_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        onCreate(db);
    }

    //add item to database table
    public void add(Item newItem){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TODO_NAME, newItem.getName());
        values.put(COLUMN_TODO_PRIORITY, newItem.getPriority());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_TODO, null, values);
    }

    public SQLiteDatabase getDB(){

        SQLiteDatabase db = this.getWritableDatabase();

        return  db;
    }

    //Read from databse
    public List<Item> readAll(){
        String sql = "SELECT * FROM " + TABLE_TODO + " ";
        SQLiteDatabase db = this.getReadableDatabase();

        List<Item> items = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                int priority = cursor.getInt(2);

                items.add(new Item(id, name, priority));
            }while (cursor.moveToNext());
        }

        cursor.close();

        return items;
    }

    //Update data in database
    public void updateItem(Item item){
        ContentValues values = new ContentValues();

        values.put(COLUMN_TODO_NAME, item.getName());
        values.put(COLUMN_TODO_PRIORITY, item.getPriority());

        SQLiteDatabase db = this.getWritableDatabase();

        db.update(TABLE_TODO, values, COLUMN_ID + " = ?", new String[]{String.valueOf(item.getId())});
    }

    //delete data in databse
    public void deleteItem(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TODO, COLUMN_ID + " = ?", new String[] {String.valueOf(id)});
    }
}
