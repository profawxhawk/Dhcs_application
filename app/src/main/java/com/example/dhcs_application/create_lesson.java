package com.example.dhcs_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class create_lesson extends AppCompatActivity {


    Lesson entry;

    protected String get_lesson(){
        //pass lesson number from previous activity
        return new String("1");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_lesson);
        final EditText title = (EditText)findViewById(R.id.editText2);
        final EditText time = (EditText)findViewById(R.id.editText3);
        final EditText content = (EditText)findViewById(R.id.editText5);
        Button button = (Button)findViewById(R.id.submit);

        final DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("lesson");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title_send = title.getText().toString();
                String time_send = time.getText().toString();
                String content_send=content.getText().toString();
                //DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference().child("Courses");


                //entry.setTime(time_send);
                //entry.setTitle(title_send);
                final DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("lesson");
                reff.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        entry = new Lesson(((int)dataSnapshot.getChildrenCount()+1),title.getText().toString(),content.getText().toString());

                        for(int i=0;i<2;i++)entry.grades.add("0");
                        for(int i=0;i<2;i++)entry.user_name.add("Dude"+(i+1));
                        System.out.println("WE made it");
                        reff.child(Integer.toString((int)dataSnapshot.getChildrenCount()+1)).setValue(entry);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                //reff.child(Integer.toString(get_last())).setValue(entry);

            }
        });
    }
}
