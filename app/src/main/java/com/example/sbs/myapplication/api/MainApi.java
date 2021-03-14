package com.example.sbs.myapplication.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {
    String baseUrl = "http://10.0.2.2:8021/";

    @GET("usr/article/list?")
    Observable<MainApi__RB<MainApi__usr_article_list__RBB>> usr_article_list(@Query("boardId") int boardId, @Query("page") int page);
}
