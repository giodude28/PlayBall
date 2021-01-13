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

import de.hdodenhof.circleimageview.CircleImageView;

public class stadiumtab extends AppCompatActivity {
    private TextView sname,sdesc,scap,sloc;
    private ImageView smimg;
    private CircleImageView badge;
   // private String staname,stadesc,simg;
   public ArrayList<String> llvpics = new ArrayList<>();
    private CarouselView carousel;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stadiumtab);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.stadium);
        sname = findViewById(R.id.stadiumname);
        sdesc = findViewById(R.id.stadiumdesc);
       // smimg = findViewById(R.id.stadiumimg);
        scap = findViewById(R.id.capacity);
        sloc = findViewById(R.id.location);
        badge = findViewById(R.id.tbadge);
        carousel = findViewById(R.id.stimg);
        Intent intent = getIntent();
       // staname = intent.getStringExtra("stadiumNAME");
       // stadesc = intent.getStringExtra("stadiumDESC");
        //simg = intent.getStringExtra("stadiumImage");
        navBottom();
        showPics();
       sname.setText(info.stadiumn);
        sdesc.setText(info.stadiumd);
        sloc.setText(info.slocation);
        scap.setText(info.scapacity);
       //alter.setText(talt);
        Picasso.get().load(info.tbadge).into(badge);
        //Picasso.get().load(info.stadiumimg).into(smimg);
    }
    private void navBottom()
    {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.teams:
                        Intent team = new Intent(getApplicationContext(), teamtab.class);
                        startActivity(team);
                        overridePendingTransition(0,0);
                        finish();
                        break;
                    case R.id.linkss:
                        Intent stad =  new Intent(getApplicationContext(), linktab.class);
                        startActivity(stad);
                        overridePendingTransition(0,0);
                        finish();
                        break;
//                    case R.id.linkss:
//                        Intent soc = new Intent(getApplicationContext(), linktab.class);
//                        startActivity(soc);
//                        overridePendingTransition(0,0);
//                        break;
                    case R.id.stadium:
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
        carousel.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {

                ArrayList<String> imageListTitle = new ArrayList<String>();
                llvpics.add(info.timg);
                llvpics.add(info.stadiumimg);
                for(int i = 0; i < llvpics.size(); i++ ){
                    imageListTitle.add(llvpics.get(i));
                }
                Picasso.get().load(imageListTitle.get(position)).into(imageView);

            }
        });
        carousel.setPageCount(4);
    }
}
