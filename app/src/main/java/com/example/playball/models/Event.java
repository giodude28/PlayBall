package com.example.playball.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event {

    @SerializedName("events")
    private List<Event.Events> Eventss = null;

public static class Events{
    @SerializedName("strEvent")
    @Expose
    private String strEvent;

    @SerializedName("strFilename")
    @Expose
    private String strFilename;

    @SerializedName("strLeague")
    @Expose
    private String strLeague;
    @SerializedName("strSeason")
    @Expose
    private String strSeason;

    @SerializedName("strHomeTeam")
    @Expose
    private String strHomeTeam;

    @SerializedName("strAwayTeam")
    @Expose
    private String strAwayTeam;

    @SerializedName("dateEvent")
    @Expose
    private String dateEvent;

    @SerializedName("strTime")
    @Expose
    private String strTime;

    @SerializedName("strVenue")
    @Expose
    private String strVenue;

    @SerializedName("strThumb")
    @Expose
    private String strThumb;

    @SerializedName("strStatus")
    @Expose
    private String strStatus;


    public Events(String strEvent, String strFilename,  String strLeague,String strTime,String dateEvent,String strVenue, String strSeason, String strHomeTeam, String strAwayTeam, String strThumb, String strStatus) {
        super();

        this.strEvent = strEvent;
        this.strFilename = strFilename;
        this.strLeague = strLeague;
        this.strSeason = strSeason;
        this.strHomeTeam = strHomeTeam;
        this.strAwayTeam = strAwayTeam;
        this.dateEvent = dateEvent;
        this.strTime = strTime;
        this.strVenue = strVenue;
        this.strThumb = strThumb;
        this.strStatus = strStatus;
    }



    public String getStrEvent() {
        return strEvent;
    }

    public void setStrEvent(String strEvent) {
        this.strEvent = strEvent;
    }

    public String getStrFilename() {
        return strFilename;
    }

    public void setStrFilename(String strFilename) {
        this.strFilename = strFilename;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrSeason() {
        return strSeason;
    }

    public void setStrSeason(String strSeason) {
        this.strSeason = strSeason;
    }

    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public void setStrHomeTeam(String strHomeTeam) {
        this.strHomeTeam = strHomeTeam;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public void setStrAwayTeam(String strAwayTeam) {
        this.strAwayTeam = strAwayTeam;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public String getStrVenue() {
        return strVenue;
    }

    public void setStrVenue(String strVenue) {
        this.strVenue = strVenue;
    }

    public String getStrThumb() {
        return strThumb;
    }

    public void setStrThumb(String strThumb) {
        this.strThumb = strThumb;
    }

    public String getStrStatus() {
        return strStatus;
    }

    public void setStrStatus(String strStatus) {
        this.strStatus = strStatus;
    }

}
    public List<Event.Events> getEventss() {
        return Eventss;
    }

}

