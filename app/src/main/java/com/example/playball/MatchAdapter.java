package com.example.playball;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playball.models.Matches;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MatchAdapter extends  RecyclerView.Adapter<MatchAdapter.ViewHolder> {
public List<Matches> matchs;
public Matches mat;
public Context context;
     TextView title,url,date,time;
     WebView webby;
    // public static String desc;

    public MatchAdapter(Context context, List matches) {
        this.context = context;
        this.matchs = matches;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.matchitem, parent, false);
        MatchAdapter.ViewHolder viewHolder = new MatchAdapter.ViewHolder(v);
        return viewHolder;
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

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.itemView.setTag(matchs.get(position));
        mat = matchs.get(position);
        holder.title.setText(mat.getTitle());
        holder.date.setText("\u2022"+ Utils.DateFormat(mat.getDate()));
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_match_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        date = myDialog.findViewById(R.id.date);

        title = myDialog.findViewById(R.id.Title);
        url = myDialog.findViewById(R.id.url);
        webby = myDialog.findViewById(R.id.webView);
        title.setText(mat.getTitle());
        date.setText(mat.getDate());
        url.setText(mat.getUrl());
        String webs = mat.getEmbed();
        webby.getSettings().setJavaScriptEnabled(true);
        webby.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        webby.loadData(removeUrl(webs),"text/html", "UTF-8");

        Picasso.get().load(matchs.get(position).getThumbnail()).into(holder.img, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                holder.img.setImageResource(R.drawable.ic_launcher_background);
                holder.progressBar.setVisibility(View.GONE);

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i<matchs.size(); i++){
                    if(holder.title.getText()==matchs.get(i).getTitle()) {
                        Intent soc = new Intent(context, MatchDetails.class);
                        info.membed = matchs.get(i).getEmbed();
                        info.mtitle = matchs.get(i).getTitle();
                        info.murl = matchs.get(i).getUrl();
                      //  info.mtime ="\u2022"+ Utils.DateToTimeFormat(mat.getDate());
                        info.mdate ="\u2022"+ Utils.DateFormat(mat.getDate());
//                        context.startActivity(soc);
                            myDialog.show();

                    }
                }
            }


        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i<matchs.size(); i++){
                    if(holder.title.getText()==matchs.get(i).getTitle()) {
                        Intent soc = new Intent(context, MatchDetails.class);
                        info.membed = matchs.get(i).getEmbed();
                        info.mtitle = matchs.get(i).getTitle();
                        info.murl = matchs.get(i).getUrl();
                        //  info.mtime ="\u2022"+ Utils.DateToTimeFormat(mat.getDate());
                        info.mdate ="\u2022"+ Utils.DateFormat(mat.getDate());
//                        context.startActivity(soc);
                        myDialog.show();

                    }
                }
            }


        });

    }


    @Override
    public int getItemCount() {
            return matchs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;
        public TextView title;
        public TextView date;
        public TextView time;
        public ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            progressBar = itemView.findViewById(R.id.progress_load_photo);
            title = (TextView) itemView.findViewById(R.id.Title);
            date = (TextView) itemView.findViewById(R.id.date);
            img = (ImageView) itemView.findViewById(R.id.matchimg);

        }

    }
}
