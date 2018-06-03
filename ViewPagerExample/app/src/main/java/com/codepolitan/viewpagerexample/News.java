package com.codepolitan.viewpagerexample;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by rudihartono on 5/19/18.
 */

public class News implements Parcelable {

    String id;
    String title;
    String author_name;
    String thumbnail;
    String author_image;
    String slug;
    String description;
    String date;
    String link;
    String total_views;

    public News(){

    }

    public News(String id, String title, String author_name, String thumbnail, String link, String description){

        this.id = id;
        this.title = title;
        this.author_name = author_name;
        this.thumbnail = thumbnail;
        this.link = link;
        this.description = description;
    }

    // Parcelling part
    public News(Parcel source) {
        this.id = source.readString();
        this.title = source.readString();
        this.thumbnail = source.readString();
        this.author_name = source.readString();
        this.description = source.readString();
        this.date = source.readString();
        this.link = source.readString();
    }
    //method method untuk parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.thumbnail);
        dest.writeString(this.author_name);
        dest.writeString(this.description);
        dest.writeString(this.date);
        dest.writeString(this.link);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }

    };
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
