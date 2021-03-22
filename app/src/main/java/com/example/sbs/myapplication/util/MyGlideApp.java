package com.example.sbs.myapplication.util;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.example.sbs.myapplication.BuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

@GlideModule
public final class MyGlideApp extends AppGlideModule {
    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(new StethoInterceptor());
        }

        OkHttpClient okHttpClient = builder.build();

        registry.replace(GlideUrl.class, InputStream.class,
                new OkHttpUrlLoader.Factory(okHttpClient));
    }

}