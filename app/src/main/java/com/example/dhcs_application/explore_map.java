package com.example.dhcs_application;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
class MarkerInfo {
    public String title;
    public String subtitle;
    public Course course;
}
public class explore_map extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    DatabaseReference dbcourses;
    List<Course> c2=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_map);
        Button filter=(Button)findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(explore_map.this,filter_popup.class));
            }


        });
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
        mMap.setInfoWindowAdapter(new InfoWindowCustom(this));
        mMap.setOnInfoWindowClickListener(this);
        dbcourses = FirebaseDatabase.getInstance().getReference("Courses");
        dbcourses.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
//                setContentView(R.layout.popup);
//                double price_min=Double.parseDouble(((EditText)findViewById(R.id.price_min)).getText().toString());
//                double price_max=Double.parseDouble(((EditText)findViewById(R.id.price_max)).getText().toString());
//                double distance_min=Double.parseDouble(((EditText)findViewById(R.id.distance_min)).getText().toString());
//                double distance_max=Double.parseDouble(((EditText)findViewById(R.id.distance_max)).getText().toString());
//                double ratings_min=Double.parseDouble(((EditText)findViewById(R.id.ratings_min)).getText().toString());
//                double ratings_max=Double.parseDouble(((EditText)findViewById(R.id.ratings_max)).getText().toString());
//                setContentView(R.layout.activity_explore_map);
                for(DataSnapshot ds: dataSnapshot.getChildren()) {
                    Course currCourse = ds.getValue(Course.class);
                    if(filters.getInstance()!=null) {
                        System.out.println("The filters" + filters.getInstance().price_min );
                        if (currCourse.weeklyFees <= filters.getInstance().price_max && currCourse.weeklyFees >= filters.getInstance().price_min) {
                            double x = currCourse.getLat();
                            double y = currCourse.getLon();
                            append(x, y, mMap,currCourse);
                        }
                    }
                }


            }
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    public void append(double lat,double log,GoogleMap googleMap,Course currCourse){
        LatLng pos = new LatLng(lat,log);
        String description = "Description : "+currCourse.description+"\n"+"Weekly Fees : "+currCourse.weeklyFees+"\n";
        MarkerInfo m1info=new MarkerInfo();
        m1info.course=currCourse;
        m1info.title="Name: "+currCourse.name+'\n';
        m1info.subtitle=description;
        Gson gson = new Gson();
        String markerInfoString = gson.toJson(m1info);
        Marker m=googleMap.addMarker(new MarkerOptions().position(pos).snippet(markerInfoString));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
    }
    @Override
    public void onInfoWindowClick(Marker marker) {
        Gson gson = new Gson();
        final MarkerInfo aMarkerInfo = gson.fromJson(marker.getSnippet(), MarkerInfo.class);
        Toast.makeText(this, "Welcome Sucka"+aMarkerInfo.course.name,
                Toast.LENGTH_SHORT).show();
        Intent joincourse_intent = new Intent(explore_map.this,join_course.class);
        joincourse_intent.putExtra("EXTRA_SESSION_ID", aMarkerInfo.course.courseID);
        startActivity(joincourse_intent);
    }
}
