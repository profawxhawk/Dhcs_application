package com.example.dhcs_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.gson.Gson;

public class InfoWindowCustom implements GoogleMap.InfoWindowAdapter{
    Context context;
    LayoutInflater inflater;
    public InfoWindowCustom(Context c){
        this.context=c;
    }
    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }    @Override
    public View getInfoWindow(Marker marker) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.pop_up_marker, null);
        Gson gson = new Gson();
        final MarkerInfo aMarkerInfo = gson.fromJson(marker.getSnippet(), MarkerInfo.class);
        TextView title = (TextView) v.findViewById(R.id.titile);
        TextView subtitle = (TextView) v.findViewById(R.id.description);
        title.setText(aMarkerInfo.title);
        subtitle.setText( aMarkerInfo.subtitle);
        Button join_course=(Button)v.findViewById(R.id.gotocourse);
        return v;
    }
}
