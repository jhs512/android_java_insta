package com.example.sbs.myapplication.ui;

import android.os.Bundle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;

import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.dto.Article;
import com.example.sbs.myapplication.service.ArticleService;
import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeMainViewModel extends ViewModel {
    public RecyclerViewAdapterArticle recyclerViewAdapterArticle;
    public MutableLiveData<Article> lvFirstArticle = new MutableLiveData<>();

    @Inject
    public HomeMainViewModel(ArticleService articleService) {
        recyclerViewAdapterArticle = new RecyclerViewAdapterArticle();
        recyclerViewAdapterArticle.setOnClickItem((v) -> {
            int articleIndex = (int) v.getTag();
            Article article = recyclerViewAdapterArticle.getArticle(articleIndex);

            NavController navController = Util.getNavController();

            Bundle bundle = new Bundle();
            bundle.putInt("id", article.id);
            navController.navigate(R.id.nav_article_detail, bundle);
        });

        articleService.usr_article_list(1, 1, rb -> {
            recyclerViewAdapterArticle.addArticles(rb.body.articles);
        });
    }
}