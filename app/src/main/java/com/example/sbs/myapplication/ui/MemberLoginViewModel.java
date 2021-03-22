package com.example.sbs.myapplication.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sbs.myapplication.App;
import com.example.sbs.myapplication.router.Router;
import com.example.sbs.myapplication.service.MemberService;
import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MemberLoginViewModel extends ViewModel {
    public MutableLiveData<String> lvLoginId = new MutableLiveData<>("");
    public MutableLiveData<String> lvLoginPw = new MutableLiveData<>("");
    private MemberService memberService;

    @Inject
    public MemberLoginViewModel(MemberService memberService) {
        this.memberService = memberService;
    }

    public void btnDoJoinClicked() {
        String loginId = lvLoginId.getValue().trim();

        if (loginId.length() == 0) {
            Util.toast("로그인아이디를 입력해주세요.");
            return;
        }

        String loginPw = lvLoginPw.getValue().trim();

        if (loginPw.length() == 0) {
            Util.toast("로그인비번을 입력해주세요.");
            return;
        }

        memberService.usr_member_authKey(loginId, loginPw, rb -> {
            Util.toast(rb.msg);

            if ( rb.success ) {
                App.setLogin(rb.body.authKey, rb.body.member);
                Router.goToHomeMain();
            }
        });
    }
}