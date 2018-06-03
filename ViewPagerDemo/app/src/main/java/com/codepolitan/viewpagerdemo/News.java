package com.codepolitan.viewpagerdemo;

/**
 * Created by rudihartono on 5/19/18.
 */

public class News {

    String id;
    String slug;
    String title;
    String author_name;
    String author_image;
    String description;
    String date;
    String link;
    String thumbnail;
    String total_views;


    //function
    public String getAuthor_name() {
        return author_name;
    }

    //procedure
    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getAuthor_image() {
        return author_image;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getSlug() {
        return slug;
    }

    public String getTitle() {
        return title;
    }

    public String getTotal_views() {
        return total_views;
    }

    public void setAuthor_image(String author_image) {
        this.author_image = author_image;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTotal_views(String total_views) {
        this.total_views = total_views;
    }
}
