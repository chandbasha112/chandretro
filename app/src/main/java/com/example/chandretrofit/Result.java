package com.example.chandretrofit;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("name")
    private String superName;


    public Result(String name) {
        this.superName = name;
    }

    public String getName() {
        return superName;
    }
}
