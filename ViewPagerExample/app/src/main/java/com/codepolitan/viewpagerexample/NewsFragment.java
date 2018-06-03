package com.codepolitan.viewpagerexample;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    public NewsListAdapter newsListAdapter;
    ProgressDialog progressDialog;
    public ArrayList<News> newsList;
    public RecyclerView recyclerView;

    public void GetCodepolitanNews(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://759b74ce43947f5f4c91aeddc3e5bad3d.codepolitan.com/api/v2/posts/category/news", new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();

                progressDialog.show();
                Log.d("onStart", "Start call api");
            }

            @Override
            public void onRetry(int retryNo) {

                super.onRetry(retryNo);

                Log.d("onRetry", "Retry : "+ retryNo);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                Log.d("onSuccess", "Success : " + statusCode);
                try{

                    String jsonString = new String(responseBody);

                    Log.d("jsonString", jsonString);

                    JSONObject jsonObject = new JSONObject(jsonString);

                    JSONArray jsonArray = jsonObject.getJSONArray("result");

                    for(int i = 0; i< jsonArray.length(); i++){

                        JSONObject object = jsonArray.getJSONObject(i);

                        newsList.add(new
                                News(object.getString("id"),
                                object.getString("title"),
                                object.getString("author_name"),
                                object.getString("thumbnail"),
                                object.getString("link"),
                                object.getString("description")));
                    }

                    newsListAdapter.notifyDataSetChanged();

                }catch (Exception ex){

                    Log.d("Error", ex.getMessage());

                }

                if(progressDialog.isShowing()){
                    progressDialog.hide();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", "Gagal : "+ statusCode);
            }
        });


    }

    public NewsFragment() {
        newsList = new ArrayList<News>();
        GetCodepolitanNews();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_news, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.newsListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(true);

        //kasih data news ke NewsListAdapter
        newsListAdapter = new NewsListAdapter(getContext(), newsList);

        recyclerView.setAdapter(newsListAdapter);

        return view;
    }


}
