package com.example.dhcs_application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class arun_Frag1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.arun_frag1_layout,container,false);
        Spinner spinner = view.findViewById(R.id.planets_spinner);
        String[] items = new String[]{"Rahul","Lesson 1 : 9/10","Lesson 2 : 10/10","Lesson 3 : 8/10"};
        com.example.dhcs_application.CustomAdapter adapter = new com.example.dhcs_application.CustomAdapter(getActivity(),android.R.layout.simple_spinner_dropdown_item,items,0);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setDropDownVerticalOffset(100);
        spinner.setDropDownWidth(1600);
        //no. 2
        Spinner spinner1 = view.findViewById(R.id.planets_spinner1);
        String[] items1 = new String[]{"Sachin","Lesson 1 : 9/10","Lesson 2 : 10/10","Lesson 3 : 8/10"};
        com.example.dhcs_application.CustomAdapter adapter1 = new com.example.dhcs_application.CustomAdapter(getActivity(),android.R.layout.simple_spinner_dropdown_item,items1,0);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setDropDownVerticalOffset(100);
        spinner1.setDropDownWidth(1600);
        //no.3
        Spinner spinner2 = view.findViewById(R.id.planets_spinner2);
        String[] items2 = new String[]{"Virat","Lesson 1 : 9/10","Lesson 2 : 10/10","Lesson 3 : 8/10"};
        com.example.dhcs_application.CustomAdapter adapter2 = new com.example.dhcs_application.CustomAdapter(getActivity(),android.R.layout.simple_spinner_dropdown_item,items2,0);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setDropDownVerticalOffset(100);
        spinner2.setDropDownWidth(1600);

        
        return view;
    }
}
