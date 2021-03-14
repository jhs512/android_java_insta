package com.example.sbs.myapplication.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainApi__RB<T> {
    public String resultCode;
    public String msg;
    public boolean fail;
    public boolean success;
    public T body;
}
