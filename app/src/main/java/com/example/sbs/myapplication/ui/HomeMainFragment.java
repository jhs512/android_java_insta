package com.example.sbs.myapplication.ui;

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

import com.example.sbs.myapplication.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeMainFragment extends Fragment {

    private HomeMainViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeMainViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home_main, container, false);

        return root;
    }
}