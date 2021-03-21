package com.example.sbs.myapplication.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sbs.myapplication.dto.Article;
import com.example.sbs.myapplication.service.ArticleService;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ArticleWriteViewModel extends ViewModel {
    private ArticleService articleService;
    public MutableLiveData<Article> lvArticle = new MutableLiveData<>();

    @Inject
    public ArticleWriteViewModel(ArticleService articleService) {
        this.articleService = articleService;
    }
}