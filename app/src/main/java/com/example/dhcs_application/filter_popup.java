package com.example.dhcs_application;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class filter_popup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
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
                    skillzzz.add(currCourse.name);
                    System.out.println("prrn: " + currCourse.name);
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
