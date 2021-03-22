package com.example.sbs.myapplication.service;

import androidx.annotation.NonNull;

import com.example.sbs.myapplication.App;
import com.example.sbs.myapplication.api.MainApi;
import com.example.sbs.myapplication.api.MainApi__RB;
import com.example.sbs.myapplication.api.MainApi__usr_article_detail__RBB;
import com.example.sbs.myapplication.api.MainApi__usr_article_doAdd__RBB;
import com.example.sbs.myapplication.api.MainApi__usr_article_list__RBB;
import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ArticleService {
    private MainApi mainApi;

    @Inject
    public ArticleService(MainApi mainApi) {
        this.mainApi = mainApi;
    }

    public void usr_article_list(int boardId, int page, @NonNull Consumer<? super MainApi__RB<MainApi__usr_article_list__RBB>> onNext) {
        mainApi.usr_article_list(boardId, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, throwable -> {
                    Util.log("throwable : " + throwable.getMessage());
                });
    }

    public void usr_article_detail(int id, @NonNull Consumer<? super MainApi__RB<MainApi__usr_article_detail__RBB>> onNext) {
        mainApi.usr_article_detail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, throwable -> {
                    Util.log("throwable : " + throwable.getMessage());
                });
    }

    public void usr_article_doAdd(int boardId, String title, String body, @NonNull Consumer<? super MainApi__RB<MainApi__usr_article_doAdd__RBB>> onNext) {
        String authKey = App.getAuthKey();

        mainApi.usr_article_doAdd(authKey, boardId, title, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, throwable -> {
                    Util.log("throwable : " + throwable.getMessage());
                });
    }
}
