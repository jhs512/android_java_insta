package com.example.sbs.myapplication.ui;

import androidx.lifecycle.ViewModel;

import com.example.sbs.myapplication.service.ArticleService;
import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeMainViewModel extends ViewModel {
    @Inject
    public HomeMainViewModel(ArticleService articleService) {
        articleService.usr_article_list(1, 1, rb -> {
            Util.log("rb.body.articles : " + rb.body.articles);
        });
    }
}