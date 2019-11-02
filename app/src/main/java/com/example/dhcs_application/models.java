package com.example.dhcs_application;

import android.support.v4.app.INotificationSideChannel;

import java.util.ArrayList;

public class models {

}
class User{
    public String id;
    /* other required member variables */
    public String email_id;
    public String firstname;
    public String lastname;
    public String mobile;
    ArrayList<Integer> Teaching_course_list;
    ArrayList<Integer> Enrolled_course_list;
    public User(String id,String email_id,String firstname,String lastname,String moblile){
        this.email_id=email_id;
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.mobile=moblile;
        Teaching_course_list=new ArrayList<>();
        Enrolled_course_list=new ArrayList<>();
    }
    public User() {}
    /* getter and setters */
}
class Course{
    static int count=1;
    public int course_id;
    public String Name;
    public int Instructor_id;
    public long Weekly_Fees;
    public String Description;
    public double Lat;
    public double Log;
    //    Course photo
//    Video Link
//    Resume
    ArrayList<Integer> Lesson_list_id;
    ArrayList<Integer> Enrolled_Users_id;
    Course(String Name, int int_id,long fees,String desc,double lat,double log){
        this.Name=Name;
        this.course_id=count;
        this.Instructor_id=int_id;
        this.Description=desc;
        this.Lat=lat;
        this.Log=log;
        Lesson_list_id=new ArrayList<>();
        Enrolled_Users_id=new ArrayList<>();
    }
}
class Lesson{

}