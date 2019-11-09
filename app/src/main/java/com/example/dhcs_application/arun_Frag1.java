package com.example.dhcs_application;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class arun_Frag1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView= inflater.inflate(R.layout.arun_frag1_layout,container,false);
        //LinearLayout layout = view.findViewById(R.id.rootcontainer);
//        Spinner spinner = view.findViewById(R.id.planets_spinner);
//        String[] items = new String[]{"Rahul","Lesson 1 : 9/10","Lesson 2 : 10/10","Lesson 3 : 8/10"};
//        com.example.dhcs_application.CustomAdapter adapter = new com.example.dhcs_application.CustomAdapter(getActivity(),android.R.layout.simple_spinner_dropdown_item,items,0);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setDropDownVerticalOffset(100);
//        spinner.setDropDownWidth(1600);
        //no. 2
//        Spinner spinner1 = new Spinner(getActivity());
//        String[] items1 = new String[]{"Sachin","Lesson 1 : 9/10","Lesson 2 : 10/10","Lesson 3 : 8/10"};
//        com.example.dhcs_application.CustomAdapter adapter1 = new com.example.dhcs_application.CustomAdapter(getActivity(),android.R.layout.simple_spinner_dropdown_item,items1,0);
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner1.setAdapter(adapter1);
//        spinner1.setDropDownVerticalOffset(100);
//        spinner1.setDropDownWidth(1600);
//        layout.addView(spinner1);
//        //no.3
//        Spinner spinner2 = view.findViewById(R.id.planets_spinner2);
//        String[] items2 = new String[]{"Virat","Lesson 1 : 9/10","Lesson 2 : 10/10","Lesson 3 : 8/10"};
//        com.example.dhcs_application.CustomAdapter adapter2 = new com.example.dhcs_application.CustomAdapter(getActivity(),android.R.layout.simple_spinner_dropdown_item,items2,0);
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(adapter2);
//        spinner2.setDropDownVerticalOffset(100);
//        spinner2.setDropDownWidth(1600);

//        DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("lesson");
//
//        for(int i=1;i<=3;i++){
//            Lesson lesson = new Lesson(i,"title"+Integer.toString(i),"Crap");
//            lesson.user_name.add("Jeff");
//            lesson.user_name.add("Jeff2");
//            lesson.grades.add("9");
//            lesson.grades.add("10");
//            DatabaseReference iter = reff;
//            iter.child(Integer.toString(i)).setValue(lesson);
//        }

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("lesson");
        final ConstraintLayout lm = (ConstraintLayout) rootView.findViewById(R.id.lin);
        final LinearLayout lm1 = (LinearLayout) rootView.findViewById(R.id.linreal);
        final ArrayList<Lesson> list = new ArrayList<>();

        reff.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);


                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    list.add(ds.getValue(Lesson.class));
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
                    params.height=250;
                    btn1.setLayoutParams(params);
                    ll.addView(btn1);
                    lm1.addView(ll);

                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent lessonIntent = new Intent(getActivity().getApplicationContext(), edit_grades.class);
                            startActivity(lessonIntent);
                        }
                    });
                }
                Button button = new Button(rootView.getContext());
                button.setText("Add lesson");button.setVisibility(View.VISIBLE);
                LinearLayout ll1 = new LinearLayout(rootView.getContext());ll1.addView(button);
                lm1.addView(ll1);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent lessonIntent = new Intent(getActivity().getApplicationContext(), create_lesson.class);
                        startActivity(lessonIntent);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return rootView;
    }
}
