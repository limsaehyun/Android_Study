package com.example.layoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// 메인 화면
public class MainActivity extends AppCompatActivity {

    // 뷰가 생성되었을때
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 그릴 xml 뷰 파일을 연결 시켜준다. (설정한다.)
        setContentView(R.layout.activity_main);
    }
}