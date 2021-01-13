package com.example.playball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playball.models.PreviousEvent;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PreviousAdapter extends RecyclerView.Adapter<PreviousAdapter.ViewHolder> {
    public List<PreviousEvent.PreviousEvents> pevents;
 public List<PreviousEvent.PreviousEvents> prev;
    public PreviousEvent.PreviousEvents pe;
    public Context context;
    TextView event,date,time,league,season,home,away,venue,status,homescore,awayscore;
    ImageView imey;
// public static String desc;


    public PreviousAdapter(Context context, List prev) {
        this.context = context;
        this.pevents = prev;
    }
    public void updateList(List<PreviousEvent.PreviousEvents> previousList) {
        this.pevents = previousList;
     notifyDataSetChanged();
    }

    //private String removeUrl(String all){
//        String s = "src='";
//        int ix = all.indexOf(s)+s.length();
//        String changedURL =  all.substring(ix, all.indexOf("'", ix+1));
//        changedURL = "<div style='width:100%;height:0px;position:relative;padding-bottom:calc(56.25% + 335px);' class='_scorebatEmbeddedPlayerW_'><iframe src='" +
//                changedURL +
//                "' frameborder='0' width='560' height='650' allowfullscreen allow='autoplay; fullscreen' style='width:100%;height:100%;position:absolute;left:0px;top:0px;overflow:hidden;' class='_scorebatEmbeddedPlayer_'></iframe></div>";
//        return changedURL;
//    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.previousitem, parent, false);
        PreviousAdapter.ViewHolder viewHolder = new PreviousAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PreviousAdapter.ViewHolder holder, int position) {



        holder.itemView.setTag(pevents.get(position));
        pe = pevents.get(position);
        // String aa = tm.getAltername();
        holder.title.setText(pe.getStrEvent());
        holder.date.setText(pe.getDateEvent());
        holder.time.setText(pe.getStrTime());
        holder.league.setText(pe.getStrLeague());
        holder.season.setText(pe.getStrSeason());
        holder.home.setText(pe.getStrHomeTeam());
        holder.away.setText(pe.getStrAwayTeam());
        holder.venue.setText(pe.getStrVenue());
        holder.status.setText(pe.getStrStatus());
        holder.homescore.setText(pe.getHomescore());
        holder.awayscore.setText(pe.getAwayscore());

        Picasso.get().load(pevents.get(position).getStrThumb()).into(holder.eimg, new Callback() {
            @Override
            public void onSuccess() {
//                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
//                holder.eimg.setImageResource(R.drawable.ic_launcher_background);
//                holder.progressBar.setVisibility(View.GONE);

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
              //  myDialog.show();

            }
            //  }
            //     }


        });
    }

    @Override
    public int getItemCount() {
        return pevents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ProgressBar progressBar;
        public TextView title;
        public TextView date;
        public TextView time;
        public TextView league;
        public TextView season;
        public TextView home;
        public TextView away;
        public TextView venue;
        public TextView status;
        public TextView homescore;
        public TextView awayscore;
        public CircleImageView eimg;
        //  public CircleImageView badge;

        //   public TextView web;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //   web = itemView.findViewById(R.id.weblink);
            title = (TextView) itemView.findViewById(R.id.eventtitle);
            date = (TextView) itemView.findViewById(R.id.eventdate);
            time = (TextView) itemView.findViewById(R.id.eventtime);
            league = (TextView) itemView.findViewById(R.id.eventleague);
            home = (TextView) itemView.findViewById(R.id.home);
            awayscore = (TextView) itemView.findViewById(R.id.awayscore);
            homescore = (TextView) itemView.findViewById(R.id.homescore);
            away = (TextView) itemView.findViewById(R.id.away);
            season=(TextView) itemView.findViewById(R.id.eventseason);
            venue = (TextView) itemView.findViewById(R.id.eventvenue);
            status = (TextView) itemView.findViewById(R.id.eventstatus);
            eimg = (CircleImageView) itemView.findViewById(R.id.eventimg);
            progressBar = itemView.findViewById(R.id.progress_load_photo);

        }
    }
}
