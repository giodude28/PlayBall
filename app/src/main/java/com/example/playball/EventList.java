package com.example.playball;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playball.API.ApiClient;
import com.example.playball.models.Event;
import com.example.playball.models.Matches;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.playball.API.ApiClient.retrofitBuilder2;

public class EventList extends Fragment {
    private List<Event.Events> euts = new ArrayList<>();
//    private List<Event> mama;
//    private List<Event.Events> listEvent;
    private TextView title,date,time;
    private ImageView eimg;
    private EventAdapter adapter;
    private RecyclerView.LayoutManager rvLayout;
    private RecyclerView rView;
    private BottomNavigationView bottomNavigationView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.activity_event_list, container, false);
//        bottomNavigationView = view.findViewById(R.id.bottom_matchnavigation);
//        bottomNavigationView.setSelectedItemId(R.id.coming);
        title = view.findViewById(R.id.eventtitle);
        date = view.findViewById(R.id.eventdate);
        time = view.findViewById(R.id.eventtime);
        eimg = view.findViewById(R.id.eventimg);
        rView = view.findViewById(R.id.recycleviews1);
        rvLayout = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(rvLayout);
        loadMatch();
     //   navBottom();
        return view;
    }

    public void loadMatch()
    {

        ApiClient rfit = new ApiClient();
        rfit.retrofitBuilder2();

        Call<Event> call = retrofitBuilder2().getEventss();
        call.enqueue(new Callback<Event>(){
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                Event dataList = response.body();

                List<Event.Events> soccerlist = dataList.getEventss();
                euts.addAll(soccerlist);
                //List<List<Matches>> matchlist = dataList;
                // teamsss.addAll(soccerlist);
                // teamsss.addAll(soccerlist);
                //    teamsss.addAll(dataList.getTeams());
                //String city, String name, String conference, String division, String fullName, String wikipediaLogoUrl, String wikipediaWordMarkUrl, StadiumDetails stadiumDetails
                adapter = new EventAdapter(getActivity(), soccerlist);
                rView.setAdapter(adapter);
//                swipeRefreshLayout.setRefreshing(false);
                // teamsss.addAll(dataList.getTeams());
                // teamsss = rvAdapter.

            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {

            }
        });
    }
//    private void navBottom()
//    {
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.previous:
//                        Intent team = new Intent(getActivity(), PreviousList.class);
//                        startActivity(team);
////                        overridePendingTransition(0,0);
//                        finish();
//                        break;
////                    case R.id.linkss:
////                        Intent stad =  new Intent(getApplicationContext(), linktab.class);
////                        startActivity(stad);
////                        overridePendingTransition(0,0);
////                        finish();
////                        break;
////                    case R.id.linkss:
////                        Intent soc = new Intent(getApplicationContext(), linktab.class);
////                        startActivity(soc);
////                        overridePendingTransition(0,0);
////                        break;
//                    case R.id.coming:
////                        finish();
//                        return true;
//                }
//                return true;
//            }
//        });
//    }
}