package com.example.sbs.myapplication.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sbs.myapplication.router.Router;
import com.example.sbs.myapplication.service.ArticleService;
import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ArticleWriteViewModel extends ViewModel {
    public MutableLiveData<String> lvTitle = new MutableLiveData<>("");
    public MutableLiveData<String> lvBody = new MutableLiveData<>("");
    private ArticleService articleService;

    @Inject
    public ArticleWriteViewModel(ArticleService articleService) {
        this.articleService = articleService;
    }

    public void btnDoWriteClicked() {
        String title = lvTitle.getValue().trim();

        if (title.length() == 0) {
            Util.toast("제목을 입력해주세요.");
            return;
        }

        String body = lvBody.getValue().trim();

        if (body.length() == 0) {
            Util.toast("내용을 입력해주세요.");
            return;
        }

        articleService.usr_article_doAdd(1, title, body, rb -> {
            Util.toast(rb.body.id + "번 글이 작성되었습니다.");
            Router.goToHomeMain();
        });
    }
}