package com.example.dhcs_application;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AnnouncementInstructors extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.announcement_instructors, container, false);
//        final LinearLayout linLay = (LinearLayout) rootView.findViewById(R.id.consLay2);
//        final ArrayList<String> announcements = new ArrayList<String>();
//        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Courses");
//        final TextView annTextView = (TextView) rootView.findViewById(R.id.annTextView);
//        final LinearLayout lin_add =rootView.findViewById(R.id.consLay);
        Button addAnnouncement = (Button) rootView.findViewById(R.id.add_ann);
//        final String[] arrCourseID = new String[1];
//        final int[] lastAnnVal = new int[1];

        //UPDATE THIS FROM PREVIOUS SCREEN
//        final String reqdCourseID = "1";
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        System.out.println("we here");
        addAnnouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hiiiiii");
                String newAnn = "Heyyyyyyy this is a new ANNOUNCEMENTTT";

//                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                        //Is this required??
//                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
//                        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                        Course currCourse = new Course();
//                        String res = "";
//                        for(DataSnapshot ds : dataSnapshot.getChildren()){
//                            currCourse = ds.getValue(Course.class);
//                            ds.getValue(Course.class).announcementList = new ArrayList<>();
//                            currCourse.announcementList = new ArrayList<>();
//                            currCourse.announcementList.add("FFFFFFFFFFFF");
//                            if(currCourse.getCourseID().equals(reqdCourseID) && currCourse.announcementList != null) {
//                                int len = currCourse.announcementList.size();
//                                for (int i = 0; i < len; i++) {
//                                    String curAn = currCourse.announcementList.get(i);
//                                    announcements.add(curAn);
//                                    res = res + "\n" + (i + 1) + ": " + curAn;
//                                    TextView tv = new TextView(rootView.getContext());
////                            annTextView.append((i + 1) + ": " + curAn + "\n");
//                                    tv.setText((i+1) + ": " + curAn);
//                                    linLay.addView(tv);
//                                    lastAnnVal[0] = (i + 1);
//                                }
//                                arrCourseID[0] = currCourse.getCourseID();
//                                break;
//                            }
//                        }
//
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });

//                announcements.add(newAnn);
//                dbRef.child(arrCourseID[0]).child("Announcements").setValue(announcements);
//                annTextView.append("" + (lastAnnVal[0] + 1) + ": " + newAnn);
            }
        });




        return inflater.inflate(R.layout.announcement_instructors,container,false);

    }

}
