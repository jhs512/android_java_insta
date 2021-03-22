package com.example.sbs.myapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sbs.myapplication.databinding.FragmentMemberLoginBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MemberLoginFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        MemberLoginViewModel vm =
                new ViewModelProvider(this).get(MemberLoginViewModel.class);

        FragmentMemberLoginBinding binding = FragmentMemberLoginBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);

        binding.setVm(vm);

        return binding.getRoot();
    }
}