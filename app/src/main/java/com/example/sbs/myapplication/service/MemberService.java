package com.example.sbs.myapplication.service;

import androidx.annotation.NonNull;

import com.example.sbs.myapplication.api.MainApi;
import com.example.sbs.myapplication.api.MainApi__RB;
import com.example.sbs.myapplication.api.MainApi__usr_member_authKey__RBB;
import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MemberService {
    private MainApi mainApi;

    @Inject
    public MemberService(MainApi mainApi) {
        this.mainApi = mainApi;
    }

    public void usr_member_authKey(String loginId, String loginPw, @NonNull Consumer<? super MainApi__RB<MainApi__usr_member_authKey__RBB>> onNext) {
        mainApi.usr_member_authKey(loginId, loginPw)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, throwable -> {
                    Util.log("throwable : " + throwable.getMessage());
                });
    }
}
