package com.codepolitan.viewpagerexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by rudihartono on 6/3/18.
 */

public class TutorialListAdapter extends RecyclerView.Adapter<TutorialListAdapter.TutorialViewHolder> {


    public ArrayList<News> tutorialList;
    public Context context;
    public  TutorialListAdapter(Context context, ArrayList<News> dataList){
        tutorialList = dataList;
        this.context = context;
    }
    @Override
    public TutorialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tutorial,
                parent, false);

        return new TutorialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TutorialViewHolder holder, int position) {

        final News news = tutorialList.get(position);

        if(holder!=null){

            try {

                holder.cardTutorial.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, DetailActivity.class);

                        intent.putExtra("NEWS", news);

                        context.startActivity(intent);
                    }
                });

                holder.tvPenulis.setText(news.getAuthor_name());
                holder.tvJudul.setText(news.getTitle());

                Picasso.with(context)
                        .load(news.getThumbnail())
                        .into(holder.ivThumbnail);

            }catch (Exception ex){
                Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public int getItemCount() {
        return tutorialList.size();
    }

    public class TutorialViewHolder extends  RecyclerView.ViewHolder{

        TextView tvJudul;
        TextView tvPenulis;
        ImageView ivThumbnail;
        CardView cardTutorial;

        public TutorialViewHolder(View itemView) {
            super(itemView);


            try{
                tvJudul = (TextView)itemView.findViewById(R.id.tvJudulTutorial);
                tvPenulis = (TextView)itemView.findViewById(R.id.tvPenulisTutorial);
                ivThumbnail = (ImageView)itemView.findViewById(R.id.ivSampulTutorial);

                cardTutorial = (CardView)itemView.findViewById(R.id.cardTutorial);

            }
            catch (Exception ex)
            {
                Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
