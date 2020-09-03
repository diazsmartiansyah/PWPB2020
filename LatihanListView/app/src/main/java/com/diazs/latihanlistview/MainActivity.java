package com.diazs.latihanlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.ListView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,list);
        listView.setAdapter(arrayAdapter);

        list.add("RPL");
        list.add("TKJ");
        list.add("MM");
        list.add("AVI");
        list.add("TOI");
    }
}