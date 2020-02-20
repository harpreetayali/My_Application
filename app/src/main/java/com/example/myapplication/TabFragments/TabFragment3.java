package com.example.myapplication.TabFragments;


import android.Manifest;

import android.app.SearchManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.myapplication.ContactAdapter;
import com.example.myapplication.FastScrollRecyclerViewItemDecoration;
import com.example.myapplication.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment3 extends Fragment {

    private RecyclerView recyclerView;
    private SearchManager searchManager;
    private SearchView searchView;
    private Button contact_list_btn;
    private HashMap<String, Integer> mapIndex;
    private ContactAdapter contactAdapter;
    private ArrayList<String> StoreContacts;
    private Cursor cursor;
    private String name, phonenumber;
    public static final int RequestPermissionCode = 1;

    @Override
    public void onRequestPermissionsResult(int requestCode, String per[], int[] PResult) {

        switch (requestCode) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(getActivity(), "Permission Granted, Now your application can access CONTACTS.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(getActivity(), "Permission Canceled, Now your application cannot access CONTACTS.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }

    public TabFragment3() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_fragment3, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_contact);

        searchView = view.findViewById(R.id.action_search);
        searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);

        contact_list_btn = view.findViewById(R.id.show_data);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        StoreContacts = new ArrayList<>();

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CONTACTS}, RequestPermissionCode);
        } else {

            getContactsIntoArrayList();
            calculateIndexesForName(StoreContacts);
            contactAdapter = new ContactAdapter(StoreContacts, mapIndex, getActivity());
            recyclerView.setAdapter(contactAdapter);

            FastScrollRecyclerViewItemDecoration decoration = new FastScrollRecyclerViewItemDecoration(getActivity());
            recyclerView.addItemDecoration(decoration);
            recyclerView.setItemAnimator(new DefaultItemAnimator());

        }

        contact_list_btn.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), contactAdapter.getSelectedContacts().toString(), Toast.LENGTH_SHORT).show();
        });


        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search Contact");
        searchView.setBackgroundColor(Color.WHITE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                contactAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                contactAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater)
//    {
//        inflater.inflate(R.menu.search_menu,menu);
//
//
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item)
//    {
//        int id = item.getItemId();
//
//
//        if (id == R.id.action_search) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    public void getContactsIntoArrayList() {

        cursor = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");

        while (cursor.moveToNext()) {

            name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            StoreContacts.add(name + " " + ":" + " " + phonenumber);
        }

        cursor.close();

    }

    private void calculateIndexesForName(ArrayList<String> contacts) {
        mapIndex = new LinkedHashMap<>();

        for (int i = 0; i < contacts.size(); i++) {
            String name = contacts.get(i);
            String index = name.substring(0, 1);
            index = index.toUpperCase();

            if (!mapIndex.containsKey(index)) {
                mapIndex.put(index, i);
            }
        }
    }
//    private void displayIndex() {
//        LinearLayout indexLayout = getActivity().findViewById(R.id.side_index);
//
//        TextView textView;
//        List<String> indexList = new ArrayList<>(mapIndex.keySet());
//        for (String index : indexList) {
//            textView = (TextView) getLayoutInflater().inflate(
//                    R.layout.side_index_item, null);
//            textView.setText(index);
//            textView.setOnClickListener(view -> {
//                TextView selectedIndex = (TextView) view;
//                recyclerView.scrollToPosition(mapIndex.get(selectedIndex.getText()));
//                recyclerView.scrollBy(0,0);
//
//
//
//            });
//            indexLayout.addView(textView);
//        }
//    }

}
