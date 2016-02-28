package com.example.chenw.notetest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewActivity.this,UpdateNoteActivity.class);
                intent.putExtra("id",getIntent().getIntExtra("id",-1));
                intent.putExtra("title",getIntent().getStringExtra("title"));
                intent.putExtra("content",getIntent().getStringExtra("content"));
                startActivity(intent);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    private void initData() {
        textViewTitle = (TextView) findViewById(R.id.textView_title_f);
        textViewContent = (TextView) findViewById(R.id.textView_content_f);

        textViewTitle.setText(getIntent().getStringExtra("title"));
        textViewContent.setText(getIntent().getStringExtra("content"));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ViewActivity.this.finish();
    }
}
