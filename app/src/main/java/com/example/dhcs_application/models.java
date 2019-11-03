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

class Lesson{
    private String title,time,content;

    public Lesson() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class Course{

    static int count = 1;
    public String courseID;
    public String name;
    public int instructorID;
    public double weeklyFees;
    public String description;
    public double lat;
    public double lon;
    //    Course photo
    //    Video Link
    //    Resume
    ArrayList<Integer> Lesson_list_id;
    ArrayList<Integer> Enrolled_Users_id;

    public Course(String name, int instructorID, double weeklyFees, String description, double lat, double lon) {
        this.courseID = count+"";
        this.name = name;
        this.instructorID = instructorID;
        this.weeklyFees = weeklyFees;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
        count+=1;
    }

    public Course(){}

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Course.count = count;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(int instructorID) {
        this.instructorID = instructorID;
    }

    public double getWeeklyFees() {
        return weeklyFees;
    }

    public void setWeeklyFees(double weeklyFees) {
        this.weeklyFees = weeklyFees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public ArrayList<Integer> getLesson_list_id() {
        return Lesson_list_id;
    }

    public void setLesson_list_id(ArrayList<Integer> lesson_list_id) {
        Lesson_list_id = lesson_list_id;
    }

    public ArrayList<Integer> getEnrolled_Users_id() {
        return Enrolled_Users_id;
    }

    public void setEnrolled_Users_id(ArrayList<Integer> enrolled_Users_id) {
        Enrolled_Users_id = enrolled_Users_id;
    }
}
