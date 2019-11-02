package com.example.dhcs_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText email_id;
    EditText password2;
    EditText firstname;
    EditText lastname;
    EditText password1;
    Button signupbutton;
    EditText mobile;
    TextView loginview;
    FirebaseAuth firebaseAuth;
    DatabaseReference dbusers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        password2=(EditText)findViewById(R.id.password2);
        firstname=(EditText)findViewById(R.id.firstname);
        lastname=(EditText)findViewById(R.id.last_name);
        email_id=(EditText)findViewById(R.id.email_id);
        password1=(EditText)findViewById(R.id.password1);
        mobile=(EditText)findViewById(R.id.mobile);
        signupbutton =(Button)findViewById(R.id.signup);
        loginview = (TextView)findViewById(R.id.login_redirect);
        firebaseAuth=FirebaseAuth.getInstance();
        loginview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {

            private int check_empty(String k,String j){
                if(TextUtils.isEmpty(k)){
                    Toast.makeText(getApplicationContext(),"Please enter "+j,Toast.LENGTH_SHORT).show();
                    return 0;
                }
                return 1;
            }
            private void register_user(){
                final String email=email_id.getText().toString().trim();
                final String pass1=password1.getText().toString().trim();
                String pass2=password2.getText().toString().trim();
                final String first=firstname.getText().toString().trim();
                final String last=lastname.getText().toString().trim();
                final String mobile_number=mobile.getText().toString().trim();

                int val=check_empty(email,"email_id");
                if(val==0){
                    return ;
                }
                val=check_empty(pass1,"password");
                if(val==0){
                    return ;
                }
                val=check_empty(pass2,"confirmation password");
                if(val==0){
                    return ;
                }
                val=check_empty(mobile_number,"mobile");
                if(val==0){
                    return ;
                }
                val=check_empty(first,"firstname");
                if(val==0){
                    return ;
                }
                val=check_empty(last,"lastname");
                if(val==0){
                    return ;
                }
                System.out.println(pass1.equals(pass2));
                if(!pass1.equals(pass2)){
                    Toast.makeText(getApplicationContext(),"passwords do not match",Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.createUserWithEmailAndPassword(email,pass1).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                dbusers = FirebaseDatabase.getInstance().getReference("users");
                                Toast.makeText(getApplicationContext(),"User registration successfull",Toast.LENGTH_SHORT).show();
                                finish();
                                String user_id= FirebaseAuth.getInstance().getCurrentUser().getUid();
                                User user=new User(user_id,email,first,last,mobile_number);
                                dbusers.child(user_id).setValue(user);
                                Intent profilepageIntent = new Intent(getApplicationContext(),profilepage.class);
                                startActivity(profilepageIntent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"User registration not successfull, try again",Toast.LENGTH_SHORT).show();
                            }
                    }
                });

            }
            @Override
            public void onClick(View v) {
                register_user();
            }

        });
    }
}
