package com.saehyun.postexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.saehyun.postexample.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PostAPI postAPI;

    private int postId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        postAPI = ApiProvider.getRetrofit().create(PostAPI.class);

        binding.btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    fetchPost();
                } catch(Throwable e) {
                    Toast.makeText(getApplicationContext(), "error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fetchPost() {
        postId = Integer.parseInt(binding.etPostId.getText().toString());

        postAPI.fetchPost(postId).enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if(response.isSuccessful()) {
                    binding.tvResult.setText(response.body().getContent());
                    binding.tvTitle.setText(response.body().getTitle());
                } else if(response.code() == 404) {
                    Toast.makeText(getApplicationContext(), "user not found!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}