package com.example.playball;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playball.API.ApiClient;
import com.example.playball.models.Matches;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.playball.API.ApiClient.retrofitBuilder1;

public class matchview extends Fragment {
    private List<Matches> mats = new ArrayList<>();
    private List<Matches> mama;
    private TextView title,date;
    private ImageView image;
    private MatchAdapter adapter;
    private RecyclerView.LayoutManager rvLayout;
    private RecyclerView rView;
    private BottomNavigationView bottomNavigationView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        view = inflater.inflate(R.layout.matchview, container, false);
          title = view.findViewById(R.id.Title);
          date = view.findViewById(R.id.date);
          image = view.findViewById(R.id.matchimg);
          rView = view.findViewById(R.id.recycleviews1);
        loadMatch();
        rvLayout = new LinearLayoutManager(getActivity());
        rView.setLayoutManager(rvLayout);
 return view;
    }
    public void loadMatch()
    {

        ApiClient rfit = new ApiClient();
        retrofitBuilder1();

        Call<List<Matches>> call = rfit.retrofitBuilder1().getMatches();
        call.enqueue(new Callback<List<Matches>>(){
            @Override
            public void onResponse(Call<List<Matches>> call, Response<List<Matches>> response) {
                List<Matches> dataList = response.body();

                adapter = new MatchAdapter(getActivity(), dataList);
                rView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Matches>> call, Throwable t) {

            }
        });
    }

}
