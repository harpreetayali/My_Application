package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{



    private RecyclerViewClickListener mListener;


    ArrayList<RecyclerItemModel> mArrayList;

    public MyAdapter(ArrayList<RecyclerItemModel> arrayList, RecyclerViewClickListener clickListener)
    {
        mListener = clickListener;
        mArrayList = arrayList;

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private RecyclerViewClickListener mListener;
        private TextView textView;
        private ImageView imageView;
        private Button delete_recycler_item;

        public MyViewHolder(View v,RecyclerViewClickListener clickListener)
        {
            super(v);
            mListener = clickListener;
            v.setOnClickListener(this);
            textView = v.findViewById(R.id.recycler_view_tv);
            imageView = v.findViewById(R.id.recycler_view_IV);
            delete_recycler_item = v.findViewById(R.id.delete_recycler_item);

        }

        @Override
        public void onClick(View view)
        {
            mListener.onClick(view,getAdapterPosition());

        }

        public void setTextView(String text,int position)
        {
           textView.setText(text);
           textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
           if (position%2==0)
                textView.setTextColor(Color.parseColor("#00574B"));
           else
               textView.setTextColor(Color.parseColor("#ff0000"));
        }

        public void setImageView(int imageId)
        {
            imageView.setImageResource(imageId);
        }


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View v = layoutInflater.inflate(R.layout.custom_list_items,parent,false);

//        v.setOnClickListener((View view)-> {
//            Toast.makeText(parent.getContext(),"Item clicked", Toast.LENGTH_SHORT).show();
//            }
//        );

        return new MyViewHolder(v,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        RecyclerItemModel recyclerItemModel = mArrayList.get(position);

        holder.setTextView(recyclerItemModel.getItem() +" "+ position,position);

        holder.setImageView(recyclerItemModel.getImage());
        holder.delete_recycler_item.setOnClickListener(view ->
        {
            mArrayList.remove(position);


            notifyItemRemoved(position);
            notifyItemRangeChanged(position,mArrayList.size());

        });

    }

    @Override
    public int getItemCount() {
        return mArrayList.size() ;
    }


}
