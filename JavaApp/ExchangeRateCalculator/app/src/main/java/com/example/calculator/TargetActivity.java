package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TargetActivity extends AppCompatActivity {

    Button tr_krw;
    Button tr_usd;
    Button tr_jpy;
    Button tr_eur;
    Button tr_cny;
    Button tr_gbp;
    Button back;
    public static int nation = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        back = (Button) findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tr_krw = (Button)findViewById(R.id.tr_krw);
        tr_krw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nation = 1;
                Toast.makeText(getApplicationContext(), "change KRW.", Toast.LENGTH_SHORT).show();
            }
        });
        tr_usd = (Button)findViewById(R.id.tr_usd);
        tr_usd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nation = 2;
                Toast.makeText(getApplicationContext(), "change USD.", Toast.LENGTH_SHORT).show();
            }
        });
        tr_jpy = (Button)findViewById(R.id.tr_jpy);
        tr_jpy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nation = 3;
                Toast.makeText(getApplicationContext(), "change JPY.", Toast.LENGTH_SHORT).show();
            }
        });
        tr_eur = (Button)findViewById(R.id.tr_eur);
        tr_eur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nation = 4;
                Toast.makeText(getApplicationContext(), "change EUR.", Toast.LENGTH_SHORT).show();
            }
        });
        tr_cny = (Button)findViewById(R.id.tr_cny);
        tr_cny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nation = 5;
                Toast.makeText(getApplicationContext(), "change CNY.", Toast.LENGTH_SHORT).show();
            }
        });
        tr_gbp = (Button)findViewById(R.id.tr_gbp);
        tr_gbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nation = 6;
                Toast.makeText(getApplicationContext(), "change GBP.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}