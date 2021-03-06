package com.example.myapplication.TabFragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MyAdapter;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerItemModel;
import com.example.myapplication.RecyclerViewClickListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment1 extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Toast t2;
    public TabFragment1() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_tab_fragment1, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<RecyclerItemModel> itemModels = new ArrayList<>();

        itemModels.add(new RecyclerItemModel("Item",R.drawable.android));
        itemModels.add(new RecyclerItemModel("Item",R.drawable.camera));
        itemModels.add(new RecyclerItemModel("Item",R.drawable.facebook));
        itemModels.add(new RecyclerItemModel("Item",R.drawable.google_plus));
        itemModels.add(new RecyclerItemModel("Item",R.drawable.android));
        itemModels.add(new RecyclerItemModel("Item",R.drawable.camera));
        itemModels.add(new RecyclerItemModel("Item",R.drawable.facebook));
        itemModels.add(new RecyclerItemModel("Item",R.drawable.google_plus));
        itemModels.add(new RecyclerItemModel("Item",R.drawable.android));
        itemModels.add(new RecyclerItemModel("Item",R.drawable.camera));
        itemModels.add(new RecyclerItemModel("Item",R.drawable.facebook));
        itemModels.add(new RecyclerItemModel("Item",R.drawable.google_plus));


        recyclerView = getActivity().findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        
        RecyclerViewClickListener clickListener = (view1, position) ->
        {
               t2 = new Toast(getActivity());
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast,getActivity().findViewById(R.id.custom_toast_layout));

            TextView tv1 = layout.findViewById(R.id.tv1);
            tv1.setText("Clicked on "+ position);

            t2.setView(layout);
            t2.setGravity(Gravity.BOTTOM,0,50);
            t2.setDuration(Toast.LENGTH_SHORT);
            t2.show();

        };



        mAdapter = new MyAdapter(itemModels,clickListener);


        recyclerView.setAdapter(mAdapter);



    }


}
