package com.example.black.retrofitdemo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by BLACK on 14/06/2017.
 */

public class HeadlineResponse {
    @SerializedName("articles")
    @Expose

    private List<Articles> articles=null;
    public List <Articles> getArticles(){
        return articles;
    }



}
