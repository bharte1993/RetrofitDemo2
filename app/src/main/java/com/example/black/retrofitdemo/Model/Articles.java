package com.example.black.retrofitdemo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by BLACK on 14/06/2017.
 */

public class Articles {
    @SerializedName("title")
    @Expose
    private String title;

    public String getTitle() {
        return title;
    }
    @SerializedName("description")
    @Expose
    private String description;
    public String getDescription(){
        return description;
    }
    @SerializedName("urlToImage")
    @Expose
    private String url;
    public String getUrl(){
        return url;
    }

}
