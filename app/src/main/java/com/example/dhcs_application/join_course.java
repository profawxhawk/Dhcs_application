package com.example.dhcs_application;

import android.content.Intent;
import android.os.Bundle;

import com.example.dhcs_application.ui.main.arun_SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dhcs_application.ui.main.SectionsPagerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class join_course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_profile);
        final String sessionId = getIntent().getStringExtra("EXTRA_SESSION_ID");
        System.out.println("Join Course id: " + sessionId);

        Button b5 = findViewById(R.id.join_button);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference dbUsers = FirebaseDatabase.getInstance().getReference().child("users");
                final String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                final ArrayList<User> modified = new ArrayList<User>();
                System.out.println("joining bro");
//        User user2 = dbUsers.child(user_id);
                dbUsers.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        User user = dataSnapshot.getValue(User.class);
//                        if(user==null){
//                            System.out.println("\n\nuser=null\n\n");
//                            return;
//                        }
//                        System.out.println(user.Enrolled_course_list + " enroll ");
////                        if( )
//                        System.out.println(sessionId + " sesionid ");
//                        if(user.Enrolled_course_list == null){
//                            user.Enrolled_course_list = new ArrayList<>();
//                        }
//                        user.Enrolled_course_list.add(Integer.parseInt(sessionId));
//                        System.out.println(user.Enrolled_course_list.get(0)+ " userid " + user_id+" "+ user.id);
//                        dbUsers.child(user_id).setValue(user);
//                        System.out.println("joined");
//
//                        Intent myskillsIntent = new Intent(join_course.this,myskillspage.class);
//                        startActivity(myskillsIntent);
                        User usertemp = null;
                        for(DataSnapshot ds : dataSnapshot.getChildren()){
                            usertemp = ds.getValue(User.class);
                            if(usertemp.id.equals(user_id)){
                                break;
                            }
                        }
                        if(usertemp.Enrolled_course_list == null){
                            usertemp.Enrolled_course_list = new ArrayList<Integer>();
                        }
                        usertemp.Enrolled_course_list.add(Integer.parseInt(sessionId));

                        System.out.println(user_id + " " + usertemp.id + " " + usertemp.Enrolled_course_list.get(0));
                        int sz = usertemp.Enrolled_course_list.size()+1;

                        dbUsers.child(usertemp.id).child("Enrolled_course_list").child(Integer.toString(sz)).setValue(usertemp.Enrolled_course_list.get(0));

                        Intent myskillsIntent = new Intent(join_course.this,myskillspage.class);
                        startActivity(myskillsIntent);


                    }
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });

            }
        });


    }
}