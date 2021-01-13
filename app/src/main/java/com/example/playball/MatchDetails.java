package com.example.playball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class MatchDetails extends AppCompatActivity {
    private TextView title,url,date,time;
    private WebView webby;
    private String webs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);
     //   time = findViewById(R.id.time);
        date = findViewById(R.id.date);
        title = findViewById(R.id.Title);
        url = findViewById(R.id.url);
        webby = findViewById(R.id.webView);
        webs = info.membed;
        title.setText(info.mtitle);
        url.setText(info.murl);
     //   time.setText(info.mtime);
        date.setText(info.mdate);
        webby.getSettings().setJavaScriptEnabled(true);
        webby.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        webby.loadData(removeUrl(webs),"text/html", "UTF-8");
    }
    private String removeUrl(String all){
        String s = "src='";
        int ix = all.indexOf(s)+s.length();
        String changedURL =  all.substring(ix, all.indexOf("'", ix+1));
        changedURL = "<div style='width:100%;height:0px;position:relative;padding-bottom:calc(56.25% + 335px);' class='_scorebatEmbeddedPlayerW_'><iframe src='" +
                changedURL +
                "' frameborder='0' width='560' height='650' allowfullscreen allow='autoplay; fullscreen' style='width:100%;height:100%;position:absolute;left:0px;top:0px;overflow:hidden;' class='_scorebatEmbeddedPlayer_'></iframe></div>";
        return changedURL;
    }
}