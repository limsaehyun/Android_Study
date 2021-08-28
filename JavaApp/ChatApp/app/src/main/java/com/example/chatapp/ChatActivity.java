package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;

public class ChatActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    EditText et_text;
    Button btn_send;
    Button btn_finish;

    String stEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        stEmail = getIntent().getStringExtra("email");

        btn_finish = (Button) findViewById(R.id.btn_finish);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        et_text = (EditText) findViewById(R.id.et_text);

        recyclerView = (RecyclerView) findViewById(R.id.rv);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        String[] myDataset = {"test1", "test2", "test3", "test4"};
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);

        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stText = et_text.getText().toString();
                Toast.makeText(ChatActivity.this, "MSG : "+stText, Toast.LENGTH_SHORT).show();;
                FirebaseDatabase database = FirebaseDatabase.getInstance();

                Calendar c = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String datatime = dateFormat.format(c.getTime());

                DatabaseReference myRef = database.getReference("message").child(datatime);

                Hashtable<String, String> chatInfo = new Hashtable<String, String>();
                chatInfo.put("email", stEmail);
                chatInfo.put("text", stText);

                myRef.setValue(chatInfo);
            }
        });
    }
}