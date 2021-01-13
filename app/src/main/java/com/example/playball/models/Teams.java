package com.example.playball.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Teams {

    @SerializedName("teams")
    private List<Teams.Teamss> teams = null;

    public static class Teamss {

        @SerializedName("strTeam")
        public String teamname;

        @SerializedName("strTeamBadge")
        public String tbadge;

        @SerializedName("strTeamLogo")
        public String name;

        @SerializedName("strAlternate")
        public String altername;

        @SerializedName("strTeamBanner")
        public String ban;

        @SerializedName("strTeamFanart1")
        public String img;

        @SerializedName("strTeamFanart2")
        public String img2;

        @SerializedName("strTeamFanart3")
        public String img3;

        @SerializedName("strTeamFanart4")
        public String img4;

        @SerializedName("strTeamJersey")
        public String teamjersey;

        @SerializedName("intFormedYear")
        public String formedyear;

        @SerializedName("strSport")
        public String sport;

        @SerializedName("strStadium")
        public String staduim;

        @SerializedName("strStadiumThumb")
        public String stadiumimg;

        @SerializedName("strStadiumDescription")
        public String stadiumdesc;

        @SerializedName("strDescriptionEN")
        public String teamdesc;

        @SerializedName("intStadiumCapacity")
        public String capacity;

        @SerializedName("strStadiumLocation")
        public String location;

        @SerializedName("strWebsite")
        public String website;

        @SerializedName("strFacebook")
        public String fb;

        @SerializedName("strTwitter")
        public String twitter;

        @SerializedName("strInstagram")
        public String insta;

        @SerializedName("strCountry")
        public String Country;

        public Teamss(String teamname,String ban,String img2,String web,String country, String fb,String twit,String insta,String tbadge, String altername, String name, String img, String teamjersey, String formedyear, String sport, String staduim, String stadiumimg, String stadiumdesc, String teamdesc,String location,String capacity) {
            super();
            this.ban = ban;
            this.img2 = img2;
            this.Country = country;
            this.fb = fb;
            this.twitter = twit;
            this.insta = insta;
            this.website = web;
            this.tbadge = tbadge;
            this.name = name;
            this.teamname = teamname;
            this.altername = altername;
            this.img = img;
            this.teamjersey = teamjersey;
            this.formedyear = formedyear;
            this.sport = sport;
            this.staduim = staduim;
            this.stadiumimg = stadiumimg;
            this.stadiumdesc = stadiumdesc;
            this.teamdesc = teamdesc;
            this.capacity = capacity;
            this.location = location;
        }

        public Teamss(String img, String img2, String img3,String img4) {
            this.img = img;
            this.img2 = img2;
            this.img3 = img3;
            this.img4 = img4;
        }

        public String getBan() {
            return ban;
        }

        public void setBan(String ban) {
            this.ban = ban;
        }

        public String getImg3() {
            return img3;
        }

        public void setImg3(String img3) {
            this.img3 = img3;
        }

        public String getImg4() {
            return img4;
        }

        public void setImg4(String img4) {
            this.img4 = img4;
        }

        public String getImg2() {
            return img2;
        }

        public void setImg2(String img2) {
            this.img2 = img2;
        }

        public String getCountry() {
            return Country;
        }

        public void setCountry(String country) {
            Country = country;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public String getFb() {
            return fb;
        }

        public void setFb(String fb) {
            this.fb = fb;
        }

        public String getTwitter() {
            return twitter;
        }

        public void setTwitter(String twitter) {
            this.twitter = twitter;
        }

        public String getInsta() {
            return insta;
        }

        public void setInsta(String insta) {
            this.insta = insta;
        }

        public String getTbadge() {
            return tbadge;
        }

        public void setTbadge(String tbadge) {
            this.tbadge = tbadge;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTeamjersey() {
            return teamjersey;
        }

        public void setTeamjersey(String teamjersey) {
            this.teamjersey = teamjersey;
        }

        public String getFormedyear() {
            return formedyear;
        }

        public void setFormedyear(String formedyear) {
            this.formedyear = formedyear;
        }

        public String getSport() {
            return sport;
        }

        public void setSport(String sport) {
            this.sport = sport;
        }

        public String getStaduim() {
            return staduim;
        }

        public void setStaduim(String staduim) {
            this.staduim = staduim;
        }

        public String getStadiumimg() {
            return stadiumimg;
        }

        public void setStadiumimg(String stadiumimg) {
            this.stadiumimg = stadiumimg;
        }

        public String getStadiumdesc() {
            return stadiumdesc;
        }

        public void setStadiumdesc(String stadiumdesc) {
            this.stadiumdesc = stadiumdesc;
        }

        public String getTeamdesc() {
            return teamdesc;
        }

        public void setTeamdesc(String teamdesc) {
            this.teamdesc = teamdesc;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTeamname() {
            return teamname;
        }

        public void setTeamname(String teamname) {
            this.teamname = teamname;
        }

        public String getAltername() {
            return altername;
        }

        public void setAltername(String altername) {
            this.altername = altername;
        }

        public String getCapacity() {
            return capacity;
        }

        public void setCapacity(String capacity) {
            this.capacity = capacity;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
    public List<Teams.Teamss> getTeams() {
        return teams;
    }


}
