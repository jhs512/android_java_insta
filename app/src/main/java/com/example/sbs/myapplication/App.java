package com.example.sbs.myapplication;

import com.example.sbs.myapplication.dto.Member;
import com.example.sbs.myapplication.util.Util;

public class App {
    private static String authKey;
    private static Member loginedMember;

    public static void init() {
        authKey = Util.spGetString("authKey", null);
        loginedMember = Util.spGetObj("loginedMember", Member.class);

        if (authKey != null) {
            setLogin(authKey, loginedMember);
        }
    }

    public static boolean isLogined() {
        return authKey != null;
    }

    public static Member getLoginedMember() {
        return loginedMember;
    }

    public static String getAuthKey() {
        return authKey;
    }

    public static void setLogin(String authKey, Member loginedMember) {
        App.authKey = authKey;
        Util.spPut("authKey", authKey);
        Util.spPut("loginedMember", loginedMember);
        Util.spCommit();
    }

    public static void setLogout() {
        App.authKey = null;
        Util.spRemove("authKey");
        Util.spRemove("loginedMember");
        Util.spCommit();
    }
}
