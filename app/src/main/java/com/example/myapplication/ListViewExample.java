package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ListViewExample extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private ListView listView;
    private ArrayList<String> countryArrayList, stateArrayList, stateArrayList1, stateArrayList2, cityArrayList, cityArrayList1, cityArrayList2;
    private ArrayAdapter<String> countrySpinnerAdapter,stateSpinnerAdapter,citySpinnerAdapter;
    private Spinner country_spinner;
    private Spinner state_spinner;
    private Spinner city_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ListView");



        listView = findViewById(R.id.listView);
        country_spinner = findViewById(R.id.country_spinner);
        state_spinner = findViewById(R.id.state_spinner);
        city_spinner = findViewById(R.id.city_spinner);

        countryArrayList = new ArrayList<>();
        countryArrayList.add("Country");
        countryArrayList.add("India");
        countryArrayList.add("America");
        countryArrayList.add("Canada");


        stateArrayList = new ArrayList<>();
        stateArrayList.add("State");
        stateArrayList.add("Punjab");
        stateArrayList.add("Himachal");
        stateArrayList.add("J & K");

        stateArrayList1 = new ArrayList<>();
        stateArrayList1.add("State");
        stateArrayList1.add("California");
        stateArrayList1.add("Florida");
        stateArrayList1.add("Texas");

        stateArrayList2 = new ArrayList<>();
        stateArrayList2.add("State");
        stateArrayList2.add("Alberta");
        stateArrayList2.add("British Columbia");
        stateArrayList2.add("Manitoba");



        cityArrayList = new ArrayList<>();
        cityArrayList.add("City");
        cityArrayList.add("Ludhiana");
        cityArrayList.add("Moga");
        cityArrayList.add("Amritsar");
        cityArrayList.add("Jalandhar");

        cityArrayList1 = new ArrayList<>();
        cityArrayList1.add("City");
        cityArrayList1.add("Los Angeles");
        cityArrayList1.add("San Francisco");
        cityArrayList1.add("San Diego");
        cityArrayList1.add("Fresno");

        cityArrayList2 = new ArrayList<>();
        cityArrayList2.add("City");
        cityArrayList2.add("Calgary");
        cityArrayList2.add("Edmonton");
        cityArrayList2.add("Cold Lake");
        cityArrayList2.add("Camrose");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,countryArrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) ->
        {
            Toast.makeText(this, " Clicked on "+arrayAdapter.getItem(i), Toast.LENGTH_SHORT).show();

        });

        countrySpinnerAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,countryArrayList);

        country_spinner.setAdapter(countrySpinnerAdapter);

        country_spinner.setOnItemSelectedListener(this);
        state_spinner.setOnItemSelectedListener(this);
        city_spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {


        switch (adapterView.getId())
        {
            case R.id.country_spinner:

                String country = adapterView.getItemAtPosition(i).toString();
                switch (country)
                {
                    case "India":
                        state_spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,stateArrayList));
                        break;
                    case "America":
                        state_spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,stateArrayList1));
                        break;
                    case "Canada":
                        state_spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,stateArrayList2));
                        break;
                }
                break;

            case R.id.state_spinner:

                String state = adapterView.getItemAtPosition(i).toString();
                switch (state)
                {
                    case "Punjab":
                        city_spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,cityArrayList));
                        break;
                    case "California":
                        city_spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,cityArrayList1));
                        break;
                    case "Alberta":
                        city_spinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,cityArrayList2));
                        break;
                }
                break;

            case R.id.city_spinner:

                String city = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(this, city, Toast.LENGTH_SHORT).show();
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
