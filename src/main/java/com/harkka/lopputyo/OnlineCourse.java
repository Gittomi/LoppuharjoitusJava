package com.harkka.lopputyo;

public class OnlineCourse extends Course {
private boolean isOnlineCourse;


    public OnlineCourse(String courseID, String courseName, String studyPoints, boolean isOnlineCourse) {
        super(courseID, courseName, studyPoints);
    this.isOnlineCourse = isOnlineCourse;
    }


}
