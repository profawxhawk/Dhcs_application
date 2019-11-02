package com.example.dhcs_application;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.dhcs_application.R;


import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class frag1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.frag1_layout, container, false);
//        rootView.setContentView(R.layout.activity_main);
//        rootView.findViewById(R.id.)
        final LinearLayout lm = (LinearLayout) rootView.findViewById(R.id.lin);
        rootView.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {
                System.out.println("\n\nhola1\n\n");
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                LinearLayout ll = new LinearLayout(view.getContext());
                ll.setOrientation(LinearLayout.HORIZONTAL);
                final Button btn = new Button(view.getContext());
                btn.setId(1+1);
                btn.setText("Chess");
                btn.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                params.width = 1100;
                params.height=500;
               // btn.setBackgroundResource(R.drawable.chess);
                btn.setBackgroundResource(R.drawable.chess4);
                btn.setLayoutParams(params);
                btn.setTextSize(30);
                final int index = 1;
                ll.addView(btn);
                lm.addView(ll);
//                lm.addView(btn);
                System.out.println("\n\nhola2\n\n");

                btn.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i("TAG", "index :" + index);
                        Toast.makeText(getActivity().getApplicationContext(),"Clicked Button Index :" + index,Toast.LENGTH_LONG).show();
                    }
                });
                System.out.println("\n\nhola4\n\n");
            }
        });
        System.out.println("\n\nhola\n\n");
        return rootView;
//        return inflater.inflate(R.layout.frag1_layout, container, false);
    }
}
