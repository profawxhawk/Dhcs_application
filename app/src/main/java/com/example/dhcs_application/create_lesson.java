package com.example.dhcs_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class create_lesson extends AppCompatActivity {


    Lesson entry;

    protected String get_lesson(){
        //pass lesson number from previous activity
        return new String("1");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText title = (EditText)findViewById(R.id.editText2);
        final EditText time = (EditText)findViewById(R.id.editText3);
        final EditText content = (EditText)findViewById(R.id.editText5);
        Button button = (Button)findViewById(R.id.button);
        entry = new Lesson();
        final DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("Courses").child(get_lesson());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title_send = title.getText().toString();
                String time_send = time.getText().toString();
                String content_send=content.getText().toString();
                entry.setContent(content_send);
                entry.setTime(time_send);
                entry.setTitle(title_send);
                reff.push().setValue(entry);

            }
        });
    }
}
