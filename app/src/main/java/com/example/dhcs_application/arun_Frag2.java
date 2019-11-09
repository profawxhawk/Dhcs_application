package com.example.dhcs_application;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class arun_Frag2 extends Fragment {
    private ArrayList<String> announcements = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view =  inflater.inflate(R.layout.arun_frag2_layout,container,false);
//        DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("Courses").child("1").child("announcement");
//
//        ListView list_ = view.findViewById(R.id.list_view);
//
//        System.out.println("hiya: " + getActivity()+"   "+android.R.layout.simple_list_item_1+"   "+announcements);
        final String Date_time_anouncement = "2019-03-11 17:41";
////        TextView tv = list_.addFooterView();
//        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,announcements);
//        list_.setAdapter(arrayAdapter);

        View view =  inflater.inflate(R.layout.temp_layout,container,false);
        DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("Courses").child("1").child("announcement");
        final LinearLayout ll = (LinearLayout)view.findViewById(R.id.lininhouse);
        final Context context = this.getContext();
        reff.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(String.class);
                announcements.add(value);
                TextView rowTextView = new TextView(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
                params.width = 1100;
                params.height=500;
                rowTextView.setLayoutParams(params);
//                rowTextView.setId(3);
//                rowTextView.setWidth();
                TextView tv = new TextView(context);
                tv.setText(Date_time_anouncement);
                // set some properties of rowTextView or something
                rowTextView.setText(value);
                ll.addView(rowTextView);
                ll.addView(tv);

//                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }
}
