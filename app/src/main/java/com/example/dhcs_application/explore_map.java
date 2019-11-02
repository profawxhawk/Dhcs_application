package com.example.dhcs_application;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class explore_map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    DatabaseReference dbcourses;
    List<Course> c2=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        dbcourses = FirebaseDatabase.getInstance().getReference("Courses");
        Course c1=new Course("bpro", 1,1000,"hi",3-33.852,151.211);
        dbcourses.child("1").setValue(c1);
        dbcourses.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue();
                if(value instanceof List) {
                    List<Object> values = (List<Object>) value;
                    for(int i=0;i<values.size();i++) {
                        Log.d("stats", values.get(i).toString());
                        if (values.get(i) != null) {
//                            append(values.get(i).Lat, values.get(i).Log, mMap);
                        }
                    }


                };

            }
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
//        for (int i=0;i<c2.size();i++){
//            if (c2.get(i)!=null) {
//                Course c=c2.get(i);

//            }
//        }
    }
    public void append(double lat,double log,GoogleMap googleMap){
        LatLng sydney = new LatLng(lat,log);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
