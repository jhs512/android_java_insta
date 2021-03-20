package com.example.sbs.myapplication.di;

import com.example.sbs.myapplication.api.MainApi;
import com.example.sbs.myapplication.service.ArticleService;
import com.example.sbs.myapplication.service.MemberService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;


@Module
@InstallIn(SingletonComponent.class)
public class SingletonModule {

    @Provides
    @Singleton
    public static MemberService provideMemberService() {
        return new MemberService();
    }

    @Provides
    @Singleton
    public static ArticleService provideArticleService(MainApi mainApi) {
        return new ArticleService(mainApi);
    }

    @Provides
    @Singleton
    public static MainApi provideMainApi(Retrofit.Builder retrofitBuilder) {
        Retrofit retrofit = retrofitBuilder
                .baseUrl(MainApi.baseUrl)
                .build();

        return retrofit.create(MainApi.class);
    }

    @Provides
    public static Retrofit.Builder provideRetrofitBuilder() {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create()) // Jackson 사용
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()); // RX Java 사용

        return retrofitBuilder;
    }
}
