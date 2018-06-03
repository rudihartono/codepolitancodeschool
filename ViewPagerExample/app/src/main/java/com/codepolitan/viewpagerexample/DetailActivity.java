package com.codepolitan.viewpagerexample;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView title, author;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle data = getIntent().getExtras();

        final News news = data.getParcelable("NEWS");

        title = (TextView)findViewById(R.id.titleNewsDetail);
        author = (TextView)findViewById(R.id.authorNameDetail);
        imageView = (ImageView)findViewById(R.id.imageNewsDetail);

        title.setText(news.getTitle());
        author.setText(news.getAuthor_name());
        Picasso.with(this).load(news.thumbnail).into(imageView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.openLinkBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("URI", news.getLink());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(news.getLink()));
                startActivity(intent);

            }
        });
    }
}
