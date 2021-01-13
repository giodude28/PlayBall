package com.example.playball;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.squareup.picasso.Picasso;

public class infoteam extends AppCompatActivity {
private ImageView jerseyimg,teamimg,stadiumimg;
private TextView name,alter,formedyear,sportsss,stadiumname,stadiumdesc,desc;
private String jersimg,teamimage,stadiumimage,tname,talter,tsports,stadiumName,stadiumDesc,tyear,tdesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infoteam);
    jerseyimg = findViewById(R.id.jerseyimg);
    teamimg = findViewById(R.id.teamimg);
    stadiumimg = findViewById(R.id.stadiumimg);
    name = findViewById(R.id.name);
    alter = findViewById(R.id.alterName);
    formedyear = findViewById(R.id.year);
    sportsss = findViewById(R.id.sport);
    stadiumname = findViewById(R.id.stadiumname);
    stadiumdesc = findViewById(R.id.stadiumdesc);
    desc = findViewById(R.id.teamdesc);

        Intent intent = getIntent();
        tname = intent.getStringExtra("tn");
        talter = intent.getStringExtra("aname");
        tyear = intent.getStringExtra("form");
        tsports = intent.getStringExtra("sporty");
        stadiumName = intent.getStringExtra("stadiumNAME");
        stadiumDesc = intent.getStringExtra("stadiumDESC");
        jersimg = intent.getStringExtra("jerseyimg");
        teamimage = intent.getStringExtra("timg");
        stadiumimage = intent.getStringExtra("stadiumImage");
        tdesc = intent.getStringExtra("tdesc");

        desc.setText(tdesc);
        name.setText(tname);
        alter.setText(talter);
        formedyear.setText(tyear);
        sportsss.setText(tsports);
        stadiumname.setText(stadiumName);
        stadiumdesc.setText(stadiumDesc);
        Picasso.get().load(jersimg).into(jerseyimg);
        Picasso.get().load(teamimage).into(teamimg);
        Picasso.get().load(stadiumimage).into(stadiumimg);

    }
}
