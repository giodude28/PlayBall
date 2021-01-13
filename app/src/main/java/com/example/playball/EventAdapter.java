package com.example.playball;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playball.models.Event;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>{
public List<Event.Events> Event;
public Event.Events ee;
public Context context;
    TextView event,date,time,league,season,home,away,venue,status;
    ImageView imey;
// public static String desc;

public EventAdapter(Context context, List events) {
        this.context = context;
        this.Event = events;
        }
public void updateList(List<Event.Events> EventList) {
    this.Event = EventList;
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
        }

@Override
public void onBindViewHolder(final ViewHolder holder, int position) {



        holder.itemView.setTag(Event.get(position));
        ee = Event.get(position);
        // String aa = tm.getAltername();
        holder.title.setText(ee.getStrEvent());
        holder.date.setText(ee.getDateEvent());
        holder.time.setText(ee.getStrTime());
    final Dialog myDialog;
    myDialog = new Dialog(context);
    myDialog.setContentView(R.layout.activity_event_details);
    myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    date = myDialog.findViewById(R.id.date);
    event = myDialog.findViewById(R.id.Title);
    time = myDialog.findViewById(R.id.time);
    league = myDialog.findViewById(R.id.league);
    imey = myDialog.findViewById(R.id.imagematch);
    season = myDialog.findViewById(R.id.season);
    home = myDialog.findViewById(R.id.home);
    away = myDialog.findViewById(R.id.away);
    venue = myDialog.findViewById(R.id.venue);
    status = myDialog.findViewById(R.id.stats);
    league.setText(ee.getStrLeague());
    date.setText(ee.getDateEvent());
    season.setText(ee.getStrSeason());
    venue.setText(ee.getStrVenue());
    home.setText(ee.getStrHomeTeam());
    away.setText(ee.getStrAwayTeam());
    status.setText(ee.getStrStatus());
    event.setText(ee.getStrEvent());
    time.setText(ee.getStrTime());
    Picasso.get().load(Event.get(position).getStrThumb()).into(imey, new Callback() {
        @Override
        public void onSuccess() {
            holder.progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onError(Exception e) {
            holder.eimg.setImageResource(R.drawable.ic_launcher_background);
            holder.progressBar.setVisibility(View.GONE);

        }
    });
//    url.setText(mat.getUrl());
//    String webs = mat.getEmbed();
//    webby.getSettings().setJavaScriptEnabled(true);
//    webby.setOnTouchListener(new View.OnTouchListener(){
//        @Override
//        public boolean onTouch(View v, MotionEvent event){
//            return (event.getAction() == MotionEvent.ACTION_MOVE);
//        }
//    });
//    webby.loadData(removeUrl(webs),"text/html", "UTF-8");
        Picasso.get().load(Event.get(position).getStrThumb()).into(holder.eimg, new Callback() {
@Override
public void onSuccess() {
        holder.progressBar.setVisibility(View.GONE);
        }

@Override
public void onError(Exception e) {
        holder.eimg.setImageResource(R.drawable.ic_launcher_background);
        holder.progressBar.setVisibility(View.GONE);

        }
        });
        //Picasso.get().load(tm.getImg()).into(holder.teamImg);
//                .placeholder(R.drawable.draw_detailed_view_display)
//                .error(R.drawable.draw_detailed_view_display)
//                .resize(200, 200)
//                .into(holder.mImageEvidence, new Callback() {
//                    @Override
//                    public void onSuccess() {
//                        holder.mMediaEvidencePb.setVisibility(View.GONE);
//                    }
//
//                    @Override
//                    public void onError() {
//                        holder.mErrorImage.setVisibility(View.VISIBLE);
//                    }
//                });

        // progressBar = itemView.findViewById(R.id.progress_load_photo);
//        final String teamimage = tm.getImg();
//        final String TeamAlter = tm.getAltername();
//        final String TeamName = tm.getTeamname();
//        final String jersey = tm.getTeamjersey();
//        final String fyear = tm.getFormedyear();
//        final String sportyy = tm.getSport();
//        final String stadiumnamee = tm.getStaduim();
//        final String stadiumimagee = tm.getStadiumimg();
//        final String stadiumdescc = tm.getStadiumdesc();
//        final String teamdesc = tm.getTeamdesc();

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        for (int i = 0; i<teams.size(); i++){
//        if(holder.teamName.getText()==teams.get(i).getTeamname()) {
//        Intent soc = new Intent(context, teamtab.class);
//        //  soc.putExtra("tn", TeamName);
//        // soc.putExtra("aname", TeamAlter);
//        //  soc.putExtra("timg", teamimage);
//        // soc.putExtra("jerseyimg", jersey);
//        //  soc.putExtra("form", fyear);
//        //  soc.putExtra("sporty", sportyy);
//
//        info.stadiumd = teams.get(i).getStadiumdesc();
//        info.tname = teams.get(i).getName();
//        info.stadiumimg = teams.get(i).getStadiumimg();
//        info.stadiumn = teams.get(i).getStaduim();
//        info.talt = teams.get(i).getAltername();
//        info.tdesc = teams.get(i).getTeamdesc();
//        info.timg = teams.get(i).getImg();
//        info.tjersey = teams.get(i).getTeamjersey();
//        info.tyear = teams.get(i).getFormedyear();
//        info.tsport = teams.get(i).getSport();
//        info.slocation = teams.get(i).getLocation();
//        info.scapacity = teams.get(i).getCapacity();
//        info.tbadge = teams.get(i).getTbadge();
//        info.website = teams.get(i).getWebsite();
//        info.fb = teams.get(i).getFb();
//        info.twit = teams.get(i).getTwitter();
//        info.insta = teams.get(i).getInsta();
//        info.count = teams.get(i).getCountry();
//        info.ttname = teams.get(i).getTeamname();
//        info.img2 = teams.get(i).getImg2();
//        info.img3 = teams.get(i).getImg3();
//        info.img4 = teams.get(i).getImg4();
//        // soc.putExtra("stadiumNAME", stadiumnamee);
//        // soc.putExtra("stadiumImage", stadiumimagee);
//        // soc.putExtra("stadiumDESC", stadiumdescc);
//        //soc.putExtra("tdesc", teamdesc);
//        context.startActivity(soc);
//
//
//        }
////                    if(holder.teamName.getText()==teams.get(i).getTeamname()){
////                        Intent soc = new Intent(context, teamtab.class);
////                        soc.putExtra("tn",TeamName);
////                        soc.putExtra("aname",TeamAlter);
////                        soc.putExtra("timg",teamimage);
////                        soc.putExtra("tdesc",teamdesc);
////                        //soc.putExtra("teamName",holder.teamName.getText());
////                       // context.startActivity(soc);
////                    }
////
////                            Intent ss = new Intent(context, stadiumtab.class);
////                            ss.putExtra("stname",stadiumnamee);
////                            ss.putExtra("stdesc",stadiumdescc);
////                            ss.putExtra("stimg",stadiumimagee);
////                            //soc.putExtra("teamName",holder.teamName.getText());
////                            context.startActivity(ss);
//        }
//        }
//
//
//        });
       /* holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0 ; i<teams.size();i++ ){
                    if(holder.teamTitle.getText() == lls.get(i).getStrAlternate()){
                        teamWeb = teams.get(i).getStrWebsite().toString();
                        break;
                    }

                }
               // Intent web = new Intent(v.getContext(), TeamWebview.class);
               // web.putExtra("link", teamWeb);
               // context.startActivity(web);
            }
        });*/
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                    myDialog.show();

                }

    });
        }

@Override
public int getItemCount() {
        return Event.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder{

    ProgressBar progressBar;
    public TextView title;
    public TextView date;
    public TextView time;
    public ImageView eimg;
  //  public CircleImageView badge;

    //   public TextView web;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        //   web = itemView.findViewById(R.id.weblink);
        title = (TextView) itemView.findViewById(R.id.eventtitle);
        date = (TextView) itemView.findViewById(R.id.eventdate);
        time = (TextView) itemView.findViewById(R.id.eventtime);
        eimg = (ImageView) itemView.findViewById(R.id.eventimg);
        progressBar = itemView.findViewById(R.id.progress_load_photo);
       // badge = itemView.findViewById(R.id.tbadge);

        //  more = (TextView) itemView.findViewById(R.id.More);

         /*   itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent web = new Intent(view.getContext(),TeamWebview.class);
                    web.putExtra()
                    view.getContext().startActivity(web);
                    //ListSoccer cpu = (ListSoccer) view.getTag();

                    //Toast.makeText(view.getContext(), cpu.getPersonName()+" is "+ cpu.getJobProfile(), Toast.LENGTH_SHORT).show();

                }
            });*/

    }
}
}
