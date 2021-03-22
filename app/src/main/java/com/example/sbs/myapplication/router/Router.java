package com.example.sbs.myapplication.router;

import android.content.Intent;
import android.os.Bundle;

import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;

import com.example.sbs.myapplication.MobileNavigationDirections;
import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.dto.Article;
import com.example.sbs.myapplication.ui.ArticleDetailFragmentDirections;
import com.example.sbs.myapplication.util.Util;

public class Router {
    public static void goToArticleDetail(int id) {
        NavController navController = Util.getNavController();
        navController.navigate(MobileNavigationDirections.actionGlobalArticleDetailFragment(1, null));
    }

    public static void goToArticleDetail(Article article) {
        NavController navController = Util.getNavController();
        navController.navigate(MobileNavigationDirections.actionGlobalArticleDetailFragment(article.id, article));
    }

    public static void goToArticleWrite() {
        NavController navController = Util.getNavController();
        navController.navigate(MobileNavigationDirections.actionGlobalArticleWriteFragment());
    }

    public static void goToHomeMain() {
        NavController navController = Util.getNavController();
        navController.navigate(MobileNavigationDirections.actionGlobalHomeMainFragment());
    }
}
