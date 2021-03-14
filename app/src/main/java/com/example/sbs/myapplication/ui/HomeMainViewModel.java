package com.example.sbs.myapplication.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sbs.myapplication.dto.Article;
import com.example.sbs.myapplication.service.ArticleService;
import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeMainViewModel extends ViewModel {
    public MutableLiveData<Article> lvFirstArticle = new MutableLiveData<>();

    @Inject
    public HomeMainViewModel(ArticleService articleService) {
        articleService.usr_article_list(1, 1, rb -> {
            lvFirstArticle.setValue(rb.body.articles.get(0));
        });
    }
}