package com.example.sbs.myapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sbs.myapplication.databinding.FragmentArticleDetailBinding;
import com.example.sbs.myapplication.util.Util;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ArticleDetailFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        int id = ArticleDetailFragmentArgs.fromBundle(getArguments()).getId();

        ArticleDetailViewModel vm =
                new ViewModelProvider(this).get(ArticleDetailViewModel.class);

        vm.setId(id);

        FragmentArticleDetailBinding binding = FragmentArticleDetailBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);

        binding.setVm(vm);

        return binding.getRoot();
    }
}