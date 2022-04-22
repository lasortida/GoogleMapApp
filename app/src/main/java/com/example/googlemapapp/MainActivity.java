package com.example.googlemapapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.dynamic.SupportFragmentWrapper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap map;
    private static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        LatLng sydney = new LatLng(55.74353329723296, 37.681220546364784);
        map.addMarker(new MarkerOptions().position(sydney).title("SAMSUNG").draggable(true));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                map.addMarker(new MarkerOptions().position(latLng).title("marker number " + i).draggable(true));
                i++;
                Log.d("test", latLng.toString());
            }
        });
        map.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDrag(@NonNull Marker marker) {
                marker.setTitle(marker.getPosition().toString());

            }

            @Override
            public void onMarkerDragEnd(@NonNull Marker marker) {
                marker.setTitle(marker.getPosition().toString());
            }

            @Override
            public void onMarkerDragStart(@NonNull Marker marker) {
                marker.setTitle(marker.getPosition().toString());

            }
        });
    }
}