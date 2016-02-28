package com.example.chenw.notetest1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateNoteActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextContent;

    private DBManager dbManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dbManager = new DBManager(this);
        initData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                update();
                Toast.makeText(UpdateNoteActivity.this, "update success", Toast.LENGTH_SHORT).show();
                UpdateNoteActivity.this.finish();
            }
        });
    }

    public void update() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日     HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String title = editTextTitle.getText().toString();
        String content = editTextContent.getText().toString();
        int id = getIntent().getIntExtra("id",-1);
        String date = format.format(curDate);

        Log.d("TAG", title);
        Log.d("TAG",content);
        Log.d("TAG", date);

        Note note = new Note(title,content,date);
        if(id>-1)
        {
            note.setId(id);
            dbManager.update(note);
        }
        else {
            System.out.println(id);
        }


    }

    private void initData() {

        editTextTitle = (EditText) findViewById(R.id.editText_Title);
        editTextContent = (EditText) findViewById(R.id.editText_Content);
        editTextTitle.setText(getIntent().getStringExtra("title"));
        editTextContent.setText(getIntent().getStringExtra("content"));
    }

}
