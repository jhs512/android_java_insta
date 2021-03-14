package com.example.sbs.myapplication.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sbs.myapplication.service.ArticleService;
import com.example.sbs.myapplication.service.MemberService;
import com.example.sbs.myapplication.util.Util;

import java.util.Random;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
    public MutableLiveData<String> lvAvartarImgUrl = new MutableLiveData<>();

    @Inject
    public MainViewModel(@NonNull Application application) {
        // 아바타 이미지 세팅
        String avatarImgUrl = "https://i.pravatar.cc/600?img=" + new Random().nextInt(10) + 1;
        lvAvartarImgUrl.setValue(avatarImgUrl);
    }
}