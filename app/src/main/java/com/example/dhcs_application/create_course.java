package com.example.dhcs_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;


public class create_course extends AppCompatActivity {
    EditText name;
    Button send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_course);
        name=(EditText)findViewById(R.id.nametext);
        send=(Button)findViewById(R.id.submit);


        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),myskillspage.class);
                intent.putExtra("EdiTtEXTvALUE", name.getText().toString());
                startActivity(intent);

            }
        });


    }
}
