package com.example.sbs.myapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sbs.myapplication.databinding.FragmentArticleDetailBinding;
import com.example.sbs.myapplication.databinding.FragmentArticleWriteBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ArticleWriteFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ArticleWriteViewModel vm =
                new ViewModelProvider(this).get(ArticleWriteViewModel.class);

        FragmentArticleWriteBinding binding = FragmentArticleWriteBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);

        binding.setVm(vm);

        return binding.getRoot();
    }
}