package com.example.dhcs_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class arun_Frag1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.arun_frag1_layout,container,false);
        LinearLayout layout = view.findViewById(R.id.rootcontainer);
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

        Course course = new Course("OS",2,234,"some shit",3232,4343);
        course.Enrolled_Users_id.add(1);
        course.Enrolled_Users_name.add("Ruaneq");
        course.grades.add(9);
        course.Enrolled_Users_id.add(2);
        course.Enrolled_Users_name.add("suaneq");
        course.grades.add(9);
        course.Enrolled_Users_id.add(3);
        course.Enrolled_Users_name.add("quaneq");
        course.grades.add(9);
        course.Enrolled_Users_id.add(4);
        course.Enrolled_Users_name.add("zuaneq");
        course.grades.add(9);
        course.Lesson_list_id.add(1);
        course.Lesson_list_id.add(2);
        course.Lesson_list_id.add(3);
        course.Lesson_names.add("Lesson 1");
        course.Lesson_names.add("Lesson 2");
        course.Lesson_names.add("Lesson 3");
        System.out.println("-----------------shut upt-------");

        for(int i=0;i<course.Lesson_list_id.size();i++){
            Spinner spinner = new Spinner(getActivity());
            //String[] items = new String[]{"Rahul","Lesson 1 : 9/10","Lesson 2 : 10/10","Lesson 3 : 8/10"};
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(course.Lesson_names.get(i));
            for(int j=0;j<course.Enrolled_Users_id.size();j++){
                arrayList.add(course.Enrolled_Users_name.get(j)+"  :  "+course.grades.get(j));
            }
            String items[] = new String[arrayList.size()];
            for(int j=0;j<arrayList.size();j++)items[j] = arrayList.get(j);
            for(int j=0;j<arrayList.size();j++)System.out.println(items[j]);

            CustomAdapter adapter = new CustomAdapter(getContext(),android.R.layout.simple_spinner_dropdown_item,items,0);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setDropDownVerticalOffset(100);
            spinner.setDropDownWidth(1600);
            layout.addView(spinner);
        }
        
        return view;
    }
}
