package com.diazs.market;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.diazs.market.Model.DatabaseHelper;
import com.diazs.market.Model.Item;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

public class AddUpdateItemActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText inpName, inpDescription;
    DatabaseHelper db;
    Random ran;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_activity);
        btnSubmit = findViewById(R.id.btn_submit);
        inpName = findViewById(R.id.inp_nama);
        inpDescription = findViewById(R.id.inp_deskripsi);
        db = new DatabaseHelper(this);
        ran = new Random();

        if(getIntent().getIntExtra("id", 0) != 0){
            inpName.setText(getIntent().getStringExtra("name"));
            inpDescription.setText(getIntent().getStringExtra("description"));
            getSupportActionBar().setTitle("Form Edit");
        }else{
            getSupportActionBar().setTitle("Form Add");
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                if(getIntent().getIntExtra("id", 0) != 0){
                    Item item = new Item();
                    item.setId(getIntent().getIntExtra("id", 0));
                    item.setName(inpName.getText().toString());
                    item.setDescription(inpDescription.getText().toString());
                    item.setDate(getIntent().getStringExtra("date"));
                    db.update(item);
                    startActivity(new Intent(AddUpdateItemActivity.this, MainActivity.class));
                }else{
                    Item item = new Item();
                    int ran1 = ran.nextInt(99) + 1;
                    int ran2 = ran.nextInt(999) + 1;
                    String concated = String.valueOf(ran1) + String.valueOf(ran2);
                    item.setId(Integer.valueOf(concated));
                    item.setName(inpName.getText().toString());
                    item.setDescription(inpDescription.getText().toString());
                    long millis = System.currentTimeMillis();
                    item.setDate(String.valueOf(new Date(millis)));
                    db.insert(item);
                    startActivity(new Intent(AddUpdateItemActivity.this, MainActivity.class));
                }
            }
        });


    }
}
