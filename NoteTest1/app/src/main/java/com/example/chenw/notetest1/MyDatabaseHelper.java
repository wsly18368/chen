package com.example.chenw.notetest1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chenw on 2016/1/4.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "note.db";
    private static final int VERSION = 1;

    public static final String CREATE_NOTE = "CREATE TABLE note("
            +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"title TEXT,"
            +"content TEXT,"
            +"date TEXT)";

    public static final String ALTER_NOTE = "ALTER TABLE note ADD COLUMN other STRING";

    public MyDatabaseHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NOTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ALTER_NOTE);
    }

}
