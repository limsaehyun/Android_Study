package com.example.chatapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.chatapp.R;
import com.example.chatapp.databinding.FragmentDashboardBinding;
import com.example.chatapp.databinding.FragmentUsersBinding;
import com.google.firebase.database.FirebaseDatabase;

public class UsersFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentUsersBinding binding;

    FirebaseDatabase database;
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        database = FirebaseDatabase.getInstance();

        binding = FragmentUsersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
\\
}