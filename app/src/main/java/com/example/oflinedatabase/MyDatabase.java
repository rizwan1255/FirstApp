package com.example.oflinedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    Context context;
    public static final String TABLE_NAME = "RecordUsers";
    public static final String DATABASE_NAME = "SqLiteDatabase";
    public static final int VERSION = 1;
    public static final String USERNAME = "UserName";
    public static final String PASSWORD = "Password";
    public static final String ID = "Id";

    public static final String query = " CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USERNAME + " TEXT," + PASSWORD + " TEXT " + ")";

    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveData(MyDatabase db, String nam, String pass) {

        SQLiteDatabase dob = db.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USERNAME, nam);
        cv.put(PASSWORD, pass);

        double myvalue = dob.insert(TABLE_NAME, null, cv);

        if (myvalue < 0) {
//            Toast.makeText(context.getApplicationContext(), "not uploaded", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(context.getApplicationContext(), "SUccess", Toast.LENGTH_SHORT).show();
        }
    }
}
