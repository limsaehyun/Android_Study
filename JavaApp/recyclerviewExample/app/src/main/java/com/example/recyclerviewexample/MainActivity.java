package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MainData> arrayList; // MaindData를 담은 배열 리스트인 arrayList를 선언
    private MainAdapter mainAdapter; // 인스턴스 mainAdapter를 선언
    private RecyclerView recyclerView;
    private LinearLayoutManager  linearLayoutManager; // 레이아웃 관리자 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager); // recyclerView를 통해 리사이클러뷰를 지정


        arrayList = new ArrayList<>();

        mainAdapter = new MainAdapter(arrayList); // 인스턴스 생성
        recyclerView.setAdapter(mainAdapter); // 어댑터를 mainAdapter로 설정

        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() { // 버튼 클릭 이벤트
            @Override
            public void onClick(View v) {
                MainData mainData = new MainData(R.mipmap.ic_launcher, "임세현", "리사이클러뷰");
                arrayList.add(mainData);
                mainAdapter.notifyDataSetChanged(); // 새로고침
            }
        });
    }

}