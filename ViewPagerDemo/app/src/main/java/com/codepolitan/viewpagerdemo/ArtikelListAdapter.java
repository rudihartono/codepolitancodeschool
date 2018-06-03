package com.codepolitan.viewpagerdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by rudihartono on 5/19/18.
 */

public class ArtikelListAdapter extends RecyclerView.Adapter<ArtikelListAdapter.ArtikelViewHolder> {

    ArrayList<Artikel> data;
    Context context;
    public ArtikelListAdapter(ArrayList<Artikel> data, Context context)
    {
        this.data = data;
        this.context = context;
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(ArtikelViewHolder holder, int position) {

        Artikel artikel = data.get(position);

        holder.tvPenulis.setText(artikel.getAuthor_name());
        holder.tvJudul.setText(artikel.getTitle());


        Picasso.with(context).load(artikel.getThumbnail()).into(holder.ivThumbnail);
    }

    @Override
    public ArtikelViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.artikel,
                parent, false);

        return new ArtikelViewHolder(view);
    }

    public class ArtikelViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvPenulis;
        ImageView ivThumbnail;
        public ArtikelViewHolder(View itemView) {

            super(itemView);
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvPenulis = (TextView) itemView.findViewById(R.id.tvPenulis);
            ivThumbnail = (ImageView) itemView.findViewById(R.id.ivSampul);
        }
    }
}
