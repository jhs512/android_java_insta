package com.example.sbs.myapplication.di;

import com.example.sbs.myapplication.service.MemberService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;


@Module
@InstallIn(SingletonComponent.class)
public class SingletonModule {

    @Provides
    @Singleton
    public static MemberService provideMemberService() {
        return new MemberService();
    }
}
