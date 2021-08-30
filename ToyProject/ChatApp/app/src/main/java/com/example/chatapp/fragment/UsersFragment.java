package com.example.chatapp.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.R;
import com.example.chatapp.data.User;
import com.example.chatapp.adapter.UserAdapter;
import com.example.chatapp.databinding.FragmentUsersBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;

public class UsersFragment extends Fragment {

    private static final String TAG = "UsersFragment";

    private FragmentUsersBinding binding;

    ArrayList<User> userArrayList;

    FirebaseDatabase database;

    RecyclerView recyclerView;

    UserAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    String stEmail;

    StorageReference storageRef;
    File localFile;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentUsersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedPreferences sharedPref = getActivity().getSharedPreferences("shared", Context.MODE_PRIVATE);
        stEmail = sharedPref.getString("email", "");
        Log.d(TAG, "email" + stEmail);

        userArrayList = new ArrayList<>();

        recyclerView = root.findViewById(R.id.users_recycler_view);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        String[] myDataset = {"test1", "test2", "test3", "test4"};
        mAdapter = new UserAdapter(userArrayList, stEmail);
        recyclerView.setAdapter(mAdapter);


        database = FirebaseDatabase.getInstance();


        DatabaseReference databaseReference = database.getReference("users");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d(TAG, "onDataChange: " + snapshot.getValue().toString());

                for (DataSnapshot dataSnapshot1 : snapshot.getChildren()) {

                    User user = dataSnapshot1.getValue(User.class);
                    Log.d(TAG, "user: " + user.getEmail());

                    userArrayList.add(user);
                }
                mAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

//        storageRef = FirebaseStorage.getInstance().getReference();
//
//
//        try {
//            localFile = File.createTempFile("images", "jpg");
//
//            StorageReference ProfileImagesRef = storageRef.child("users").child(stEmail).child("profile.jpg");
//
//            ProfileImagesRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                    // 로컬파일 -> 비트맵
//                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
//                    ivUser.setImageBitmap(bitmap);
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception exception) {
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        return root;
    }
}