package com.example.playball;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class teamtab extends AppCompatActivity {
    private TextView alter,desc,year,sportt,bansa;
    private ImageView teamimg,jersey,name,badge;
    private CarouselView carousel;
    public ArrayList<String> llvpics = new ArrayList<>();
    //private String tname,talt,tdesc,timg;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teamtab);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.teams);
        name = findViewById(R.id.name);
        alter = findViewById(R.id.alterName);
        desc = findViewById(R.id.teamdesc);
     //   teamimg = findViewById(R.id.teamimg);
        year = findViewById(R.id.year);
        sportt = findViewById(R.id.sport);
        jersey = findViewById(R.id.jerseyimg);
        badge = findViewById(R.id.tbadge);
        bansa = findViewById(R.id.country);
        carousel = findViewById(R.id.img);
       // Intent intent = getIntent();
     //   tname = intent.getStringExtra("tn");
      //  talt = intent.getStringExtra("aname");
      //  tdesc = intent.getStringExtra("tdesc");
     //   timg = intent.getStringExtra("timg");
        navBottom();
        showPics();

        year.setText(info.tyear);
        sportt.setText(info.tsport);
        desc.setText(info.tdesc);
        bansa.setText(info.count);
        //name.setText(info.tname);
        alter.setText(info.ttname);
        Picasso.get().load(info.tname).into(name);
       // Picasso.get().load(info.timg).into(teamimg);
        Picasso.get().load(info.tjersey).into(jersey);
        Picasso.get().load(info.tbadge).into(badge);

    }
    private void navBottom()
        {
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.linkss:
                            Intent vid = new Intent(getApplicationContext(), linktab.class);
                            startActivity(vid);
                            overridePendingTransition(0,0);
                            finish();
                            break;
                        case R.id.stadium:
                            Intent stad =  new Intent(getApplicationContext(), stadiumtab.class);
                            startActivity(stad);
                            overridePendingTransition(0,0);
                            finish();
                            break;
//                        case R.id.linkss:
//                            Intent soc = new Intent(getApplicationContext(), linktab.class);
//                            startActivity(soc);
//                            overridePendingTransition(0,0);
//                            break;
                        case R.id.teams:
                            finish();
                            return true;
                    }
                    return true;
                }
            });
    }
    @Override
    public void onBackPressed(){
        Intent in = new Intent(this, Home.class);
        finish();
        startActivity(in);
    }
    public void showPics()
    {
//        System.out.println(llvpics.toString());
//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + llvpics.size());

        carousel.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {

                ArrayList<String> imageListTitle = new ArrayList<String>();
                llvpics.add(info.timg);
                llvpics.add(info.img2);
                llvpics.add(info.img3);
                llvpics.add(info.img4);
                for(int i = 0; i < llvpics.size(); i++ ){
                    imageListTitle.add(llvpics.get(i));
                }
                //imageView.setImageResource(imagelist[position]);
                Picasso.get().load(imageListTitle.get(position)).into(imageView);

            }
        });
        carousel.setPageCount(4);
    }
}

