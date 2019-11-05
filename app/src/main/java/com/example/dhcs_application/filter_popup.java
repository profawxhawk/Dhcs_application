package com.example.dhcs_application;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
class filters {
    private static filters mInstance= null;

    public double price_min;    public double price_max;
    public double distance_min;    public double distance_max;

    public double ratings_min;    public double ratings_max;

    protected filters(){}

    public static synchronized filters getInstance() {
        if(null == mInstance){
            mInstance = new filters();
        }
        return mInstance;
    }
}
public class filter_popup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        Button filter=(Button)findViewById(R.id.save);
        filter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                filters.getInstance().price_min=Double.parseDouble(((EditText)findViewById(R.id.price_min)).getText().toString());;
                filters.getInstance().price_max=Double.parseDouble(((EditText)findViewById(R.id.price_max)).getText().toString());
                filters.getInstance().distance_min=Double.parseDouble(((EditText)findViewById(R.id.distance_min)).getText().toString());
                filters.getInstance().distance_max=Double.parseDouble(((EditText)findViewById(R.id.distance_max)).getText().toString());
                filters.getInstance().ratings_min=Double.parseDouble(((EditText)findViewById(R.id.ratings_min)).getText().toString());
                filters.getInstance().ratings_max=Double.parseDouble(((EditText)findViewById(R.id.ratings_max)).getText().toString());
                startActivity(new Intent(filter_popup.this,explore_map.class));
            }


        });
        DisplayMetrics dm =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int w=dm.widthPixels;
        int h=dm.heightPixels;
        getWindow().setLayout((int)(w*(0.8)),(int)(h*0.6));
        DatabaseReference dbcourses;
        final ArrayList<String> skillzzz = new ArrayList<String>();
        dbcourses = FirebaseDatabase.getInstance().getReference("Courses");
        dbcourses.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Course currCourse = ds.getValue(Course.class);
                    if(!skillzzz.contains(currCourse.name)) {
                        skillzzz.add(currCourse.name);
                        System.out.println("prrn: " + currCourse.name);
                    }
                }

                Spinner spinner = findViewById(R.id.planets_spinner);
                System.out.println("size matters: " + skillzzz.size()+1);
                String[] items = new String[skillzzz.size()+1];
                items[0]="Skillz";
                int index=1;
                for (String xstr : skillzzz){
                    items[index]=xstr;
                    index++;
                }
                com.example.dhcs_application.CustomAdapter adapter = new com.example.dhcs_application.CustomAdapter(filter_popup.this,android.R.layout.simple_spinner_dropdown_item,items,0);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setDropDownVerticalOffset(100);
                spinner.setDropDownWidth(1600);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
