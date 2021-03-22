package com.example.sbs.myapplication.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Member implements Parcelable {
    public int id;
    public String regDate;
    public String updateDate;
    public String loginId;
    public int authLevel;
    public String name;
    public String nickname;
    public String cellphoneNo;
    public String email;
    public String extra__thumbImg;
    public String authLevelName;
    public String authLevelNameColor;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", regDate='" + regDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", loginId='" + loginId + '\'' +
                ", authLevel=" + authLevel +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", cellphoneNo='" + cellphoneNo + '\'' +
                ", email='" + email + '\'' +
                ", extra__thumbImg='" + extra__thumbImg + '\'' +
                ", authLevelName='" + authLevelName + '\'' +
                ", authLevelNameColor='" + authLevelNameColor + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.regDate);
        dest.writeString(this.updateDate);
        dest.writeString(this.loginId);
        dest.writeInt(this.authLevel);
        dest.writeString(this.name);
        dest.writeString(this.nickname);
        dest.writeString(this.cellphoneNo);
        dest.writeString(this.email);
        dest.writeString(this.extra__thumbImg);
        dest.writeString(this.authLevelName);
        dest.writeString(this.authLevelNameColor);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.regDate = source.readString();
        this.updateDate = source.readString();
        this.loginId = source.readString();
        this.authLevel = source.readInt();
        this.name = source.readString();
        this.nickname = source.readString();
        this.cellphoneNo = source.readString();
        this.email = source.readString();
        this.extra__thumbImg = source.readString();
        this.authLevelName = source.readString();
        this.authLevelNameColor = source.readString();
    }

    public Member() {
    }

    protected Member(Parcel in) {
        this.id = in.readInt();
        this.regDate = in.readString();
        this.updateDate = in.readString();
        this.loginId = in.readString();
        this.authLevel = in.readInt();
        this.name = in.readString();
        this.nickname = in.readString();
        this.cellphoneNo = in.readString();
        this.email = in.readString();
        this.extra__thumbImg = in.readString();
        this.authLevelName = in.readString();
        this.authLevelNameColor = in.readString();
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel source) {
            return new Member(source);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };
}
