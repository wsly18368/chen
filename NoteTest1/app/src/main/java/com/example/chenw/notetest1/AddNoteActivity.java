package com.example.chenw.notetest1;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextContent;

    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        dbManager = new DBManager(this);
        setSupportActionBar(toolbar);
        initData();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                add();

                Toast.makeText(AddNoteActivity.this,"save success",Toast.LENGTH_SHORT).show();
                AddNoteActivity.this.finish();
            }
        });
    }

    public void add() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日     HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String title = editTextTitle.getText().toString();
        String content = editTextContent.getText().toString();
        String date = format.format(curDate);

        Log.d("TAG",title);
        Log.d("TAG",content);
        Log.d("TAG",date);

        Note note = new Note(title,content,date);

        dbManager.add(note);
    }

    private void initData() {

        editTextTitle = (EditText) findViewById(R.id.editText_Title);
        editTextContent = (EditText) findViewById(R.id.editText_Content);
        editTextTitle.setText(getIntent().getStringExtra("title"));
        editTextContent.setText(getIntent().getStringExtra("content"));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
