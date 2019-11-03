package com.example.dhcs_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profilepage extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    DatabaseReference dbusers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
        final TextView welcome=(TextView)findViewById(R.id.Welcome_text);
        Button explore =(Button)findViewById(R.id.explore);
        Button view_courses = (Button)findViewById(R.id.view);
        Button create_courses=(Button)findViewById(R.id.create);
        dbusers = FirebaseDatabase.getInstance().getReference("users");
        String user_id= FirebaseAuth.getInstance().getCurrentUser().getUid();
        dbusers.child(user_id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if(user==null){
                    System.out.println("\n\nuser=null\n\n");
                    return;
                }
                String str = user.firstname;
                welcome.setText(str);
            }
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(profilepage.this,explore_map.class);
                startActivity(loginIntent);
            }
        });
        view_courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myskillspageIntent = new Intent(profilepage.this,myskillspage.class);
                startActivity(myskillspageIntent);
            }
        });
        create_courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create_course_Intent = new Intent(profilepage.this,create_course.class);
                startActivity(create_course_Intent);
            }
        });
    }

}
