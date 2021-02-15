package com.example.emergencyapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter  extends BaseAdapter {

    private Activity activity;
    private String [] text;
    private int [] pictures;

    public CustomAdapter(Activity activity, String[] animals, int[] pictures) {
        this.activity = activity;
        this.text = animals;
        this.pictures = pictures;
    }

    @Override
    public int getCount() {
        return pictures.length;
    }

    @Override
    public Object getItem(int position) {
        return pictures[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater inflater = activity .getLayoutInflater();
        v = inflater.inflate(R.layout.app_emergency,parent,false);


        TextView tv = v. findViewById(R.id.tv);
        ImageView iv = v.findViewById(R.id.iv);

        tv.setText(text[position]);
        iv.setImageResource(pictures[position]);

        return v;
    }
}
