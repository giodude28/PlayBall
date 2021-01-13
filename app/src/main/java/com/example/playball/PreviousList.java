package com.example.playball;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.playball.API.ApiClient;
import com.example.playball.models.PreviousEvent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.playball.API.ApiClient.retrofitBuilder3;

public class PreviousList extends Fragment {
    private List<PreviousEvent.PreviousEvents> awit = new ArrayList<>();
//    private List<Event> mama;
//    private List<Event.Events> listEvent;
    private TextView event,date,time,league,season,home,away,venue,status,homescore,awayscore;
    private CircleImageView pimg;
    private PreviousAdapter adapter;
    private RecyclerView.LayoutManager rvLayout;
    private RecyclerView rView;
    private BottomNavigationView bottomNavigationView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.activity_previous_list, container, false);
        rView = view.findViewById(R.id.recycleviews2);
        rvLayout = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(rvLayout);
        loadMatch();
        return view;
    }

    public void loadMatch()
    {

        ApiClient rfit = new ApiClient();
        rfit.retrofitBuilder3();

        Call<PreviousEvent> call = retrofitBuilder3().getPrevious();
        call.enqueue(new Callback<PreviousEvent>(){
            @Override
            public void onResponse(Call<PreviousEvent> call, Response<PreviousEvent> response) {
                PreviousEvent dataList = response.body();

                List<PreviousEvent.PreviousEvents> soccerlist = dataList.getPrevious();
                awit.addAll(soccerlist);
                //List<List<Matches>> matchlist = dataList;
                // teamsss.addAll(soccerlist);
                // teamsss.addAll(soccerlist);
                //    teamsss.addAll(dataList.getTeams());
                //String city, String name, String conference, String division, String fullName, String wikipediaLogoUrl, String wikipediaWordMarkUrl, StadiumDetails stadiumDetails
                adapter = new PreviousAdapter(getActivity(), soccerlist);
                rView.setAdapter(adapter);
//                swipeRefreshLayout.setRefreshing(false);
                // teamsss.addAll(dataList.getTeams());
                // teamsss = rvAdapter.

            }

            @Override
            public void onFailure(Call<PreviousEvent> call, Throwable t) {

            }
        });
    }
}