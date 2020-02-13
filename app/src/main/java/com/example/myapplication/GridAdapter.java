package com.example.myapplication;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder>
{



    private RecyclerViewClickListener mListener;


    ArrayList<RecyclerItemModel> mArrayList;

    public GridAdapter(ArrayList<RecyclerItemModel> arrayList, RecyclerViewClickListener clickListener)
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
            textView = v.findViewById(R.id.grid_recycler_view_tv);
            imageView = v.findViewById(R.id.grid_recycler_view_IV);
            delete_recycler_item = v.findViewById(R.id.grid_delete_recycler_item);

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
    public GridAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View v = layoutInflater.inflate(R.layout.grid_recycler_card,parent,false);

        return new GridAdapter.MyViewHolder(v,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.MyViewHolder holder, int position)
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
