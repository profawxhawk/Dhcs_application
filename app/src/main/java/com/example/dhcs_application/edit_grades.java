package com.example.dhcs_application;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

import com.example.dhcs_application.Lesson;
import com.example.dhcs_application.R;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dhcs_application.ui.main.SectionsPagerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class edit_grades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_grade_layout);



        //###########################################
        final int cur_lesson = 0;//shahid the essence!!!!
//#########################################################


        final DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("lesson");
        final ArrayList<Lesson> list = new ArrayList<>();
        final LinearLayout lm1 = (LinearLayout) findViewById(R.id.noreal);
        final Button button = new Button(getApplicationContext());
        reff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);


                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    list.add(ds.getValue(Lesson.class));
                }
                for(int i=0;i<list.size();i++)System.out.println(list.get(i).name);
                for(int i=0;i<list.get(cur_lesson).grades.size();i++){
                    LinearLayout ll = new LinearLayout(getApplicationContext());
                    ll.setOrientation(LinearLayout.HORIZONTAL);
                    TextView textView = new TextView(getApplicationContext());
                    textView.setText(list.get(cur_lesson).user_name.get(i));
                    textView.setVisibility(View.VISIBLE);
                    ll.addView(textView);
                    EditText editText = new EditText(getApplicationContext());
                    editText.setText(list.get(cur_lesson).grades.get(i));
                    System.out.println(list.get(cur_lesson).grades.get(i));
                    editText.setId(i+1);editText.setVisibility(View.VISIBLE);
                    ll.addView(editText);
                    lm1.addView(ll);
                }

                LinearLayout ll = new LinearLayout(getApplicationContext());
                ll.setOrientation(LinearLayout.HORIZONTAL);
               // button = new Button(getApplicationContext());
                button.setText("Update");button.setVisibility(View.VISIBLE);
                ll.addView(button);lm1.addView(ll);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(list.get(cur_lesson).grades.size());
                Lesson tocpy = list.get(cur_lesson);
                Lesson lesson = new Lesson(tocpy.lesson_id,tocpy.name,tocpy.content);
                lesson.user_name = tocpy.user_name;
                for(int i=0;i<lm1.getChildCount()-1;i++){
                    LinearLayout l = (LinearLayout) lm1.getChildAt(i);
                    lesson.grades.add(((EditText)l.getChildAt(1)).getText().toString());
                    System.out.println(lesson.grades.get(i));
                }
                reff.child(Integer.toString(lesson.lesson_id)).setValue(lesson);
            }
        });
    }
}