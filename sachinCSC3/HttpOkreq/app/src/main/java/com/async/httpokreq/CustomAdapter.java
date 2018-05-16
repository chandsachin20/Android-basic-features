package com.async.httpokreq;

/**
 * Created by pc77 on 16/5/18.
 */

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by pc-76 on 5/5/18.
 */

public class CustomAdapter extends BaseAdapter {
    ArrayList<String> desc;
    ArrayList<Uri> images;
    LayoutInflater li;
    Context c;
    CustomAdapter(Context c, ArrayList<Uri> images, ArrayList<String> desc){
        this.desc=desc;
        this.images=images;
        this.c=c;
        li= LayoutInflater.from(c);
    }
    @Override
    public int getCount() {
        return desc.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= li.inflate(R.layout.listview_layout,null);
        ImageView iv=view.findViewById(R.id.imageView);
        TextView tv=view.findViewById(R.id.textView);
        Glide.with(c).load(images.get(i)).into(iv);
        tv.setText(desc.get(i));
        return view;
    }
}