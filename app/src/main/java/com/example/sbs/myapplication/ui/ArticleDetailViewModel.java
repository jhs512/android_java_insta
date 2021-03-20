package com.example.sbs.myapplication.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sbs.myapplication.dto.Article;
import com.example.sbs.myapplication.service.ArticleService;
import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ArticleDetailViewModel extends ViewModel {
    @Inject
    public ArticleDetailViewModel(ArticleService articleService) {
        
    }
}