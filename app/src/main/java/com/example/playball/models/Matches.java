package com.example.playball.models;

import android.provider.MediaStore;
import android.provider.MediaStore.Video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Matches {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("embed")
    @Expose
    private String embed;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("date")
    @Expose
    private String date;

//    @SerializedName("videos")
//    @Expose
//    private List<Video> videos = null;

    public Matches(String title, String embed, String url, String thumbnail, String date) {
        this.title = title;
        this.embed = embed;
        this.url = url;
        this.thumbnail = thumbnail;
        this.date = date;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmbed() {
        return embed;
    }

    public void setEmbed(String embed) {
        this.embed = embed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


//    public List<Video> getVideos() {
//        return videos;
//    }
//
//    public void setVideos(List<Video> videos) {
//        this.videos = videos;
//    }
}
