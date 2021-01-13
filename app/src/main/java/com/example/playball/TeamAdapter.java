package com.example.playball;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playball.models.Teams;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder>{
    public List<Teams.Teamss> teams;
    public Teams.Teamss tm;
    public Context context;
   // public static String desc;

    public TeamAdapter(Context context, List teamss) {
        this.context = context;
        this.teams = teamss;
    }
public void updateList(List<Teams.Teamss> TeamList){
        this.teams = TeamList;
        notifyDataSetChanged();
}
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {



        holder.itemView.setTag(teams.get(position));
        tm = teams.get(position);
       // String aa = tm.getAltername();
        holder.teamName.setText(tm.getTeamname());
        if(holder.teamAlter.getText()==null){

        }

       // String gg = tm.getAltername();
//        for (int i=0; i<teams.size();i++){
//                String gg = tm.getAltername();
//                if(gg==null){
//                    int a = i;
//                    if (a==)
//                }
//        }
        if(tm.getAltername() == null)
        {
            holder.teamAlter.setText(tm.getTeamname());
        }else
        {
            holder.teamAlter.setText(tm.getAltername());
        }
        holder.teamword.setText(tm.getTeamdesc());
        Picasso.get().load(tm.getTbadge()).into(holder.badge);

        Picasso.get().load(teams.get(position).getImg()).into(holder.teamImg, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                holder.teamImg.setImageResource(R.drawable.ic_launcher_background);
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i<teams.size(); i++){
                    if(holder.teamName.getText()==teams.get(i).getTeamname()) {
                        Intent soc = new Intent(context, teamtab.class);
                      //  soc.putExtra("tn", TeamName);
                       // soc.putExtra("aname", TeamAlter);
                      //  soc.putExtra("timg", teamimage);
                       // soc.putExtra("jerseyimg", jersey);
                      //  soc.putExtra("form", fyear);
                      //  soc.putExtra("sporty", sportyy);

                        info.stadiumd = teams.get(i).getStadiumdesc();
                        info.tname = teams.get(i).getName();
                        info.stadiumimg = teams.get(i).getStadiumimg();
                        info.stadiumn = teams.get(i).getStaduim();
                        info.talt = teams.get(i).getAltername();
                        info.tdesc = teams.get(i).getTeamdesc();
                        info.timg = teams.get(i).getImg();
                        info.tjersey = teams.get(i).getTeamjersey();
                        info.tyear = teams.get(i).getFormedyear();
                        info.tsport = teams.get(i).getSport();
                        info.slocation = teams.get(i).getLocation();
                        info.scapacity = teams.get(i).getCapacity();
                        info.tbadge = teams.get(i).getTbadge();
                        info.website = teams.get(i).getWebsite();
                        info.fb = teams.get(i).getFb();
                        info.twit = teams.get(i).getTwitter();
                        info.insta = teams.get(i).getInsta();
                        info.count = teams.get(i).getCountry();
                        info.ttname = teams.get(i).getTeamname();
                        info.img2 = teams.get(i).getImg2();
                        info.img3 = teams.get(i).getImg3();
                        info.img4 = teams.get(i).getImg4();
                    // soc.putExtra("stadiumNAME", stadiumnamee);
                       // soc.putExtra("stadiumImage", stadiumimagee);
                       // soc.putExtra("stadiumDESC", stadiumdescc);
                        //soc.putExtra("tdesc", teamdesc);
                        context.startActivity(soc);


                    }
//                    if(holder.teamName.getText()==teams.get(i).getTeamname()){
//                        Intent soc = new Intent(context, teamtab.class);
//                        soc.putExtra("tn",TeamName);
//                        soc.putExtra("aname",TeamAlter);
//                        soc.putExtra("timg",teamimage);
//                        soc.putExtra("tdesc",teamdesc);
//                        //soc.putExtra("teamName",holder.teamName.getText());
//                       // context.startActivity(soc);
//                    }
//
//                            Intent ss = new Intent(context, stadiumtab.class);
//                            ss.putExtra("stname",stadiumnamee);
//                            ss.putExtra("stdesc",stadiumdescc);
//                            ss.putExtra("stimg",stadiumimagee);
//                            //soc.putExtra("teamName",holder.teamName.getText());
//                            context.startActivity(ss);
                        }
                }


        });
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

    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ProgressBar progressBar;
        public TextView teamName;
        public TextView teamAlter;
        public TextView teamword;
        public ImageView teamImg;
        public CircleImageView badge;

        //   public TextView web;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //   web = itemView.findViewById(R.id.weblink);
            teamName = (TextView) itemView.findViewById(R.id.TeamName);
            teamAlter = (TextView) itemView.findViewById(R.id.altername);
            teamword = (TextView) itemView.findViewById(R.id.word);
            teamImg = (ImageView) itemView.findViewById(R.id.img);
            progressBar = itemView.findViewById(R.id.progress_load_photo);
            badge = itemView.findViewById(R.id.tbadge);

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
