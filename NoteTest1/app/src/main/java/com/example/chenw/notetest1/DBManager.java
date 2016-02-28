package com.example.chenw.notetest1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenw on 2016/1/5.
 */
public class DBManager {

    private MyDatabaseHelper myDatabaseHelper;
    private SQLiteDatabase database;

    public DBManager(Context context) {
        myDatabaseHelper = new MyDatabaseHelper(context);
        database = myDatabaseHelper.getWritableDatabase();
    }

    public void add(Note note) {
        database.beginTransaction();
        try {
            database.execSQL("INSERT INTO note VALUES(null,?,?,?)",new Object[]{note.getTitle(),note.getContent(),note.getDate()});
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    public void update(Note note) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",note.getTitle());
        contentValues.put("content",note.getContent());
        contentValues.put("date",note.getDate());
        database.update("note", contentValues, "id = ?", new String[]{String.valueOf(note.getId())});
    }

    public void delete(Note note) {
        database.delete("note", "id = ?", new String[]{String.valueOf(note.getId())});
    }

    public List<Note> query() {
        ArrayList<Note> notes = new ArrayList<Note>();
        Cursor cursor = queryTheCursor();
        while (cursor.moveToNext()) {
            Note note = new Note();
            note.setId(cursor.getInt(cursor.getColumnIndex("id")));
            note.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            note.setContent(cursor.getString(cursor.getColumnIndex("content")));
            note.setDate(cursor.getString(cursor.getColumnIndex("date")));
            notes.add(note);
        }
        cursor.close();
        return notes;
    }

    public Cursor queryTheCursor() {
        Cursor cursor = database.rawQuery("SELECT * FROM note",null);
        return cursor;
    }

    public void closeDB() {
        database.close();
    }
}
