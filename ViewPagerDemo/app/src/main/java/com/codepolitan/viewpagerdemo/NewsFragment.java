package com.codepolitan.viewpagerdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    public ArrayList<Artikel> artikels = new ArrayList<Artikel>();

    RecyclerView recyclerView;
    ArtikelListAdapter adapter;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View v = inflater.inflate(R.layout.fragment_news, container,
                false);



        artikels.add(new Artikel("1", "Codepolitan in action", "Rudi Hartono"));
        artikels.add(new Artikel("2", "Ngecode yuk di codepolitan", "Rudi Hartono"));

        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);

        adapter = new ArtikelListAdapter(artikels, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        return  v;
    }

}
