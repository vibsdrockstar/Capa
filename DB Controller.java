package com.example.parker;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;

import java.util.Date;

public class DB_Controller extends SQLiteOpenHelper
{
    public DB_Controller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "VEHICLE.db", factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USERNAME( ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,  EMAIL TEXT, PHONE INTEGER,SFT VARCHAR,DOB DATE,VEHICLETYPE INTEGER);" );

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERNAME");
        onCreate(db);

    }
    public void  insert_patient(String name, String email, Integer phone, Character Student, Integer age,Integer Vehiclenumber) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("EMAIL", email);
        contentValues.put("PHONE", phone);
        contentValues.put("STUDENT", Student);
        contentValues.put("AGE", age);
        contentValues.put("Vehicle Number", Vehiclenumber);

        this.getWritableDatabase().insertOrThrow("USERNAME", "", contentValues);
    }

    }


