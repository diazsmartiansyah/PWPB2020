package com.diazs.latihanintentparcelablepwpb2020;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MoveWithDataActivity extends AppCompatActivity {

    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_AGE = "extra_age";
    private TextView tvDataReceived;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        getSupportActionBar().setTitle("Move With Data Activity");

        tvDataReceived = (TextView) findViewById(R.id.tv_data_received);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE,0);
        String text = "Name : " + name + " Age : " + age;
        tvDataReceived.setText(text);
    }
}
