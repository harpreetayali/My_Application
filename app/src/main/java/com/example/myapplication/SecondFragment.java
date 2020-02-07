package com.example.myapplication;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private GoogleMap mMap;
    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_second, container, false);
            Button btn = rootView.findViewById(R.id.changeMap);
            Button btn2 = rootView.findViewById(R.id.changeBackMap);

            btn.setOnClickListener((View v)->{

                LatLng latLng = new LatLng(30.9010, 75.8573);
                mMap.animateCamera(CameraUpdateFactory.zoomOut());
                mMap.addMarker(new MarkerOptions().position(latLng).title("Ludhiana"));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
            });

            btn2.setOnClickListener((View v)->{
                LatLng latLng = new LatLng(30.713440, 76.730190);
                mMap.animateCamera(CameraUpdateFactory.zoomOut());
                mMap.addMarker(new MarkerOptions().position(latLng).title("Location"));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
            });

            SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(googleMap ->
            {
                mMap = googleMap;

                googleMap.animateCamera(CameraUpdateFactory.zoomOut());
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(30.713440,76.730190),16));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(30.713440,76.730190)).title("Location"));
            });

        }

        return rootView;
    }

}
