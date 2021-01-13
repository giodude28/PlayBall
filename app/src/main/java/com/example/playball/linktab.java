package com.example.playball;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class linktab extends AppCompatActivity {
private TextView fb,twit,inst,web;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.links);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.linkss);
        fb = findViewById(R.id.fb);
        twit = findViewById(R.id.twitter);
        inst = findViewById(R.id.insta);
        web = findViewById(R.id.website);
        fb.setMovementMethod((LinkMovementMethod.getInstance()));
        fb.setText(info.fb);
        twit.setMovementMethod((LinkMovementMethod.getInstance()));
        twit.setText(info.twit);
        inst.setMovementMethod((LinkMovementMethod.getInstance()));
        inst.setText(info.insta);
        web.setMovementMethod((LinkMovementMethod.getInstance()));
        web.setText(info.website);
        navBottom();
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
                    case R.id.stadium:
                        Intent stad =  new Intent(getApplicationContext(), stadiumtab.class);
                        startActivity(stad);
                        overridePendingTransition(0,0);
                        finish();
                        break;
                  /*  case R.id.linkss:
                        Intent soc = new Intent(getApplicationContext(), linktab.class);
                        startActivity(soc);
                        overridePendingTransition(0,0);
                        break;*/
                    case R.id.linkss:
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
}
