package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

class AsyncFetchNews extends AsyncTask<String, Void, Boolean>
{
    private Context ctx;
    private InputStream inputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    private String resp;
    private JSONArray jsonTitleArray;
    private ArrayList<NewsModel> listNews = new ArrayList<>();
    private RecyclerView recyclerViewNews;
    private NewsAdapter newsAdapter;

    public AsyncFetchNews(Context ctx, RecyclerView recyclerViewNews)
    {
        this.ctx = ctx;
        this.recyclerViewNews = recyclerViewNews;
    }

    @Override
    protected Boolean doInBackground(String... strings)
    {
        String line;
        String result = "";

        try
        {
            URL url = new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.connect();
            inputStream = conn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            while (true) {
                line = bufferedReader.readLine();
                if (line == null)
                    break;

                result += line;

            }


            Log.i("Newsss", result);

            JSONObject jsonObject =new JSONObject(result);
            JSONArray articles = jsonObject.optJSONArray("articles");

            for (int i=0;i<articles.length();i++)
            {
                JSONObject article = articles.optJSONObject(i);
                String title = article.getString("title");
                String description = article.getString("description");
                String urlToImage = article.getString("urlToImage");

                listNews.add(new NewsModel(title,description,urlToImage));

                Log.i("Title",title);
            }


            return true;

        }
        catch (Exception e)
        {
            Log.i("exxx",e.toString());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean)
    {

        Toast.makeText(ctx,"Response : "+ resp+aBoolean, Toast.LENGTH_SHORT).show();
        newsAdapter = new NewsAdapter(listNews);
        recyclerViewNews.setAdapter(newsAdapter);
        try
        {
//            Log.i("Articles",jsonTitleArray.toString());
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        super.onPostExecute(aBoolean);
    }
}
