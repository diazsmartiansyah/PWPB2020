package com.diazs.jumlahbilangan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText bil1;
    EditText bil2;
    EditText hasil;
    Button jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initEvent();
    }


    private void initUI() {
        bil1 = findViewById(R.id.bil_1);
        bil2 = findViewById(R.id.bil_2);
        hasil = findViewById(R.id.et_hasil);
        jumlah = findViewById(R.id.btn_jumlah);
    }

    private void initEvent() {
        jumlah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungJumlah();
            }
        });
    }

    private void hitungJumlah() {
        try {
            int angka1 = Integer.parseInt(bil1.getText().toString());
            int angka2 = Integer.parseInt(bil2.getText().toString());
            int total = angka1 + angka2;
            hasil.setText(String.valueOf(total));
        }catch (Exception e){
            Toast.makeText(this,"Masukan angka",Toast.LENGTH_SHORT).show();
        }

    }

}