package com.example.tristan.tristanhoobroeckx_pset4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper helper;
    Context context;
    ArrayList<String> todoList;
    ITEM item;
    EditText editText;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edittxt);
        listView = (ListView) findViewById(R.id.list);

        context = this;
        helper = new DataBaseHelper(this);
    }

    public void addItem(View view){
        String content = editText.getText().toString();
        item = new ITEM("TODO: "+content, "false");
        helper.Create(item);
        editText.getText().clear();
    }




}
