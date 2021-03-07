package com.example.sbs.myapplication.binding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.sbs.myapplication.util.Util;


public class BindingAdapters {
    @BindingAdapter({"imgUrl"})
    public static void imgUrl(ImageView view, String imgUrl) {
        Util.loadImageOn(imgUrl, view);
    }
}
