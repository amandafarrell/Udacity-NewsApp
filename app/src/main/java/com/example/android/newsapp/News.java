package com.example.android.newsapp;

public class News {

    private String title;
    private String section;
    private String url;
    private String author;
    private String date;

    //Constructors
    public News(String title) {
        this.title = title;
    }

    public News(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public News(String title, String section, String url, String date) {
        this.title = title;
        this.section = section;
        this.url = url;
        this.date = date;
    }

    public News(String title, String section, String url, String author, String date) {
        this.title = title;
        this.section = section;
        this.url = url;
        this.author = author;
        this.date = date;
    }

    //Getter methods
    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }
}
