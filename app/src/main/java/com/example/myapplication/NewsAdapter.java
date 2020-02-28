package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>
{

    ArrayList<NewsModel> listNews;

    public NewsAdapter(ArrayList<NewsModel> listNews)
    {
        this.listNews = listNews;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.list_news_item,parent,false);

        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position)
    {
        NewsModel newsModel = listNews.get(position);

        holder.setTitle(newsModel.getTitle());
        holder.setDescritption(newsModel.getDescription());
        holder.setImageView(newsModel.getUrlToImage());

    }

    @Override
    public int getItemCount()
    {
        return listNews.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder
    {

        private ImageView imageView;
        private TextView tv_title,tv_description;

        public NewsViewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_news);
            tv_title = itemView.findViewById(R.id.title_news);
            tv_description = itemView.findViewById(R.id.description_news);

        }

        public void setTitle(String title)
        {
            tv_title.setText(title);
        }
        public void setDescritption(String descritption)
        {
            tv_description.setText(descritption);
        }
        public void setImageView(String urlToImage)
        {
            Glide.with(itemView).load(urlToImage).into(imageView);
        }

    }
}
