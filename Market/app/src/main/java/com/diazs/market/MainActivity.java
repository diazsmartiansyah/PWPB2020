package com.diazs.market;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.diazs.market.Adapter.RecyclerviewAdapter;
import com.diazs.market.Model.DatabaseHelper;
import com.diazs.market.Model.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerviewAdapter.OnUserClickListener {
    FloatingActionButton fb;
    List<Item> listItems;
    RecyclerView recyclerView;
    DatabaseHelper db;
    ActionBar actionBar;
    RecyclerviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fb = findViewById(R.id.btn_add);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddUpdateItemActivity.class);
                startActivity(intent);
            }
        });
        actionBar = getSupportActionBar();
        actionBar.setTitle("Market Place");
        db = new DatabaseHelper(this);
        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        setupRecycleView();
    }

    private void setupRecycleView() {
        listItems = db.fetch();
        adapter = new RecyclerviewAdapter(MainActivity.this, listItems, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onUserClick(Item item, String action) {
        switch (action){
            case "Edit":
                Intent intentEdit = new Intent(MainActivity.this, AddUpdateItemActivity.class);
                intentEdit.putExtra("id", item.getId());
                intentEdit.putExtra("name", item.getName());
                intentEdit.putExtra("description", item.getDescription());
                intentEdit.putExtra("date", item.getDate());
                startActivity(intentEdit);
                break;
            case "Delete":
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Yakin Menghapus Data?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.delete(item.getId());
                        dialogInterface.dismiss();
                        setupRecycleView();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
                break;
        }
    }
}