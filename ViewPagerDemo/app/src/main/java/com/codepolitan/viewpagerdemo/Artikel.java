package com.codepolitan.viewpagerdemo;

/**
 * Created by rudihartono on 5/19/18.
 */

public class Artikel {

    String id;
    String title;
    String author_name;
    String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Artikel(String id, String title, String author_name) {
        this.id = id;
        this.title = title;
        this.author_name = author_name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}
