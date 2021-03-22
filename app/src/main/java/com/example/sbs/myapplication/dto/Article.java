package com.example.sbs.myapplication.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article implements Parcelable {
    public int id;
    public String regDate;
    public String updateDate;
    public int boardId;
    public int memberId;
    public String title;
    public String body;

    public String extra__writer;
    public String extra__boardName;
    public String extra__thumbImg;
    public Map<String, Object> extra;
    public String writerThumbImgUrl;

    public String getThumbImgUrl() {
        return "http://10.0.2.2:8085/img?failWidth=700&failHeight=400&failText=U.U&url=http://localhost:8021/common/genFile/file/article/" + id + "/common/attachment/1";
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", regDate='" + regDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", boardId=" + boardId +
                ", memberId=" + memberId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", extra__writer='" + extra__writer + '\'' +
                ", extra__boardName='" + extra__boardName + '\'' +
                ", extra__thumbImg='" + extra__thumbImg + '\'' +
                ", extra=" + extra +
                ", writerThumbImgUrl='" + writerThumbImgUrl + '\'' +
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
        dest.writeInt(this.boardId);
        dest.writeInt(this.memberId);
        dest.writeString(this.title);
        dest.writeString(this.body);
        dest.writeString(this.extra__writer);
        dest.writeString(this.extra__boardName);
        dest.writeString(this.extra__thumbImg);
        dest.writeInt(this.extra.size());
        for (Map.Entry<String, Object> entry : this.extra.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeParcelable((Parcelable) entry.getValue(), flags);
        }
        dest.writeString(this.writerThumbImgUrl);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.regDate = source.readString();
        this.updateDate = source.readString();
        this.boardId = source.readInt();
        this.memberId = source.readInt();
        this.title = source.readString();
        this.body = source.readString();
        this.extra__writer = source.readString();
        this.extra__boardName = source.readString();
        this.extra__thumbImg = source.readString();
        int extraSize = source.readInt();
        this.extra = new HashMap<String, Object>(extraSize);
        for (int i = 0; i < extraSize; i++) {
            String key = source.readString();
            Object value = source.readParcelable(Object.class.getClassLoader());
            this.extra.put(key, value);
        }
        this.writerThumbImgUrl = source.readString();
    }

    public Article() {
    }

    protected Article(Parcel in) {
        this.id = in.readInt();
        this.regDate = in.readString();
        this.updateDate = in.readString();
        this.boardId = in.readInt();
        this.memberId = in.readInt();
        this.title = in.readString();
        this.body = in.readString();
        this.extra__writer = in.readString();
        this.extra__boardName = in.readString();
        this.extra__thumbImg = in.readString();
        int extraSize = in.readInt();
        this.extra = new HashMap<String, Object>(extraSize);
        for (int i = 0; i < extraSize; i++) {
            String key = in.readString();
            Object value = in.readParcelable(Object.class.getClassLoader());
            this.extra.put(key, value);
        }
        this.writerThumbImgUrl = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel source) {
            return new Article(source);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
