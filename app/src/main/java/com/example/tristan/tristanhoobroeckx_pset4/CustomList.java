package com.example.tristan.tristanhoobroeckx_pset4;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by trist on 5/8/2017.
 */

public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> strings;
    private final ArrayList<Integer> imageID;

    public CustomList(Activity context, ArrayList<String> strings, ArrayList<Integer> imageID){
        super(context, R.layout.list_single, strings);
        Log.d("Check!", "ik ben in CustomList");
        this.context = context;
        this.strings = strings;
        this.imageID = imageID;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        Log.d("check!", "boven aan");
        String[] stringarray = strings.toArray(new String[strings.size()]);
        Integer[] imageArray = imageID.toArray(new Integer[imageID.size()]);
        Log.d("check!", "ik ben in getView");
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(stringarray[position]);

        imageView.setImageResource(imageArray[position]);
        return rowView;
    }
}
