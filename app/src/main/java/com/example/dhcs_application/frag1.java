package com.example.dhcs_application;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
//import com.github.clans.fab.FloatingActionButton
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.widget.Button;


import android.app.ActionBar.LayoutParams;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.support.design.widget.FloatingActionButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.widget.Toast;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class frag1 extends Fragment {

    int id_assigning;

    public frag1(){
        id_assigning=0;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View rootView = inflater.inflate(R.layout.frag1_layout, container, false);

//        rootView.setContentView(R.layout.activity_main);
//        rootView.findViewById(R.id.)
        final ConstraintLayout lm = (ConstraintLayout) rootView.findViewById(R.id.lin);
        final LinearLayout lm1 = (LinearLayout) rootView.findViewById(R.id.linreal);
        final DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("Courses");
        final ArrayList<Course> list = new ArrayList<>();
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);


                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    list.add(ds.getValue(Course.class));
                }
                for(int i=0;i<list.size();i++)System.out.println(list.get(i).name);
                for(int i=0;i<list.size();i++){
                    LinearLayout ll = new LinearLayout(rootView.getContext());
                    ll.setOrientation(LinearLayout.HORIZONTAL);
                    final Button btn1 = new Button(rootView.getContext());
                    btn1.setId(i);
                    btn1.setText(list.get(i).name);
                    btn1.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    params.width = 1100;
                    params.height=500;
                    btn1.setLayoutParams(params);
                    ll.addView(btn1);
                    lm1.addView(ll);
                    btn1.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent lessonIntent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                        startActivity(lessonIntent);
                    }
                });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        rootView.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
//            @Override
//            public void onClick(View view) {
//                System.out.println("\n\nhola1\n\n");
//                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//                LinearLayout ll = new LinearLayout(view.getContext());
//                ll.setOrientation(LinearLayout.HORIZONTAL);
//                final Button btn1 = new Button(view.getContext());
//                btn1.setId(id_assigning);
//                id_assigning++;
//                String s=getActivity().getIntent().getStringExtra("EdiTtEXTvALUE");
//                btn1.setText(s);
//                btn1.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
//                params.width = 1100;
//                params.height=500;
//                // btn.setBackgroundResource(R.drawable.chess);
//                btn1.setBackgroundResource(R.drawable.chess4);
//                btn1.setLayoutParams(params);
//                btn1.setTextSize(30);
//                final int index = 1;
//                ll.addView(btn1);
//                lm1.addView(ll);
////                lm.addView(btn);
//                System.out.println("\n\nhola2\n\n");
//                btn1.setOnClickListener(new OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent lessonIntent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
//                        startActivity(lessonIntent);
//                    }
//                });
//                System.out.println("\n\nhola4\n\n");
//            }
//        });
//        System.out.println("\n\nhola\n\n");




//        return inflater.inflate(R.layout.frag1_layout, container, false);
        FloatingActionButton b= rootView.findViewById(R.id.createpagebtn);
        b.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                Intent coursepageIntent = new Intent(getActivity().getApplicationContext(), create_course.class);
                startActivity(coursepageIntent);


            }
        });

        return rootView;



    }
}
