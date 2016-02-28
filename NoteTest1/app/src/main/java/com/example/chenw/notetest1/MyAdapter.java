package com.example.chenw.notetest1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by chenw on 2016/1/4.
 */
public class MyAdapter extends ArrayAdapter<Note> {

    private int resourceId;

    public MyAdapter(Context context, int textViewResourceId, List<Note> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Note note = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView textViewTitleView = (TextView) view.findViewById(R.id.textView_titleView);
        TextView textViewTitle = (TextView) view.findViewById(R.id.textView_title);
        TextView textViewContent = (TextView) view.findViewById(R.id.textView_content);
        TextView textViewDate = (TextView) view.findViewById(R.id.textView_date);
        textViewTitleView.setText(note.getTitle().subSequence(0, 1));
        textViewTitle.setText(note.getTitle());
        textViewContent.setText(note.getContent());
        textViewDate.setText(note.getDate());

        //TODO setColor
        return view;
    }
}
