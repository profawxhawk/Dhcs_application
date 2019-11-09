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
    public int lesson_id;
    public ArrayList<String>grades,user_name;
    public String name,content;
    public Lesson(){

    }
    public Lesson(int lessonid,String name,String content) {
        this.lesson_id = lessonid;
        this.grades = new ArrayList<>();
        this.user_name = new ArrayList<>();
        this.name = name;this.content=content;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public ArrayList<String> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<String> grades) {
        this.grades = grades;
    }

    public ArrayList<String> getUser_name() {
        return user_name;
    }

    public void setUser_name(ArrayList<String> user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class Course{

    public String courseID;
    public String name;
    public String instructorID;
    public double weeklyFees;
    public String description;
    public double lat;
    public double lon;
    //    Course photo
    //    Video Link
    //    Resume
    ArrayList<Integer> Lesson_list_id;
    ArrayList<Integer> Enrolled_Users_id,grades;
    ArrayList<String>  Enrolled_Users_name,Lesson_names;

    public Course(String name, String instructorID, double weeklyFees, String description, double lat, double lon) {
        this.name = name;
        this.instructorID = instructorID;
        this.weeklyFees = weeklyFees;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
        this.Lesson_list_id = new ArrayList<>();
        this.Enrolled_Users_id = new ArrayList<>();
        this.Enrolled_Users_name = new ArrayList<>();
        this.grades = new ArrayList<>();
        this.Lesson_names = new ArrayList<>();
    }

    public Course(){}


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

    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
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