package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private FirebaseAuth mAuth;

    EditText et_email;
    EditText et_pw;

    Button btn_login;
    Button btn_register;

    String stEmail;
    String stPassword;

    ProgressBar progressBar;

    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();

        mAuth = FirebaseAuth.getInstance();

        et_email = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stEmail = et_email.getText().toString();
                stPassword = et_pw.getText().toString();

                if(stEmail.isEmpty()) {
                    Toast.makeText(MainActivity.this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(stPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "비밀번호을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(stEmail, stPassword)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
//                                    updateUI(user);

                                    String stUserEmail = user.getEmail();
                                    String stUserName = user.getDisplayName();

                                    SharedPreferences sharedPref = getSharedPreferences("shared", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPref.edit();
                                    editor.putString("email", stUserEmail);
                                    editor.commit();

                                    Intent intent = new Intent(MainActivity.this, TabActivity.class);
                                    intent.putExtra("email", stEmail);
                                    startActivity(intent);
                                } else {

                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
                                }

                            }
                        });
            }
        });

        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stEmail = et_email.getText().toString();
                stPassword = et_pw.getText().toString();

                progressBar.setVisibility(View.VISIBLE);

                if(stEmail.isEmpty()) {
                    Toast.makeText(MainActivity.this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(stPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "비밀번호을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(stEmail, stPassword)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressBar.setVisibility(View.GONE);
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
//                                    updateUI(user);

                                    DatabaseReference myRef = database.getReference("users").child(user.getUid()); // 유니크 아이디

                                    Hashtable<String, String> chatInfo = new Hashtable<String, String>();
                                    chatInfo.put("email", user.getEmail());
                                    myRef.setValue(chatInfo);

                                    Toast.makeText(MainActivity.this, "RegisterSUccess", Toast.LENGTH_SHORT).show();
                                } else {
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
                                }
                            }
                        });
            }
        });

    }

    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);

    }
}