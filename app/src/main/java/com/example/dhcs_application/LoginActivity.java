package com.example.dhcs_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText email_id;
    EditText password;
    Button loginbutton;
    TextView registerview;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email_id=(EditText)findViewById(R.id.email_id);
        password=(EditText)findViewById(R.id.pass);
        loginbutton =(Button)findViewById(R.id.sign_in);
        registerview = (TextView)findViewById(R.id.signup);
        firebaseAuth=FirebaseAuth.getInstance();
        registerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {

            private int check_empty(String k,String j){
                if(TextUtils.isEmpty(k)){
                    Toast.makeText(getApplicationContext(),"Please enter "+j,Toast.LENGTH_SHORT).show();
                    return 0;
                }
                return 1;
            }
            private void login_user(){
                String email=email_id.getText().toString().trim();
                String pass1=password.getText().toString().trim();
                int val=check_empty(email,"email_id");
                if(val==0){
                    return ;
                }
                val=check_empty(pass1,"password");
                if(val==0){
                    return ;
                }
                firebaseAuth.signInWithEmailAndPassword(email,pass1).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"User login successfull",Toast.LENGTH_SHORT).show();
                            finish();
                            Intent coursepageIntent = new Intent(LoginActivity.this, profilepage.class);
                            startActivity(coursepageIntent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"User login not successfull, Try again later",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
            @Override
            public void onClick(View v) {
                login_user();
            }

        });
    }
}
