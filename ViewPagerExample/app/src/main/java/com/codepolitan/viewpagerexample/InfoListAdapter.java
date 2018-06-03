package com.codepolitan.viewpagerexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by rudihartono on 5/26/18.
 */

public class InfoListAdapter extends RecyclerView.Adapter<InfoListAdapter.InfoViewHolder> {

    ArrayList<News> data;
    Context context;

    public InfoListAdapter(Context context, ArrayList<News> data){
        this.context = context;
        this.data = data;
    }

    //Cara mengambil template layout (xml)
    @Override
    public InfoListAdapter.InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.info,
                parent, false);

        return new InfoListAdapter.InfoViewHolder(view);
    }


    //Menampilkan data ke layar sesuai dengan layout yang diload
    @Override
    public void onBindViewHolder(InfoListAdapter.InfoViewHolder holder, int position) {
        final News news = data.get(position);

        if(holder!=null){

            try {


                holder.cardNews.setOnClickListener(new View.OnClickListener() {
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

    //harus sesuai dengan jumlah data
    @Override
    public int getItemCount() {

        Log.d("Total data", " data : "+ data.size());
        return data.size();
    }

    //inner class
    //sesuaikan dengan layout
    public class InfoViewHolder extends RecyclerView.ViewHolder {

        CardView cardNews;
        TextView tvJudul, tvPenulis;
        ImageView ivThumbnail;

        public InfoViewHolder(View itemView) {
            super(itemView);



            try{
                tvJudul = (TextView)itemView.findViewById(R.id.tvInfoJudul);
                tvPenulis = (TextView)itemView.findViewById(R.id.tvInfoPenulis);
                ivThumbnail = (ImageView)itemView.findViewById(R.id.ivSampulInfo);

                cardNews = (CardView)itemView.findViewById(R.id.cardInfo);

            }
            catch (Exception ex)
            {
                Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
