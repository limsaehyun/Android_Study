package com.example.textwatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.textwatcher.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                binding.tv.setTextColor(Color.YELLOW);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.tv.setTextColor(Color.GREEN);
            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.tv.setTextColor(Color.BLUE);
            }
        });
    }
}