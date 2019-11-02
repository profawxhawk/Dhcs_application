package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter {

    private int hide;

    public CustomAdapter(@NonNull Context context, int textViewResourceId, @NonNull String[] objects,int hide) {
        super(context,  textViewResourceId, objects);
        this.hide=hide;
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v=null;
        if(position==this.hide){
            TextView tv = new TextView(getContext());
            tv.setVisibility(View.GONE);
            tv.setHeight(0);
            v=tv;
        }
        else v=super.getDropDownView(position, null, parent);
        return v;
    }
}
