package com.example.sbs.myapplication.router;

import android.content.Intent;
import android.os.Bundle;

import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;

import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.util.Util;

public class Router {
    public static void goToArticleDetail(int id) {
        NavController navController = Util.getNavController();

        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        navController.navigate(R.id.nav_article_detail, bundle);
    }

    public static void goToArticleWrite() {
        ActivityNavigator.Extras extras = new ActivityNavigator.Extras.Builder()
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .build();

        Util.getNavController().navigate(R.id.nav_article_write, null, null, extras);
    }

    public static void goToHomeMain() {
        Util.getNavController().navigate(R.id.nav_home_main);
    }
}
