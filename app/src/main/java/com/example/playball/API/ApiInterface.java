package com.example.playball.API;

import com.example.playball.models.Event;

import com.example.playball.models.Matches;
import com.example.playball.models.PreviousEvent;
import com.example.playball.models.Teams;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    public static String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";

    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<Teams> getTeams();

    public static String BASE_URL1 = "https://www.scorebat.com/video-api/";

    @GET("v1")
    Call<List<Matches>> getMatches();

    public static String BASE_URL2 = "https://www.thesportsdb.com/api/v1/json/1/";

    @GET("eventsnextleague.php?id=4328")
    Call<Event> getEventss();

    public static String BASE_URL3 = "https://www.thesportsdb.com/api/v1/json/1/";

    @GET("eventspastleague.php?id=4328")
    Call<PreviousEvent> getPrevious();
}
