package com.example.android.newsapp;

public class News {

    private String title;
    private String url;

    //Constructors
    public News(String title){
        this.title = title;
    }

    public News(String title, String url){
        this.title = title;
        this.url = url;
    }

    //Getter methods
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
