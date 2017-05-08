package com.example.tristan.tristanhoobroeckx_pset4;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper helper;
    Context context;
    ArrayList<String> todoList;
    ArrayList<Integer> imageList;
    ITEM item;
    EditText editText;
    ListView listView;
    ArrayList<ITEM> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        helper = new DataBaseHelper(this);

        itemList = helper.Read();
        for (ITEM items : itemList){
            Log.d("check!", items.getItem());
            Log.d("check!", items.getDone());
            Log.d("check!", items.getID().toString());
        }
        makeImageList();

        editText = (EditText) findViewById(R.id.edittxt);
        listView = (ListView) findViewById(R.id.list);
        ArrayList<String> todoList = new ArrayList<>();
        ArrayList<Integer> imageList = new ArrayList<>();

        if (itemList != null){
            CustomList adapter = new CustomList(MainActivity.this, todoList, imageList);
            assert itemList != null;
            assert imageList != null;
            Log.d("check!", "voor adapter");
            listView.setAdapter(adapter);

        }





//        listView.setOnItemClickListener(new myListener());



    }

    public void addItem(View view){
        String content = editText.getText().toString();
        item = new ITEM("TODO: "+content, "false");
        helper.Create(item);
        editText.getText().clear();
    }

    public void makeImageList(){
        for (ITEM items : itemList){
            if (items.getDone() == "false"){
                imageList.add(R.drawable.circle);
            }
            if (items.getDone() == "true"){
                imageList.add(R.drawable.check);
            }
        }
    }



//    private class myListener implements android.widget.AdapterView.OnItemClickListener {
//        String selectedFromList;
//
//        public myListener(AdapterView<?> parent, View view, int position, long id) {
//            helper.Read();
//            item =  new ITEM()
//            selectedFromList = (String) listView.getItemAtPosition(position);
//
//        }
//    }
}
