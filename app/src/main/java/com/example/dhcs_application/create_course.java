package com.example.dhcs_application;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class create_course extends AppCompatActivity {

    FirebaseDatabase firebaseDB;
    DatabaseReference dbCourses;
    int numCourse;
    //ArrayList<Integer> currID = new ArrayList<>();
    int currID = 0;

    //Check Resume/Picture/Lecture Upload

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_course);
        final EditText nameText1 = (EditText) findViewById(R.id.nameText);
        final EditText weeklyFeesText1 =  (EditText) findViewById(R.id.weeklyFeesText);
        final EditText descriptionText1 = (EditText) findViewById(R.id.descriptionText);
        Button submitButton1 = (Button) findViewById(R.id.submitButton);

        firebaseDB = FirebaseDatabase.getInstance();

        //check if you have to use firebaseDB or FirebaseDatabase everywhere

        dbCourses = FirebaseDatabase.getInstance().getReference("Courses");

        submitButton1.setOnClickListener(new View.OnClickListener() {

            private int check_empty(String k, String j){
                if(TextUtils.isEmpty(k)){
                    Toast.makeText(getApplicationContext(),"Please Enter " + j,Toast.LENGTH_SHORT).show();
                    return 0;
                }
                return 1;
            }


            private void registerCourse(){
                final String nameText = nameText1.getText().toString().trim();
                final String weeklyFeesText =  weeklyFeesText1.getText().toString().trim();
                final String descriptionText = descriptionText1.getText().toString().trim();

                dbCourses = FirebaseDatabase.getInstance().getReference("Courses");

                String nameValue = nameText.trim();
                double feesValue = 0;
                try {
                    feesValue = Double.parseDouble(weeklyFeesText.toString().trim());
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }

                String descriptionValue = descriptionText.toString().trim();

                Course lastCourse = new Course();
                //final ArrayList<Course> courseList = new ArrayList<>();

                dbCourses.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds: dataSnapshot.getChildren()){
                            try {
//                                //courseList.add(ds.getValue(Course.class));
                                currID = (Integer.parseInt(ds.getValue(Course.class).courseID));
                                System.out.println("woahwoahwoahwoahgfhdghfdgd    " + ds.getValue(Course.class).courseID);
                            }
                            catch(Exception e){

                            }


                        }

                        int instructorID = 999;
                        double latitude = 0.000;
                        double longitude = 1.1111;
                        double feesValue = Double.parseDouble(weeklyFeesText);
                        Course course = new Course(nameText, instructorID, feesValue, descriptionText, latitude, longitude);
                        System.out.println("CURRRRRR IDDDDDD " + currID);
                        course.courseID = "" + (currID + 1);
                        dbCourses.child(course.courseID).setValue(course);
                        dbCourses = FirebaseDatabase.getInstance().getReference("Courses");

                        Toast.makeText(getApplicationContext(),"Course Creation Successful",Toast.LENGTH_SHORT).show();
                        finish();
                        Intent profilePageIntent = new Intent(create_course.this,profilepage.class);
                        startActivity(profilePageIntent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


//                dbCourses.child(course.courseID).addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        Course course = dataSnapshot.getValue(Course.class);
//                        if(course == null){
//                            System.out.println("\n\nuser=null\n\n");
//                            return;
//                        }
//                        Toast.makeText(getApplicationContext(),"Course Creation Successful",Toast.LENGTH_SHORT).show();
//                        finish();
//                    }
//                    public void onCancelled(DatabaseError databaseError) {
//                        System.out.println("The read failed: " + databaseError.getCode());
//                    }
//                });



            }

            @Override
            public void onClick(View view) {
                registerCourse();
            }

        });

    }

}