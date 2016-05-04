package com.example.luiseps.colombia_turismo;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class BarKsaClub extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private UiSettings mysettins;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bar_ksa_club, container, false);

       // FragmentManager fm = getChildFragmentManager();
        //SupportMapFragment mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.mapKsa);

        /*mapFragment.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(GoogleMap googleMap) {
                // TODO Auto-generated method stub
                mMap = googleMap;
                mysettins = mMap.getUiSettings();
                mysettins.setZoomControlsEnabled(true);
                // Add a marker in Sydney and move the camera
                LatLng med = new LatLng(10.4755506, -73.24481589999999);
                mMap.addMarker(new MarkerOptions().position(med).title("Bar KSA CLUB"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom((med), 10));

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                mMap.setMyLocationEnabled(true);
            }
        });*/
        //retornaremos la View creada
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    @Override
    public void onDestroyView() {


        super.onDestroyView();
    }
}
