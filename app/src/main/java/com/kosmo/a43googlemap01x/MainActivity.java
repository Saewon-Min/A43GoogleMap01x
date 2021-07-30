package com.kosmo.a43googlemap01x;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

// AIzaSyA_XHJ5qgqMvQUyWGbEXa-jRx1KY865qjQ => 구글 API
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "iKosmo";

    SupportMapFragment mapFragment;
    GoogleMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                Log.d(TAG,"GoogleMap is Ready ");
                map = googleMap;
            }
        });

        try {
            MapsInitializer.initialize(this);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //37.491717, 126.919142
    public void onBtnClicked(View v){
        LatLng curPoint = new LatLng(37.491717, 126.919142);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint,15));
    }

}