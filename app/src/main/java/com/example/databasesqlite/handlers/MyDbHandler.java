package com.example.databasesqlite.handlers;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.BaseExpandableListAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.databasesqlite.UpdateData;
import com.example.databasesqlite.models.Model;

import java.nio.file.DirectoryNotEmptyException;
import java.util.ArrayList;

public class MyDbHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "Mess App";
    public static final String TABLE_NAME = "HARJINDER";
    public static final int DB_VERSION = 1;
    public static final String DATE = "Date";
    public static final String BREAKFAST = "Breakfast";
    public static final String LUNCH = "Lunch";
    public static final String SNACKS = "Snacks";
    public static final String DINNER = "Dinner";
    Context context;

    public MyDbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = " CREATE TABLE " + TABLE_NAME + " ( " + DATE + " TEXT, " + BREAKFAST + " TEXT, " + LUNCH + " TEXT, " + SNACKS + " TEXT, " + DINNER + " TEXT) ";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void addData(String date, String breakfast, String lunch, String snacks, String dinner) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DATE, date);
        values.put(BREAKFAST, breakfast);
        values.put(LUNCH, lunch);
        values.put(SNACKS, snacks);
        values.put(DINNER, dinner);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<Model> readCourses() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Model> list = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                list.add(new Model(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return list;
    }

    public void updateData(String originalDate, String date, String breakfast, String lunch, String snacks, String dinner) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(DATE, date);
        values.put(BREAKFAST, breakfast);
        values.put(LUNCH, lunch);
        values.put(SNACKS, snacks);
        values.put(DINNER, dinner);

        db.update(TABLE_NAME, values, "date=?", new String[]{originalDate});
        db.close();
    }

    public void deleteData(String dates) {
try{
    SQLiteDatabase db = this.getWritableDatabase();

    db.delete(TABLE_NAME, "date=?", new String[]{dates});

    db.close();
}catch (Exception e) {
    Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
}
    }
}




