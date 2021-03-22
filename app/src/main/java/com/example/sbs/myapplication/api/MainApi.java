package com.example.sbs.myapplication.api;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MainApi {
    String baseUrl = "http://10.0.2.2:8021/";

    @GET("usr/article/list")
    Observable<MainApi__RB<MainApi__usr_article_list__RBB>> usr_article_list(@Query("boardId") int boardId, @Query("page") int page);

    @GET("usr/article/detail")
    Observable<MainApi__RB<MainApi__usr_article_detail__RBB>> usr_article_detail(@Query("id") int id);

    @FormUrlEncoded
    @POST("usr/article/doAdd")
    Observable<MainApi__RB<MainApi__usr_article_doAdd__RBB>> usr_article_doAdd(@Field("authKey") String authKey, @Field("boardId") int boardId, @Field("title") String title, @Field("body") String body);

    @FormUrlEncoded
    @POST("usr/member/authKey")
    Observable<MainApi__RB<MainApi__usr_member_authKey__RBB>> usr_member_authKey(@Field("loginId") String loginId, @Field("loginPw") String loginPw);
}
