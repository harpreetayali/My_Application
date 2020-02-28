package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.http.Url;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;

import java.net.URL;

public class AsynctaskExample extends AppCompatActivity
{
    Button btn_get_news;
    RecyclerView recyclerViewNews;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask_example);

        btn_get_news = findViewById(R.id.btn_get_news);
        recyclerViewNews = findViewById(R.id.recycler_view_news);
        recyclerViewNews.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerViewNews.setLayoutManager(layoutManager);

        btn_get_news.setOnClickListener(view ->
        {
            AsyncFetchNews asyncFetchNews = new AsyncFetchNews(this,recyclerViewNews);
            asyncFetchNews.execute("\n" +
                    "\n" +
                    "http://newsapi.org/v2/everything?q=bitcoin&from=2020-01-28&sortBy=publishedAt&apiKey=564a3df6f4df49248cdf8745f02b01cf");
        });



    }


}
