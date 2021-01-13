package com.example.playball;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playball.API.ApiClient;
import com.example.playball.models.Teams;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//implements SwipeRefreshLayout.OnRefreshListener
public class MainActivity extends Fragment {
    private List<Teams.Teamss> teamsss = new ArrayList<>();
    private List<Teams.Teamss> listTeams;
    private TextView name, alter;
    private EditText search;
    private ImageView image;
    Teams dataList;
    ArrayList<String> imageListTitle = new ArrayList<String>();
    private TeamAdapter adapter;
    private RecyclerView rView;
    public ArrayList<String> llvpics = new ArrayList<>();
    //private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayout;
    private BottomNavigationView bottomNavigationView;
    private CarouselView carousel;
    View view;
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);

        return true;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.activity_main, container, false);
        getActivity().setTitle("Play Ball");
//        bottomNavigationView = view.findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.teams);
//        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
//        swipeRefreshLayout.setOnRefreshListener(this);
//        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        name = view.findViewById(R.id.TeamName);
        alter = view.findViewById(R.id.altername);
        search = view.findViewById(R.id.searchteam);
        image = view.findViewById(R.id.img);
        rView = view.findViewById(R.id.recycleviews);
      //  rvLayout = new GridLayoutManager(this,2, RecyclerView.VERTICAL, false);
        rvLayout = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        rView.setLayoutManager(rvLayout);
//        SnapHelper pagerSnapHelper = new PagerSnapHelper();
//        pagerSnapHelper.attachToRecyclerView(rView);
        carousel = view.findViewById(R.id.frontimg);
        //navBottom();
        loadLigas();
        loadteam();
        return view;

//        onLoadingSwipeRefresh("");

    }

    public void loadteam() {
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //filterTeams(search.toString());
            }

            @Override
            public void afterTextChanged(Editable search) {
                filterTeams(search.toString());
            }
        });
    }

    //    final String keyword
    public void loadLigas() {
        ApiClient rfit = new ApiClient();
        rfit.retrofitBuilder();

        Call<Teams> call = rfit.retrofitBuilder().getTeams();
        call.enqueue(new Callback<Teams>() {
            @Override
            public void onResponse(Call<Teams> call, Response<Teams> response) {
                dataList = response.body();

                List<Teams.Teamss> soccerlist = dataList.getTeams();
                // teamsss.addAll(soccerlist);
                teamsss.addAll(soccerlist);
                for (int i = 0; i < soccerlist.size(); i++) {
                    addItem(soccerlist.get(i).getImg2());

                }

                adapter = new TeamAdapter(getActivity(), soccerlist);
                rView.setAdapter(adapter);
                showPics();
            }

            @Override
            public void onFailure(Call<Teams> call, Throwable t) {

            }
        });
    }

    public void showPics() {

        carousel.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {

                ArrayList<String> imageListTitle = new ArrayList<String>();
                for(int i = 0; i < llvpics.size(); i++ ){
                    imageListTitle.add(llvpics.get(i));
                }
                Picasso.get().load(imageListTitle.get(position)).into(imageView);

            }
        });
        carousel.setPageCount(llvpics.size());

    }

    public void addItem(String pics){
        llvpics.add(pics);
    }

    private void filterTeams(String textInput) {

        ArrayList<Teams.Teamss> sortList = new ArrayList();

        for (Teams.Teamss teams : teamsss) {
            if (teams.getTeamname().toLowerCase().contains(textInput.toLowerCase())) {
                sortList.add(teams);
            }
        }
        adapter.updateList(sortList);
    }
}