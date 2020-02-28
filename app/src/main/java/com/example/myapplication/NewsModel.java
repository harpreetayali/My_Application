package com.example.myapplication;

public class NewsModel
{
    private String title,description,urlToImage;

    public NewsModel(String title, String description, String urlToImage)
    {
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;
    }

    public String getTitle()
    {
        return title;
    }


    public String getDescription()
    {
        return description;
    }

    public String getUrlToImage()
    {
        return urlToImage;
    }

}
