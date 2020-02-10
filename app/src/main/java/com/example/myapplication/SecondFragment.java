package com.example.myapplication;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
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

import java.security.Permission;


/**
 * .A simple {@link Fragment} subclass
 */
public class SecondFragment extends Fragment {
    private LocationManager locationManager;
    private LocationListener locationListener;
    private Double lat,lang;
    private GoogleMap mMap;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 123) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {

                    if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 1, locationListener);
                        Log.i("error3","occured");
                    }


            }
        }
        Log.i("error4","occured");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        Button btn = rootView.findViewById(R.id.changeMap);
        Button btn2 = rootView.findViewById(R.id.changeBackMap);


        btn.setOnClickListener((View v) -> {

            LatLng latLng = new LatLng(30.9010, 75.8573);
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Ludhiana"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        });

        btn2.setOnClickListener((View v) -> {
            LatLng latLng = new LatLng(lat, lang);
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Location"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(googleMap ->
            {
                mMap = googleMap;

                locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location)
                    {
                        Log.i("yess",location.getLatitude()+"");

                        lat = location.getLatitude();
                        lang = location.getLongitude();

                        mMap.clear();
                        mMap.animateCamera(CameraUpdateFactory.zoomOut());
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 16));
                        mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("Location"));

                    }

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {

                    }

                    @Override
                    public void onProviderEnabled(String s) {

                    }

                    @Override
                    public void onProviderDisabled(String s) {

                    }
                };

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP_MR1)
                {
                    if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 1, locationListener);

                    }
                    else
                        Log.i("error1","occured");
                }
                else
                {
                    if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
                    }
                    else
                    {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 1, locationListener);
                        Log.i("error2","occured");

                        Location lastloc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


                        if (lastloc != null)
                        {
                            lat = lastloc.getLatitude();
                            lang = lastloc.getLongitude();
                            LatLng latLng = new LatLng(lastloc.getLatitude(),lastloc.getLongitude());
                            mMap.addMarker(new MarkerOptions().position(latLng).title("Your Location"));
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16));
                        }

                    }
                }

            });

        }

        return rootView;
    }

}
