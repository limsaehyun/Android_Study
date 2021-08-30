package com.example.chatapp.ui.dashboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.MyAdapter;
import com.example.chatapp.R;
import com.example.chatapp.User;
import com.example.chatapp.UserAdapter;
import com.example.chatapp.databinding.FragmentUsersBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UsersFragment extends Fragment {

    private static final String TAG = "UsersFragment";

    private DashboardViewModel dashboardViewModel;
    private FragmentUsersBinding binding;

    ArrayList<User> userArrayList;

    FirebaseDatabase database;

    RecyclerView recyclerView;

    UserAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    String stEmail;

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

        return root;
    }
}